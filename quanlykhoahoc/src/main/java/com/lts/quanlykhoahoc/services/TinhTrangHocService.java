package com.lts.quanlykhoahoc.services;

import com.lts.quanlykhoahoc.models.dangkyhoc.TinhTrangHoc;
import com.lts.quanlykhoahoc.models.response.ApiResponse;
import com.lts.quanlykhoahoc.repositories.TinhTrangHocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TinhTrangHocService implements ITinhTrangHocService{
    @Autowired
    private TinhTrangHocRepo tinhTrangHocRepo;
    @Override
    public ResponseEntity<ApiResponse> addNew(TinhTrangHoc tinhTrangHoc) {
        tinhTrangHocRepo.save(tinhTrangHoc);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 200,
                null, "Tình trạng học mới thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse> remake(TinhTrangHoc tinhTrangHocNew) {
        TinhTrangHoc tinhTrangHoc = tinhTrangHocRepo.findById(tinhTrangHocNew.getTinhTrangHocId()).orElse(null);
        if (tinhTrangHoc == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                    404, "Tình trạng học không tồn tại", null);
            return ResponseEntity.status(404).body(response);
        }
        tinhTrangHocRepo.save(tinhTrangHocNew);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                200, null, "Thêm tinh trạng học thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse> remove(int tinhTrangHocId) {
        TinhTrangHoc tinhTrangHoc = tinhTrangHocRepo.findById(tinhTrangHocId).orElse(null);
        if (tinhTrangHoc == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                    404, "Tình trạng học không tồn tại", null);
            return ResponseEntity.status(404).body(response);
        }
        tinhTrangHocRepo.delete(tinhTrangHoc);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                200, null, "Xóa tinh trạng học thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse<List<TinhTrangHoc>>> getAll() {
        List<TinhTrangHoc> tinhTrangHocs = tinhTrangHocRepo.findAll();
        ApiResponse<List<TinhTrangHoc>> response = new ApiResponse(LocalDateTime.now().toString(),
                200, null, "Lấy danh sách khóa học thành công.", tinhTrangHocs);
        return ResponseEntity.ok(response);
    }
}
