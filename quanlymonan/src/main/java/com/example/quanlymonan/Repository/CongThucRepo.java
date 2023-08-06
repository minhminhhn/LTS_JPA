package com.example.quanlymonan.Repository;

import com.example.quanlymonan.Models.CongThuc;
import com.example.quanlymonan.Models.MonAn;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CongThucRepo extends JpaRepository<CongThuc, Integer> {
    @Query("select c from CongThuc c where c.monAnId = :monAnId")
    List<CongThuc> getCongThuc(@Param("monAnId") int monAnId);
    @Query("select m from MonAn m where m.monAnId in" +
            "(select distinct c.monAnId from CongThuc c where c.nguyenLieuId = :nguyenLieuId)")
    List<MonAn> getListMonAn(@Param("nguyenLieuId") int nguyenLieuId);
}