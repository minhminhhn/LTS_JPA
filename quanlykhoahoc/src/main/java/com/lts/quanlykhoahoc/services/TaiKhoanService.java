package com.lts.quanlykhoahoc.services;

import com.lts.quanlykhoahoc.models.response.ApiResponse;
import com.lts.quanlykhoahoc.models.taikhoan.QuyenHan;
import com.lts.quanlykhoahoc.models.taikhoan.TaiKhoan;
import com.lts.quanlykhoahoc.repositories.QuyenHanRepo;
import com.lts.quanlykhoahoc.repositories.TaiKhoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaiKhoanService implements ITaiKhoanService{
    @Autowired
    private TaiKhoanRepo taiKhoanRepo;
    @Autowired
    private QuyenHanRepo quyenHanRepo;
    @Override
    public ResponseEntity<ApiResponse> addNew(TaiKhoan taiKhoan) {
        if(get(taiKhoan.getTaiKhoan())) {
            ApiResponse response = new ApiResponse<>(LocalDateTime.now().toString(), 400,
                    "Tài khoản đã tồn tại", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } else {
            QuyenHan quyenHan = quyenHanRepo.findById(taiKhoan.getQuyenHanId()).orElse(null);
            if(quyenHan == null) {
                ApiResponse response = new ApiResponse<>(LocalDateTime.now().toString(), 404,
                        "Quyền hạn không tồn tại", null);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }

            taiKhoan.setQuyenHan(quyenHan);
            taiKhoan.setTenNguoiDung(normalizeName(taiKhoan.getTenNguoiDung()));
            taiKhoanRepo.save(taiKhoan);
            ApiResponse response = new ApiResponse<>(LocalDateTime.now().toString(), 200,
                    null, "Thêm tài khoản thành công.");
            return ResponseEntity.ok(response);
        }
    }

    @Override
    public ResponseEntity<ApiResponse> reamke(TaiKhoan taiKhoanNew) {
        TaiKhoan taiKhoan = taiKhoanRepo.findById(taiKhoanNew.getTaiKhoanId()).orElse(null);

        if(taiKhoan == null) {
            ApiResponse response = new ApiResponse<>(LocalDateTime.now().toString(), 404,
                    "Tài khoản không tồn tại", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        QuyenHan quyenHan = quyenHanRepo.findById(taiKhoanNew.getQuyenHanId()).orElse(null);
        if(quyenHan == null) {
            ApiResponse response = new ApiResponse<>(LocalDateTime.now().toString(), 404,
                    "Quyền hạn không tồn tại", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        taiKhoanNew.setQuyenHan(quyenHan);

        taiKhoanNew.setTenNguoiDung(normalizeName(taiKhoanNew.getTenNguoiDung()));
        taiKhoanRepo.save(taiKhoanNew);
        ApiResponse response = new ApiResponse<>(LocalDateTime.now().toString(), 200,
                null, "Thêm tài khoản thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse> remove(int taiKhoanId) {
        TaiKhoan taiKhoan = taiKhoanRepo.findById(taiKhoanId).orElse(null);

        if(taiKhoan == null) {
            ApiResponse response = new ApiResponse<>(LocalDateTime.now().toString(), 404,
                    "Tài khoản không tồn tại", null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        taiKhoanRepo.delete(taiKhoan);
        ApiResponse response = new ApiResponse<>(LocalDateTime.now().toString(), 200,
                null, "Xóa tài khoản thành công.");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ApiResponse<List<TaiKhoan>>> getAll() {
        List<TaiKhoan> taiKhoans = taiKhoanRepo.findAll();
        ApiResponse<List<TaiKhoan>> response = new ApiResponse<>(LocalDateTime.now().toString(), 200,
                null, "Lấy danh sách tài khoản thành công.", taiKhoans);
        return ResponseEntity.ok(response);
    }

    public boolean get(String taiKhoan) {
        TaiKhoan tk = taiKhoanRepo.findByTaiKhoan(taiKhoan);
        return tk != null;
    }

    @Override
    public String normalizeName(String name) {
        // Xóa khoảng trắng thừa và chuyển chữ cái đầu mỗi từ thành chữ hoa
        String[] words = name.toLowerCase().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
            }
        }

        return result.toString().trim();
    }
}
