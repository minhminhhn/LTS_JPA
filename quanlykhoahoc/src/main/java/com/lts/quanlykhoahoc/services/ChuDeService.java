package com.lts.quanlykhoahoc.services;

import com.lts.quanlykhoahoc.models.baiviet.ChuDe;
import com.lts.quanlykhoahoc.models.baiviet.LoaiBaiViet;
import com.lts.quanlykhoahoc.models.response.ApiResponse;
import com.lts.quanlykhoahoc.repositories.ChuDeRepo;
import com.lts.quanlykhoahoc.repositories.LoaiBaiVietRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChuDeService implements IChuDeService{
    @Autowired
    private ChuDeRepo chuDeRepo;
    @Autowired
    private LoaiBaiVietRepo loaiBaiVietRepo;

    @Override
    public ResponseEntity<ApiResponse> addNew(ChuDe chuDe) {
        LoaiBaiViet loaiBaiViet = loaiBaiVietRepo.findById(chuDe.getLoaiBaiVietId()).orElse(null);
        if(loaiBaiViet == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 404,
                    "Loại bài viết không tồn tại.", null);
            return ResponseEntity.ok(response);
        }
        chuDe.setLoaiBaiViet(loaiBaiViet);
        chuDeRepo.save(chuDe);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 200,
                null , "Thêm chủ đề thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse> reamke(ChuDe chuDeNew) {
        ChuDe chuDe = chuDeRepo.findById(chuDeNew.getChuDeId()).orElse(null);
        if(chuDe == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 404,
                    "Chủ đề không tồn tại.", null);
            return ResponseEntity.ok(response);
        }
        LoaiBaiViet loaiBaiViet = loaiBaiVietRepo.findById(chuDeNew.getLoaiBaiVietId()).orElse(null);
        if(loaiBaiViet == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 404,
                    "Loại bài viết không tồn tại.", null);
            return ResponseEntity.ok(response);
        }
        chuDeNew.setLoaiBaiViet(loaiBaiViet);
        chuDeRepo.save(chuDeNew);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 200,
                null, "Thêm chủ đề thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse> remove(int chuDeId) {
        ChuDe chuDe = chuDeRepo.findById(chuDeId).orElse(null);
        if(chuDe == null) {
            ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 404,
                    "Chủ đề không tồn tại.", null);
            return ResponseEntity.ok(response);
        }
        chuDeRepo.delete(chuDe);
        ApiResponse response = new ApiResponse(LocalDateTime.now().toString(), 200,
                null, "Xóa chủ đề thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse<List<ChuDe>>> getAll() {
        List<ChuDe> chuDes = chuDeRepo.findAll();
        ApiResponse<List<ChuDe>> response = new ApiResponse<>(LocalDateTime.now().toString(), 200,
                null, "Lấy danh sách chủ đề thành công.", chuDes);
        return ResponseEntity.ok(response);
    }
}
