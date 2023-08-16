package com.lts.quanlykhoahoc.services;

import com.lts.quanlykhoahoc.models.hocvien.HocVien;
import com.lts.quanlykhoahoc.models.khoahoc.KhoaHoc;
import com.lts.quanlykhoahoc.models.response.ApiResponse;
import com.lts.quanlykhoahoc.repositories.HocVienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HocVienService implements IHocVienService{
    @Autowired
    private HocVienRepo hocVienRepo;

    @Override
    public ResponseEntity<ApiResponse> addNew(HocVien hocVien) {
        if(hocVienRepo.findByEmail(hocVien.getEmail()) != null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 409,
                    "Email đã tồn tại.", null);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
        if(hocVienRepo.findBySoDienThoai(hocVien.getSoDienThoai()) != null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 409,
                    "Số điện thoại đã tồn tại.", null);
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
        hocVienRepo.save(hocVien);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 200,
                null, "Thêm học viên thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse> remake(HocVien hocVienNew) {
        HocVien hocVien = hocVienRepo.findById(hocVienNew.getHocVienId()).orElse(null);
        if (hocVien == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                    404, "Học viên không tồn tại", null);
            return ResponseEntity.status(404).body(response);
        }
        hocVienRepo.save(hocVienNew);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                200, null, "Thêm học viên thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse> remove(int hocVienId) {
        HocVien hocVien = hocVienRepo.findById(hocVienId).orElse(null);
        if (hocVien == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                    404, "Học viên không tồn tại", null);
            return ResponseEntity.status(404).body(response);
        }
        hocVienRepo.delete(hocVien);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                200, null, "Xóa học viên thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse<List<HocVien>>> getAll() {
        List<HocVien> hocViens = hocVienRepo.findAll();
        ApiResponse<List<HocVien>> response = new ApiResponse(LocalDateTime.now().toString(),
                200, null, "Lấy danh sách khóa học thành công.", hocViens);
        return ResponseEntity.ok(response);
    }


}
