package com.lts.quanlykhoahoc.services;

import com.lts.quanlykhoahoc.models.dangkyhoc.DangKyHoc;
import com.lts.quanlykhoahoc.models.dangkyhoc.TinhTrangHoc;
import com.lts.quanlykhoahoc.models.hocvien.HocVien;
import com.lts.quanlykhoahoc.models.khoahoc.KhoaHoc;
import com.lts.quanlykhoahoc.models.response.ApiResponse;
import com.lts.quanlykhoahoc.models.taikhoan.TaiKhoan;
import com.lts.quanlykhoahoc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DangKyHocService implements IDangKyHocService{

    @Autowired
    private KhoaHocService khoaHocService;
    @Autowired
    private DangKyHocRepo dangKyHocRepo;
    @Autowired
    private HocVienRepo hocVienRepo;
    @Autowired
    private KhoaHocRepo khoaHocRepo;
    @Autowired
    private TinhTrangHocRepo tinhTrangHocRepo;
    @Autowired
    private TaiKhoanRepo taiKhoanRepo;
    @Override
    public ResponseEntity<ApiResponse> addNew(DangKyHoc dangKyHoc) {
        HocVien hocVien = hocVienRepo.findById(dangKyHoc.getHocVienId()).orElse(null);
        KhoaHoc khoaHoc = khoaHocRepo.findById(dangKyHoc.getKhoaHocId()).orElse(null);
        TinhTrangHoc tinhTrangHoc = tinhTrangHocRepo.findById(dangKyHoc.getTinhTrangHocId()).orElse(null);
        TaiKhoan taiKhoan = taiKhoanRepo.findById(dangKyHoc.getTaiKhoanId()).orElse(null);
        if(taiKhoan == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 404,
                    "Tài khoản không tồn tại ", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
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
                    "Tình trạng học không tồn tại.", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        dangKyHoc.setHocVien((hocVien));
        dangKyHoc.setKhoaHoc((khoaHoc));
        dangKyHoc.setTinhTrangHoc(tinhTrangHoc);
        dangKyHoc.setNgayDangKy(LocalDate.now());
        if(dangKyHoc.getTinhTrangHocId() == 2) {
            dangKyHoc.setNgayBatDau(LocalDate.now());
            dangKyHoc.setNgayKetThuc(dangKyHoc.getNgayBatDau().plusMonths(khoaHoc.getThoiGianHoc()));
            khoaHocService.updateSoLuong(khoaHoc);
        }
        dangKyHocRepo.save(dangKyHoc);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 200,
                null, "Thêm đăng ký học thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse> remake(DangKyHoc dangKyHocNew) {
        DangKyHoc dangKyHoc = dangKyHocRepo.findById(dangKyHocNew.getHocVienId()).orElse(null);
        HocVien hocVien = hocVienRepo.findById(dangKyHocNew.getHocVienId()).orElse(null);
        KhoaHoc khoaHoc = khoaHocRepo.findById(dangKyHocNew.getKhoaHocId()).orElse(null);
        TinhTrangHoc tinhTrangHoc = tinhTrangHocRepo.findById(dangKyHocNew.getTinhTrangHocId()).orElse(null);
        TaiKhoan taiKhoan = taiKhoanRepo.findById(dangKyHocNew.getTaiKhoanId()).orElse(null);
        if(taiKhoan == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 404,
                    "Tài khoản không tồn tại ", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        if(dangKyHoc == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 404,
                    "Đăng ký học không tồn tại ", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
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
                    "Tình trạng học không tồn tại.", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        dangKyHocNew.setHocVien((hocVien));
        dangKyHocNew.setKhoaHoc((khoaHoc));
        dangKyHocNew.setTinhTrangHoc(tinhTrangHoc);
        if(dangKyHocNew.getNgayDangKy() == null){
            dangKyHocNew.setNgayDangKy(LocalDate.now());
        }
        if(dangKyHocNew.getTinhTrangHocId() == 2) {
            dangKyHocNew.setNgayBatDau(LocalDate.now());
            dangKyHocNew.setNgayKetThuc(dangKyHocNew.getNgayBatDau().plusMonths(khoaHoc.getThoiGianHoc()));
            khoaHocService.updateSoLuong(khoaHoc);
        }
        dangKyHocRepo.save(dangKyHocNew);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 200,
                null, "Sửa đăng ký học thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse> remove(int dangKyHocId) {
        DangKyHoc dangKyHoc = dangKyHocRepo.findById(dangKyHocId).orElse(null);
        if(dangKyHoc == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 404,
                    "Đăng ký học không tồn tại ", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        KhoaHoc khoaHoc = khoaHocRepo.findById(dangKyHoc.getKhoaHocId()).orElse(null);
        assert khoaHoc != null;
        khoaHoc.setSoHocVien(khoaHoc.getSoHocVien()-1);
        khoaHocRepo.save(khoaHoc);
        dangKyHocRepo.delete(dangKyHoc);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 200,
                null, "Xóa đăng ký học thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse<Map<String, Object>>> getAll(int page, int size) {
        Pageable pageRequest = PageRequest.of(page, size);
        Page<DangKyHoc> pagedData = dangKyHocRepo.findAll(pageRequest);
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("data", pagedData.getContent());
        responseData.put("currentPage", pagedData.getNumber());
        responseData.put("totalItems", pagedData.getTotalElements());
        responseData.put("totalPages", pagedData.getTotalPages());
        ApiResponse<Map<String, Object>> response = new ApiResponse<>(LocalDateTime.now().toString(),
                200, null, "Lấy danh sách khóa học thành công.", responseData);
        return ResponseEntity.ok(response);
    }
}
