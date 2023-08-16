package com.lts.quanlykhoahoc.services;

import com.lts.quanlykhoahoc.models.dangkyhoc.DangKyHoc;
import com.lts.quanlykhoahoc.models.dangkyhoc.TinhTrangHoc;
import com.lts.quanlykhoahoc.models.hocvien.HocVien;
import com.lts.quanlykhoahoc.models.khoahoc.KhoaHoc;
import com.lts.quanlykhoahoc.models.response.ApiResponse;
import com.lts.quanlykhoahoc.repositories.HocVienRepo;
import com.lts.quanlykhoahoc.repositories.KhoaHocRepo;
import com.lts.quanlykhoahoc.repositories.TinhTrangHocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DangKyHocService implements IDangKyHocService{
    @Autowired
    private HocVienRepo hocVienRepo;
    @Autowired
    private KhoaHocRepo khoaHocRepo;
    @Autowired
    private TinhTrangHocRepo tinhTrangHocRepo;
    @Override
    public ResponseEntity<ApiResponse> addNew(DangKyHoc dangKyHoc) {
        HocVien hocVien = hocVienRepo.findById(dangKyHoc.getHocVienId()).orElse(null);
        KhoaHoc khoaHoc = khoaHocRepo.findById(dangKyHoc.getKhoaHocId()).orElse(null);
        TinhTrangHoc tinhTrangHoc = tinhTrangHocRepo.findById(dangKyHoc.getTinhTrangHocId()).orElse(null);
        if(hocVien == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 404,
                    "Học viên không tồn tại ", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        if(khoaHoc == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 404,
                    "Khóa học không tồn tại ", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        if(tinhTrangHoc == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 404,
                    "Tình trạng học không tồn tại ", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        dangKyHoc.setHocVien((hocVien));
        dangKyHoc.setKhoaHoc((khoaHoc));
        dangKyHoc.setTinhTrangHoc(tinhTrangHoc);
        dangKyHoc.setNgayDangKy(LocalDate.now());
        if(dangKyHoc.getTinhTrangHocId() == 2) {
            dangKyHoc.setNgayBatDau(LocalDate.now());
            dangKyHoc.setNgayKetThuc(dangKyHoc.getNgayBatDau().plusMonths(khoaHoc.getThoiGianHoc()));
        }

        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 200,
                null, "Thêm đăng ký học thành công.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @Override
    public ResponseEntity<ApiResponse> remake(DangKyHoc dangKyHocNew) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse> remove(int dangKyHocId) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponse> getAll() {
        return null;
    }
}
