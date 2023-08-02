package com.example.quanlytrungtam.Repository;

import com.example.quanlytrungtam.Models.HocVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HocVienRepo extends JpaRepository<HocVien, Integer> {
}
