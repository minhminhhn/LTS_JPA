package com.lts.webapi.Services;

import com.lts.webapi.Models.ProductDetails;
import com.lts.webapi.Models.requestobject.PurchaseRequest;
import com.lts.webapi.Models.responobject.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductDetailService {
    public ResponseEntity<Response<List<ProductDetails>>> getAllProductDetail();
    public ResponseEntity<Response> purchaseProduct(List<PurchaseRequest> purchaseRequests);
    public ResponseEntity<String> updateQuantity0(int productDetailId);
    public ResponseEntity<Response> updateQuantity(ProductDetails productDetail);

}
