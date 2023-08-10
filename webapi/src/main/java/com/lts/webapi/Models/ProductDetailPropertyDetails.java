package com.lts.webapi.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "productdetailpropertydetails")
public class ProductDetailPropertyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productdetailpropertydetailid")
    private int productDetailPropertyDetailId;

    @Column(name = "productdetailid", insertable=false, updatable=false)
    private int productDetailId;

    @Column(name = "propertydetailid", insertable=false, updatable=false)
    private int propertyDetailId;

    @Column(name = "productid", insertable=false, updatable=false)
    private int productId;

    @ManyToOne()
    @JoinColumn(name = "productdetailid")
    @JsonBackReference
    private ProductDetails productDetails;

    @ManyToOne()
    @JoinColumn(name = "propertydetailid")
    @JsonBackReference
    private PropertyDetails propertyDetails;

    @ManyToOne()
    @JoinColumn(name = "productid")
    @JsonBackReference
    private Products products;

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    public PropertyDetails getPropertyDetails() {
        return propertyDetails;
    }

    public void setPropertyDetails(PropertyDetails propertyDetails) {
        this.propertyDetails = propertyDetails;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getProductDetailPropertyDetailId() {
        return productDetailPropertyDetailId;
    }

    public void setProductDetailPropertyDetailId(int productDetailPropertyDetailId) {
        this.productDetailPropertyDetailId = productDetailPropertyDetailId;
    }

    public int getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(int productDetailId) {
        this.productDetailId = productDetailId;
    }

    public int getPropertyDetailId() {
        return propertyDetailId;
    }

    public void setPropertyDetailId(int propertyDetailId) {
        this.propertyDetailId = propertyDetailId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
