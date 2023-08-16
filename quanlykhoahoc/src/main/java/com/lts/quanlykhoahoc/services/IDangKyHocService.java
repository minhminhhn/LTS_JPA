package com.lts.quanlykhoahoc.services;

import com.lts.quanlykhoahoc.models.dangkyhoc.DangKyHoc;
import com.lts.quanlykhoahoc.models.response.ApiResponse;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

import javax.swing.plaf.PanelUI;
import java.util.Map;

public interface IDangKyHocService {
    public ResponseEntity<ApiResponse> addNew(DangKyHoc dangKyHoc);
    public ResponseEntity<ApiResponse> remake(DangKyHoc dangKyHocNew);
    public ResponseEntity<ApiResponse> remove(int dangKyHocId);
    public ResponseEntity<ApiResponse<Map<String, Object>>> getAll(int page, int size);
}
