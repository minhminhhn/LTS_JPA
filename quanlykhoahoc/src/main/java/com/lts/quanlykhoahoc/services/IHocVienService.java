package com.lts.quanlykhoahoc.services;

import com.lts.quanlykhoahoc.models.hocvien.HocVien;
import com.lts.quanlykhoahoc.models.khoahoc.KhoaHoc;
import com.lts.quanlykhoahoc.models.response.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IHocVienService {
    public ResponseEntity<ApiResponse> addNew(HocVien hocVien);
    public ResponseEntity<ApiResponse> remake(HocVien hocVienNew);
    public ResponseEntity<ApiResponse> remove(int hocVienId);
    public ResponseEntity<ApiResponse<List<HocVien>>> getAll();

}
