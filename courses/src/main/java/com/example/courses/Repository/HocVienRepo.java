package com.example.courses.Repository;

import com.example.courses.Models.HocVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HocVienRepo extends JpaRepository<HocVien, Integer> {
}
