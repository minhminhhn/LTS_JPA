package com.lts.webapi.Repositories;

import com.lts.webapi.Models.PropertyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyDetailsRepo extends JpaRepository<PropertyDetails, Integer> {
}
