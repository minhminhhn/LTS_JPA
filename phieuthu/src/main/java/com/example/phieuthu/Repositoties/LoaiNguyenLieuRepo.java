package com.example.phieuthu.Repositoties;

import com.example.phieuthu.Models.LoaiNguyenLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiNguyenLieuRepo extends JpaRepository<LoaiNguyenLieu, Integer> {
}
