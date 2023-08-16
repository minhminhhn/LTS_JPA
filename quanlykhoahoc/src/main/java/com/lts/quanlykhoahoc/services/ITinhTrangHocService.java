package com.lts.quanlykhoahoc.services;

import com.lts.quanlykhoahoc.models.dangkyhoc.TinhTrangHoc;
import com.lts.quanlykhoahoc.models.hocvien.HocVien;
import com.lts.quanlykhoahoc.models.khoahoc.LoaiKhoaHoc;
import com.lts.quanlykhoahoc.models.response.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITinhTrangHocService {
    public ResponseEntity<ApiResponse> addNew(TinhTrangHoc tinhTrangHoc);
    public ResponseEntity<ApiResponse> remake(TinhTrangHoc tinhTrangHocNew);
    public ResponseEntity<ApiResponse> remove(int tinhTrangHocId);
    public ResponseEntity<ApiResponse<List<TinhTrangHoc>>> getAll();

}
