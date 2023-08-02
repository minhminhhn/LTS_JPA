package com.example.courses.Repository;

import com.example.courses.Models.NgayHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NgayHocRepo extends JpaRepository<NgayHoc, Integer> {
}
