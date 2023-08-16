package com.lts.quanlykhoahoc.repositories;

import com.lts.quanlykhoahoc.models.taikhoan.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanRepo extends JpaRepository<TaiKhoan, Integer> {
}
