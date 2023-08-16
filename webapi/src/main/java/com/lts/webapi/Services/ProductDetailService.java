package com.lts.webapi.Services;

import com.lts.webapi.Models.ProductDetails;
import com.lts.webapi.Models.requestobject.PurchaseRequest;
import com.lts.webapi.Models.responobject.Response;
import com.lts.webapi.Repositories.ProductDetailPropertyDetailsRepo;
import com.lts.webapi.Repositories.ProductDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDetailService implements IProductDetailService {
    @Autowired
    private ProductDetailsRepo productDetailsRepo;

    @Autowired
    private ProductDetailPropertyDetailsRepo productDetailPropertyDetailsRepo;


    @Override
    public ResponseEntity<Response<List<ProductDetails>>> getAllProductDetail() {
        List<ProductDetails> productDetails = productDetailsRepo.findAll();

        List<ProductDetails> result = new ArrayList<>();
        productDetails.forEach(x -> {
            if (x.getChildList().isEmpty()) {
                result.add(x);
            }
        });

        Response<List<ProductDetails>> response = new Response<>(200, null,
                "Lấy danh sách sản phẩm thành công.", result);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Response> purchaseProduct(List<PurchaseRequest> purchaseRequests) {
        for (PurchaseRequest request : purchaseRequests) {
            int productDetailId = request.getProductDetailId();
            int quantity = request.getQuantity();

            ProductDetails productDetails = productDetailsRepo.findById(productDetailId).orElse(null);
            if (productDetails == null) {
                Response<List<ProductDetails>> response = new Response<>(404,
                        "Sản phẩm " + request.getProductDetailId() + " không tồn tại", null);
                return ResponseEntity.badRequest().body(response);
            }
            if (productDetails.getQuantity() < quantity) {
                Response<List<ProductDetails>> response = new Response<>(404,
                        "Sản phẩm " + request.getProductDetailId() + " không đủ số lượng",null
                        );
                return ResponseEntity.badRequest().body(response);
            }
            if (productDetails.getQuantity() == 0) {
                Response<List<ProductDetails>> response = new Response<>(404,
                        "Sản phẩm " + request.getProductDetailId() + " hết hàng",null
                );
                return ResponseEntity.badRequest().body(response);
            }
            while (productDetails != null) {
                productDetails.setQuantity(productDetails.getQuantity() - request.getQuantity());
                productDetailsRepo.save(productDetails);
                productDetails = productDetails.getParent();
            }

        }

        Response response = new Response<>(200, null,
                "Mua sản phẩm thành công");

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<String> updateQuantity0(int productDetailId) {
        List<Integer> list = productDetailPropertyDetailsRepo.listProductDetail(productDetailId);
        List<ProductDetails> productDetailsAll = productDetailsRepo.findAll();

        List<ProductDetails> listProductDetail = new ArrayList<>();
        productDetailsAll.forEach(x -> {
            if (x.getChildList().isEmpty() && list.contains(x.getProductDetailId())) {
                listProductDetail.add(x);
            }
        });
        for (int i = 0; i < listProductDetail.size(); i++) {
            ProductDetails productDetail = listProductDetail.get(i);
            if (productDetail.getParent() != null) {
                ProductDetails parent = productDetail.getParent();
                if (!listProductDetail.contains(parent)) {
                    System.out.println("not null");
                    parent.setQuantity(productDetail.getQuantity());
                    listProductDetail.add(parent);
                } else {
                    parent.setQuantity(parent.getQuantity() + productDetail.getQuantity());
                }
            }
        }
        for (ProductDetails productDetail : listProductDetail) {
            System.out.println("get: " + productDetail);
        }
        return ResponseEntity.ok("Chập nhật số lượng thành công");
    }

    @Override
    public ResponseEntity<Response> updateQuantity(ProductDetails productDetailNew) {
        ProductDetails productDetails = productDetailsRepo.findById(productDetailNew.getProductDetailId()).orElse(null);
        if (productDetails == null) {
            Response<List<ProductDetails>> response = new Response<>(404,
                    "Sản phẩm không tồn tại.",null
            );
            return ResponseEntity.badRequest().body(response);
        }
        if (!productDetails.getChildList().isEmpty()) {
            Response<List<ProductDetails>> response = new Response<>(404,
                    "Không thể cập nhật số lượng.",null
            );
            return ResponseEntity.badRequest().body(response);
        }
        int oldQuantity = productDetails.getQuantity();
        productDetails.setQuantity(productDetailNew.getQuantity());
        productDetailsRepo.save(productDetails);
        productDetails = productDetails.getParent();
        while (productDetails != null) {
            productDetails.setQuantity(productDetails.getQuantity() - oldQuantity + productDetailNew.getQuantity());
            productDetailsRepo.save(productDetails);
            productDetails = productDetails.getParent();
        }

        Response<List<ProductDetails>> response = new Response<>(200,
                null,"Chập nhật số lượng thành công"
        );
        return ResponseEntity.ok(response);
    }

}
