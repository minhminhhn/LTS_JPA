package com.example.phieuthu.Repositoties;

import com.example.phieuthu.Models.ChiTietPhieuThu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietPhieuThuRepo extends JpaRepository<ChiTietPhieuThu, Integer> {
}
