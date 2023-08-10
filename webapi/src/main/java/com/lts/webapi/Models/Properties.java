package com.lts.webapi.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "properties")
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "propertyid")
    private int propertyId;

    @Column(name = "productid", insertable=false, updatable=false)
    private int productId;

    @Column(name = "propertyname")
    private String propertyName;

    @Column(name = "propertysort")
    private int propertySort;

    @ManyToOne()
    @JoinColumn(name = "productid")
    @JsonBackReference
    private Products products;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "properties")
    @JsonManagedReference
    private Set<PropertyDetails> propertyDetails;

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Set<PropertyDetails> getPropertyDetails() {
        return propertyDetails;
    }

    public void setPropertyDetails(Set<PropertyDetails> propertyDetails) {
        this.propertyDetails = propertyDetails;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public int getPropertySort() {
        return propertySort;
    }

    public void setPropertySort(int propertySort) {
        this.propertySort = propertySort;
    }
}
