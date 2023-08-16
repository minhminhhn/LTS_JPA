package com.lts.quanlykhoahoc.services;

import com.lts.quanlykhoahoc.models.response.ApiResponse;
import com.lts.quanlykhoahoc.models.taikhoan.QuyenHan;
import com.lts.quanlykhoahoc.repositories.QuyenHanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuyenHanService implements IQuyenHanService{

    @Autowired
    private QuyenHanRepo quyenHanRepo;

    @Override
    public ResponseEntity<ApiResponse> addNew(QuyenHan quyenHan) {
        quyenHanRepo.save(quyenHan);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 200,
                null, "Thêm quyền hạn thành công.");

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse> reamke(QuyenHan quyenHanNew) {
        QuyenHan quyenHan = quyenHanRepo.findById(quyenHanNew.getQuyenHanId()).orElse(null);
        if (quyenHan == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                    404, "Quyền hạn không tồn tại", null);
            return ResponseEntity.status(404).body(response);
        }
        quyenHanRepo.save(quyenHanNew);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                200, null, "Sửa quyền hạn thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse> remove(int loaiQuyenHanId) {
        QuyenHan quyenHan = quyenHanRepo.findById(loaiQuyenHanId).orElse(null);
        if (quyenHan == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                    404, "Quyền hạn không tồn tại", null);
            return ResponseEntity.status(404).body(response);
        }
        quyenHanRepo.delete(quyenHan);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                200, null, "Xóa quyền hạn thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse<List<QuyenHan>>> getAll() {
        List<QuyenHan> quyenHans = quyenHanRepo.findAll();
        ApiResponse<List<QuyenHan>> response = new ApiResponse(LocalDateTime.now().toString(),
                200, null, "Lấy danh sách khóa học thành công.", quyenHans);
        return ResponseEntity.ok(response);
    }
}
