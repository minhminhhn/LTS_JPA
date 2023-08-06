package com.example.monan.Repository;

import com.example.monan.Models.MonAn;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonAnRepo extends JpaRepository<MonAn, Integer> {
    @Query("SELECT m FROM MonAn m WHERE m.tenMon LIKE %:tenMon%")
    List<MonAn> findByTenMon(@Param("tenMon") String tenMon);
}
