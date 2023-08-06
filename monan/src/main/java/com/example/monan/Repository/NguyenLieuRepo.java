package com.example.monan.Repository;

import com.example.monan.Models.MonAn;
import com.example.monan.Models.NguyenLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NguyenLieuRepo extends JpaRepository<NguyenLieu, Integer> {

    @Query("SELECT m FROM MonAn m WHERE m.id IN " +
            "(SELECT DISTINCT c.monAn.id FROM CongThuc c WHERE c.nguyenLieu.tenNguyenLieu LIKE %:tenNguyenLieu%)")
    List<MonAn> findByTenNguyenLieu(@Param("tenNguyenLieu") String tenNguyenLieu);

}
