package com.lts.quanlykhoahoc.repositories;

import com.lts.quanlykhoahoc.models.hocvien.HocVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HocVienRepo extends JpaRepository<HocVien, Integer> {
    HocVien findBySoDienThoai(String soDienThoai);
    HocVien findByEmail(String email);
}
