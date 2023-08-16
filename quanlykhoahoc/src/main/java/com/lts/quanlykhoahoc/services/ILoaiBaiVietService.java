package com.lts.quanlykhoahoc.services;

import com.lts.quanlykhoahoc.models.baiviet.LoaiBaiViet;
import com.lts.quanlykhoahoc.models.response.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ILoaiBaiVietService {
    public ResponseEntity<ApiResponse> addNew(LoaiBaiViet loaiBaiViet);
    public ResponseEntity<ApiResponse> reamke(LoaiBaiViet loaiBaiVietNew);
    public ResponseEntity<ApiResponse> remove(int loaiBaiVietId);
    public ResponseEntity<ApiResponse<List<LoaiBaiViet>>> getAll();
}
