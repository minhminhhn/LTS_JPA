package com.lts.quanlykhoahoc.repositories;

import com.lts.quanlykhoahoc.models.taikhoan.QuyenHan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuyenHanRepo extends JpaRepository<QuyenHan, Integer> {
}
