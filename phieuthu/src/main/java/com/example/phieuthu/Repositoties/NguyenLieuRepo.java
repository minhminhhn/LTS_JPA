package com.example.phieuthu.Repositoties;

import com.example.phieuthu.Models.NguyenLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguyenLieuRepo extends JpaRepository<NguyenLieu, Integer> {
}
