package com.lts.webapi.Repositories;

import com.lts.webapi.Models.ProductDetailPropertyDetails;
import jakarta.persistence.PrePersist;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailPropertyDetailsRepo extends JpaRepository<ProductDetailPropertyDetails, Integer> {

    @Query("SELECT distinct p.productDetailId from ProductDetailPropertyDetails p where p.productId = :productId")
    List<Integer> listProductDetail(@Param("productId") int productId);
}
