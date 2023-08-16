package com.lts.quanlykhoahoc.repositories;

import com.lts.quanlykhoahoc.models.baiviet.LoaiBaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiBaiVietRepo extends JpaRepository<LoaiBaiViet, Integer> {
}
