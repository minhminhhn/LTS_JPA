package com.example.courses.Repository;

import com.example.courses.Models.KhoaHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoaHocRepo extends JpaRepository<KhoaHoc, Integer> {
}
