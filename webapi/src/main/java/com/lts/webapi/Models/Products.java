package com.lts.webapi.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.metamodel.model.domain.IdentifiableDomainType;

import java.util.Set;

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private int productId;

    @Column(name = "productname")
    private String productName;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
    @JsonManagedReference
    private Set<ProductDetailPropertyDetails> productDetailPropertyDetails;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
    @JsonManagedReference
    private Set<Properties> properties;

    public Set<ProductDetailPropertyDetails> getProductDetailPropertyDetails() {
        return productDetailPropertyDetails;
    }

    public void setProductDetailPropertyDetails(Set<ProductDetailPropertyDetails> productDetailPropertyDetails) {
        this.productDetailPropertyDetails = productDetailPropertyDetails;
    }

    public Set<Properties> getProperties() {
        return properties;
    }

    public void setProperties(Set<Properties> properties) {
        this.properties = properties;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
