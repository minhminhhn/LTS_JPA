package com.example.phieuthu.Repositoties;

import com.example.phieuthu.Models.PhieuThu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuThuRepo extends JpaRepository<PhieuThu, Integer> {
}
