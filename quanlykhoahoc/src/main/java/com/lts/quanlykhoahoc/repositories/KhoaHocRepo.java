package com.lts.quanlykhoahoc.repositories;

import com.lts.quanlykhoahoc.models.khoahoc.KhoaHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoaHocRepo extends JpaRepository<KhoaHoc, Integer> {
    @Query("select k from KhoaHoc k where k.tenKhoaHoc = :tenKhoaHoc")
    public KhoaHoc getKhoaHocByName(@Param("tenKhoaHoc") String tenKhoahoc);

}
