package com.lts.webapi.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "productdetails")
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productdetailid")
    private int productDetailId;

    @Column(name = "productpropertyname")
    private String productPropertyName;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private float price;

    @Column(name = "shellprice")
    private float shellPrice;


    // Trong lớp PropertyDetails
    @ManyToOne
    @JoinColumn(name = "parentid")
    @JsonBackReference
    private ProductDetails parent;

    // Trong lớp ProductDetails
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    @JsonManagedReference
    private Set<ProductDetails> childList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productDetails")
    @JsonManagedReference
    private Set<ProductDetailPropertyDetails> productDetailPropertyDetails;

    public Set<ProductDetails> getChildList() {
        return childList;
    }

    public void setChildList(Set<ProductDetails> childList) {
        this.childList = childList;
    }

    public int getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(int productDetailId) {
        this.productDetailId = productDetailId;
    }

    public String getProductPropertyName() {
        return productPropertyName;
    }

    public void setProductPropertyName(String productPropertyName) {
        this.productPropertyName = productPropertyName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getShellPrice() {
        return shellPrice;
    }

    public void setShellPrice(float shellPrice) {
        this.shellPrice = shellPrice;
    }


    public ProductDetails getParent() {
        return parent;
    }

    public void setParent(ProductDetails parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "productDetailId=" + productDetailId +
                ", productPropertyName='" + productPropertyName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
