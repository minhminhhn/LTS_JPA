package com.example.phieuthu.Repositoties;

import com.example.phieuthu.Models.PhieuThu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PhieuThuRepo extends JpaRepository<PhieuThu, Integer> {
    @Query("SELECT r FROM PhieuThu r WHERE r.ngayLap = :date")
    List<PhieuThu> findByDate(@Param("date") LocalDate date);
}
