package com.example.quanlymonan.Repository;

import com.example.quanlymonan.Models.LoaiMonAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiMonAnRepo extends JpaRepository<LoaiMonAn, Integer> {
}
