package com.example.quanlytrungtam.Repository;

import com.example.quanlytrungtam.Models.HocVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HocVienRepo extends JpaRepository<HocVien, Integer> {
    @Query(value = "SELECT * FROM hocvien order by ngaydangky desc", nativeQuery = true)
    List<HocVien> findAllHocVien();

    @Query(value = "SELECT * FROM hocvien where year(ngay_sinh) = 2002 and hoten like  '% An'", nativeQuery = true)
    List<HocVien> findHocVien();
}
