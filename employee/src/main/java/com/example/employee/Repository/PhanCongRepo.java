package com.example.employee.Repository;

import com.example.employee.Models.PhanCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhanCongRepo extends JpaRepository<PhanCong, Integer> {
}
