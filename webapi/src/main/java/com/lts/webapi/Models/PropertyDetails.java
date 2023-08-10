package com.lts.webapi.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.aspectj.util.IStructureModel;

import java.util.Set;

@Entity
@Table(name = "propertydetails")
public class PropertyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "propertydetailid")
    private int propertyDetailId;

    @Column(name = "propertyid", insertable=false, updatable=false)
    private int propertyId;

    @Column(name = "propertydetailcode")
    private String propertyDetailCode;

    @Column(name = "propertydetaildetail")
    private String propertyDetailDetail;

    public String getPropertyDetailDetail() {
        return propertyDetailDetail;
    }

    public void setPropertyDetailDetail(String propertyDetailDetail) {
        this.propertyDetailDetail = propertyDetailDetail;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "propertyDetails")
    @JsonManagedReference
    private Set<ProductDetailPropertyDetails> productDetailPropertyDetails;

    @ManyToOne()
    @JoinColumn(name = "propertyid")
    @JsonBackReference()
    private Properties properties;

    public Set<ProductDetailPropertyDetails> getProductDetailPropertyDetails() {
        return productDetailPropertyDetails;
    }

    public void setProductDetailPropertyDetails(Set<ProductDetailPropertyDetails> productDetailPropertyDetails) {
        this.productDetailPropertyDetails = productDetailPropertyDetails;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public int getPropertyDetailId() {
        return propertyDetailId;
    }

    public void setPropertyDetailId(int propertyDetailId) {
        this.propertyDetailId = propertyDetailId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyDetailCode() {
        return propertyDetailCode;
    }

    public void setPropertyDetailCode(String propertyDetailCode) {
        this.propertyDetailCode = propertyDetailCode;
    }
}
