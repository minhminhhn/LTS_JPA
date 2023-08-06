package com.example.quanlymonan.Repository;

import com.example.quanlymonan.Models.MonAn;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonAnRepo extends JpaRepository<MonAn, Integer> {
}
