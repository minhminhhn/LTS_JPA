package com.lts.quanlykhoahoc.repositories;

import com.lts.quanlykhoahoc.models.baiviet.ChuDe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuDeRepo extends JpaRepository<ChuDe, Integer> {
}
