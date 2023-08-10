package com.lts.webapi.Services;

import com.lts.webapi.Models.ProductDetails;
import com.lts.webapi.Models.requestobject.PurchaseRequest;
import com.lts.webapi.Models.responobject.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductDetailService {
    public Response<List<ProductDetails>> getAllProductDetail();
    public ResponseEntity<String> purchaseProduct(List<PurchaseRequest> purchaseRequests);
    public ResponseEntity<String> updateQuantity0(int productDetailId);
    public ResponseEntity<String> updateQuantity(ProductDetails productDetail);

}
