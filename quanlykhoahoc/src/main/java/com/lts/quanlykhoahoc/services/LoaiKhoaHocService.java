package com.lts.quanlykhoahoc.services;

import com.lts.quanlykhoahoc.models.khoahoc.LoaiKhoaHoc;
import com.lts.quanlykhoahoc.models.response.ApiResponse;
import com.lts.quanlykhoahoc.repositories.LoaiKhoaHocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoaiKhoaHocService implements ILoaiKhoaHocService{

    @Autowired
    private LoaiKhoaHocRepo loaiKhoaHocRepo;
    @Override
    public ResponseEntity<ApiResponse> addNew(LoaiKhoaHoc loaiKhoaHoc) {
        loaiKhoaHocRepo.save(loaiKhoaHoc);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                200, null, "Thêm loại khóa học thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse> suaLoaiKhoaHoc(LoaiKhoaHoc loaiKhoaHoc) {
        LoaiKhoaHoc loaiKhoaHoc1 = loaiKhoaHocRepo.findById(loaiKhoaHoc.getLoaiKhoaHocId()).orElse(null);
        if(loaiKhoaHoc1 == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                    404, "loại khóa học không tồn tại", null);
            return  ResponseEntity.status(404).body(response);
        }
        loaiKhoaHocRepo.save(loaiKhoaHoc);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                200, null, "Thêm loại khóa học thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse> xoaLoaiKhoaHoc(int loaiKhoaHocId) {
        LoaiKhoaHoc loaiKhoaHoc = loaiKhoaHocRepo.findById(loaiKhoaHocId).orElse(null);
        if(loaiKhoaHoc == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                    404, "Khóa học không tồn tại", null);
            return  ResponseEntity.status(404).body(response);
        }
        loaiKhoaHocRepo.delete(loaiKhoaHoc);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                200, null, "Xóa loại khóa học thành công.");
        return ResponseEntity.ok(response);
    }
}
