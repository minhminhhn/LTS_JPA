package com.example.quanlymonan.Repository;

import com.example.quanlymonan.Models.MonAn;
import com.example.quanlymonan.Models.NguyenLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NguyenLieuRepo extends JpaRepository<NguyenLieu, Integer> {

    @Query("select n from NguyenLieu n where n.tenNguyenLieu = :tenNguyenLieu")
    public NguyenLieu getNguyenLieu(@Param("tenNguyenLieu") String tenNguyenLieu);
}
