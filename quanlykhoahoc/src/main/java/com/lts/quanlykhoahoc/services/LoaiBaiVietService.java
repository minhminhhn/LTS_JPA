package com.lts.quanlykhoahoc.services;

import com.lts.quanlykhoahoc.models.baiviet.LoaiBaiViet;
import com.lts.quanlykhoahoc.models.response.ApiResponse;
import com.lts.quanlykhoahoc.repositories.LoaiBaiVietRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoaiBaiVietService implements ILoaiBaiVietService{

    @Autowired
    private LoaiBaiVietRepo loaiBaiVietRepo;
    @Override
    public ResponseEntity<ApiResponse> addNew(LoaiBaiViet loaiBaiViet) {
        loaiBaiVietRepo.save(loaiBaiViet);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 200,
                null, "Thêm loại bài viết thành công.");

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse> reamke(@NotNull LoaiBaiViet loaiBaiVietNew) {
        LoaiBaiViet loaiBaiViet = loaiBaiVietRepo.findById(loaiBaiVietNew.getLoaiBaiVietId()).orElse(null);
        if (loaiBaiViet == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                    404, "Loại bài viết không tồn tại", null);
            return ResponseEntity.status(404).body(response);
        }
        loaiBaiVietRepo.save(loaiBaiVietNew);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                200, null, "Sửa loại bài viết thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse> remove(int loaiBaiVietId) {
        LoaiBaiViet loaiBaiViet = loaiBaiVietRepo.findById(loaiBaiVietId).orElse(null);
        if (loaiBaiViet == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                    404, "Loại bài viết không tồn tại", null);
            return ResponseEntity.status(404).body(response);
        }
        loaiBaiVietRepo.delete(loaiBaiViet);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(),
                200, null, "Sửa loại bài viết thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse<List<LoaiBaiViet>>> getAll() {
        List<LoaiBaiViet> loaiBaiViets = loaiBaiVietRepo.findAll();
        ApiResponse<List<LoaiBaiViet>> response = new ApiResponse(LocalDateTime.now().toString(),
                200, null, "Lấy danh sách khóa học thành công.", loaiBaiViets);
        return ResponseEntity.ok(response);
    }
}
