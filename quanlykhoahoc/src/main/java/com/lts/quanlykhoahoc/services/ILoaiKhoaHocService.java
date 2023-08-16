package com.lts.quanlykhoahoc.services;

import com.lts.quanlykhoahoc.models.khoahoc.LoaiKhoaHoc;
import com.lts.quanlykhoahoc.models.response.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface ILoaiKhoaHocService {
    public ResponseEntity<ApiResponse> addNew(LoaiKhoaHoc loaiKhoaHoc);
    public ResponseEntity<ApiResponse> suaLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc);
    public ResponseEntity<ApiResponse> xoaLoaiKhoaHoc(int loaiKhoaHocId);
}
