package com.example.monan.Repository;

import com.example.monan.Models.MonAn;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonAnRepo extends JpaRepository<MonAn, Integer> {
}
