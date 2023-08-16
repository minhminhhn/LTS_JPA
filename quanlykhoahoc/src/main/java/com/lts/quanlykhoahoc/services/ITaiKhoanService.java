package com.lts.quanlykhoahoc.services;

import com.lts.quanlykhoahoc.models.response.ApiResponse;
import com.lts.quanlykhoahoc.models.taikhoan.TaiKhoan;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITaiKhoanService {
    public ResponseEntity<ApiResponse> addNew(TaiKhoan taiKhoan);
    public ResponseEntity<ApiResponse> reamke(TaiKhoan taiKhoan);
    public ResponseEntity<ApiResponse> remove(int taiKhoanId);
    public ResponseEntity<ApiResponse<List<TaiKhoan>>> getAll();
    public boolean get(String taiKhoan);
    public String normalizeName(String name);
}
