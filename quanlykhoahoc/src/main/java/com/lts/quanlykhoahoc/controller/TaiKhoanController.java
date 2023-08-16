package com.lts.quanlykhoahoc.controller;

import com.lts.quanlykhoahoc.models.response.ApiResponse;
import com.lts.quanlykhoahoc.models.taikhoan.TaiKhoan;
import com.lts.quanlykhoahoc.repositories.TaiKhoanRepo;
import com.lts.quanlykhoahoc.services.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/taikhoan")
public class TaiKhoanController {

    @Autowired
    private TaiKhoanService taiKhoanService;

    @RequestMapping("get")
    public ResponseEntity<ApiResponse<List<TaiKhoan>>> get() {
        return taiKhoanService.getAll();
    }
}
