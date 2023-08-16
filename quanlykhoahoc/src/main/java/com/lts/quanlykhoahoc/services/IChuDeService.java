package com.lts.quanlykhoahoc.services;

import com.lts.quanlykhoahoc.models.baiviet.ChuDe;
import com.lts.quanlykhoahoc.models.response.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IChuDeService {
    public ResponseEntity<ApiResponse> addNew(ChuDe chuDe);
    public ResponseEntity<ApiResponse> reamke(ChuDe chuDeNew);
    public ResponseEntity<ApiResponse> remove(int chuDeId);
    public ResponseEntity<ApiResponse<List<ChuDe>>> getAll();
}
