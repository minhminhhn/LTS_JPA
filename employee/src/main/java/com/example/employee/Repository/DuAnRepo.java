package com.example.employee.Repository;

import com.example.employee.Models.DuAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuAnRepo extends JpaRepository<DuAn, Integer> {
}
