package com.lts.quanlykhoahoc.services;

import com.lts.quanlykhoahoc.models.khoahoc.KhoaHoc;
import com.lts.quanlykhoahoc.models.khoahoc.LoaiKhoaHoc;
import com.lts.quanlykhoahoc.models.response.ApiResponse;
import com.lts.quanlykhoahoc.repositories.KhoaHocRepo;
import com.lts.quanlykhoahoc.repositories.LoaiKhoaHocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KhoaHocService implements IKhoaHocService {

    @Autowired
    private KhoaHocRepo khoaHocRepo;
    @Autowired
    private LoaiKhoaHocRepo loaiKhoaHocRepo;

    @Override
    public ResponseEntity<ApiResponse> addNew(KhoaHoc khoaHoc) {
        LoaiKhoaHoc loaiKhoaHoc = loaiKhoaHocRepo.findById(khoaHoc.getLoaiKhoaHocId()).orElse(null);
        if(loaiKhoaHoc == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 404,
                    null, "Loại khóa học không tồn tại.");
            return ResponseEntity.status(404).body(response);
        }
        khoaHocRepo.save(khoaHoc);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 200,
                null, "Thêm khóa học thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse> xoaKhoaHoc(int khoaHocId) {
        KhoaHoc khoaHoc = khoaHocRepo.findById(khoaHocId).orElse(null);
        if (khoaHoc == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                    404, "Khóa học không tồn tại", null);
            return ResponseEntity.status(404).body(response);
        }
        khoaHocRepo.delete(khoaHoc);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                200, null, "Xóa khóa học thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse> suaKhoaHoc(KhoaHoc khoaHocNew) {
        KhoaHoc khoaHoc = khoaHocRepo.findById(khoaHocNew.getKhoaHocId()).orElse(null);
        if (khoaHoc == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                    404, "Khóa học không tồn tại", null);
            return ResponseEntity.status(404).body(response);
        }
        khoaHocRepo.save(khoaHocNew);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                200, null, "Thêm khóa học thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse<Map<String, Object>>> getAll(int page, int size) {
        List<KhoaHoc> khoaHocs = khoaHocRepo.findAll();
        Pageable pageRequest = PageRequest.of(page, size);
        Page<KhoaHoc> pagedData = khoaHocRepo.findAll(pageRequest);
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("data", pagedData.getContent());
        responseData.put("currentPage", pagedData.getNumber());
        responseData.put("totalItems", pagedData.getTotalElements());
        responseData.put("totalPages", pagedData.getTotalPages());
        ApiResponse<Map<String, Object>> response = new ApiResponse(LocalDateTime.now().toString(),
                200, null, "Lấy danh sách khóa học thành công.", responseData);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse<KhoaHoc>> findByName(String tenKhoaHoc) {
        KhoaHoc khoaHoc = khoaHocRepo.getKhoaHocByName(tenKhoaHoc);
        if (khoaHoc == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                    404, "Khóa học không tồn tại", null);
            return ResponseEntity.status(404).body(response);
        }
        ApiResponse<KhoaHoc> response = new ApiResponse(LocalDateTime.now().toString(),
                200, null, "Lấy danh sách khóa học thành công.", khoaHoc);
        return ResponseEntity.ok(response);
    }


    @Override
    public void updateSoLuong(KhoaHoc khoaHoc) {
        khoaHoc.setSoHocVien(khoaHoc.getSoHocVien()+1);
        khoaHocRepo.save(khoaHoc);
    }

    public void dangKyHocVien(int khoaHocId) {
        KhoaHoc khoaHoc = khoaHocRepo.findById(khoaHocId).orElse(null);
        if (khoaHoc != null) {
            khoaHoc.setSoHocVien(khoaHoc.getSoHocVien() + 1);
            khoaHocRepo.save(khoaHoc);
        }
    }
}
