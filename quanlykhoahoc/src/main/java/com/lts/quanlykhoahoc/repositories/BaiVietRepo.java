package com.lts.quanlykhoahoc.repositories;

import com.lts.quanlykhoahoc.models.baiviet.BaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BaiVietRepo extends JpaRepository<BaiViet, Integer> {
}
