package com.lts.quanlykhoahoc.services;

import com.lts.quanlykhoahoc.models.response.ApiResponse;
import com.lts.quanlykhoahoc.models.taikhoan.QuyenHan;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IQuyenHanService {
    public ResponseEntity<ApiResponse> addNew(QuyenHan quyenHan);
    public ResponseEntity<ApiResponse> reamke(QuyenHan quyenHanNew);
    public ResponseEntity<ApiResponse> remove(int loaiQuyenHanId);
    public ResponseEntity<ApiResponse<List<QuyenHan>>> getAll();
}
