package com.lts.quanlykhoahoc.repositories;

import com.lts.quanlykhoahoc.models.khoahoc.LoaiKhoaHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiKhoaHocRepo extends JpaRepository<LoaiKhoaHoc, Integer> {
}
