package com.lts.quanlykhoahoc.services;

import com.lts.quanlykhoahoc.models.khoahoc.KhoaHoc;
import com.lts.quanlykhoahoc.models.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface IKhoaHocService {
    public ResponseEntity<ApiResponse> addNew(KhoaHoc khoaHoc);
    public ResponseEntity<ApiResponse> suaKhoaHoc(KhoaHoc khoaHocNew);
    public ResponseEntity<ApiResponse> xoaKhoaHoc(int khoaHocId);
    public ResponseEntity<ApiResponse<Map<String, Object>>> getAll(int page, int size);
    public ResponseEntity<ApiResponse<KhoaHoc>> findByName(String tenKhoaHoc);
    public void updateSoLuong(KhoaHoc khoaHoc);
}
