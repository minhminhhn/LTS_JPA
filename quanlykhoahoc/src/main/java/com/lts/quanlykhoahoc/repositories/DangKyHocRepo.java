package com.lts.quanlykhoahoc.repositories;

import com.lts.quanlykhoahoc.models.dangkyhoc.DangKyHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DangKyHocRepo extends JpaRepository<DangKyHoc, Integer> {
}
