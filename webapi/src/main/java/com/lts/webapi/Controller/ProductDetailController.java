package com.lts.webapi.Controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lts.webapi.Models.ProductDetails;
import com.lts.webapi.Models.requestobject.PurchaseRequest;
import com.lts.webapi.Models.responobject.Response;
import com.lts.webapi.Repositories.ProductDetailPropertyDetailsRepo;
import com.lts.webapi.Repositories.ProductDetailsRepo;
import com.lts.webapi.Services.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/productdetail")
public class ProductDetailController {
    @Autowired
    private ProductDetailService productDetailService;
    @Autowired
    private ProductDetailPropertyDetailsRepo productDetailPropertyDetailsRepo;


    @RequestMapping(value = "getall", method = RequestMethod.GET)
    public ResponseEntity<Response<List<ProductDetails>>> getAll() {
        return productDetailService.getAllProductDetail();
    }

    @RequestMapping(value = "purchase")
    public ResponseEntity<Response> purchaseProducts(@RequestBody String purchase) {
        Gson gson = new Gson();
        java.lang.reflect.Type listType = new TypeToken<List<PurchaseRequest>>(){}.getType();
        List<PurchaseRequest> requests = gson.fromJson(purchase, listType);

        return productDetailService.purchaseProduct(requests);
    }
    @RequestMapping(value = "test")
    public ResponseEntity<String> test(@RequestParam int productId){
        return productDetailService.updateQuantity0(productId);
    }

    @RequestMapping(value = "updatequantity", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateQuantity(@RequestBody String productDetail){
        Gson gson = new Gson();
        ProductDetails productDetails = gson.fromJson(productDetail, ProductDetails.class);
        return productDetailService.updateQuantity(productDetails);
    }
}
