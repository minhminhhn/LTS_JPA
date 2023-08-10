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
    public Response<List<ProductDetails>> getAllProductDetail() {
        List<ProductDetails> productDetails = productDetailsRepo.findAll();

        List<ProductDetails> result = new ArrayList<>();
        productDetails.forEach(x -> {
            if (x.getChildList().isEmpty()) {
                result.add(x);
            }
        });

        Response<List<ProductDetails>> response = new Response<>();
        response.setData(result);
        response.setStatus(2);
        response.setMessage("Lấy danh sách sản phẩm thành công.");

        return response;
    }

    @Override
    public ResponseEntity<String> purchaseProduct(List<PurchaseRequest> purchaseRequests) {
        for (PurchaseRequest request : purchaseRequests) {
            int productDetailId = request.getProductDetailId();
            int quantity = request.getQuantity();

            ProductDetails productDetails = productDetailsRepo.findById(productDetailId).orElse(null);
            if (productDetails == null) {
                return ResponseEntity.badRequest().body("Sản phẩm " + request.getProductDetailId() + " không tồn tại");
            }
            if (productDetails.getQuantity() < quantity) {
                return ResponseEntity.badRequest().body("Sản phẩm " + request.getProductDetailId() + " không đủ số lượng");
            }
            if (productDetails.getQuantity() == 0) {
                return ResponseEntity.badRequest().body("Sản phẩm " + request.getProductDetailId() + " hết hàng");
            }
            while (productDetails != null) {
                productDetails.setQuantity(productDetails.getQuantity() - request.getQuantity());
                productDetailsRepo.save(productDetails);
                System.out.println("get: " + productDetails.toString());
                productDetails = productDetails.getParent();
            }

        }
        return ResponseEntity.ok("Mua sản phẩm thành công");
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
    public ResponseEntity<String> updateQuantity(ProductDetails productDetailNew) {
        ProductDetails productDetails = productDetailsRepo.findById(productDetailNew.getProductDetailId()).orElse(null);
        if (productDetails == null) {
            return ResponseEntity.badRequest().body("Sản phẩm không tồn tại.");
        }
        if (!productDetails.getChildList().isEmpty()) {
            return ResponseEntity.badRequest().body("Không thể cập nhật số lượng.");
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

        return ResponseEntity.ok("Chập nhật số lượng thành công");
    }

}
