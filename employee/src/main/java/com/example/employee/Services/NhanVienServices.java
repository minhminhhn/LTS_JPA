package com.example.employee.Services;

import com.example.employee.Models.DuAn;
import com.example.employee.Models.NhanVien;
import com.example.employee.Models.PhanCong;
import com.example.employee.Repository.DuAnRepo;
import com.example.employee.Repository.NhanVienRepo;
import com.example.employee.Repository.PhanCongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhanVienServices implements INhanVienServices{
    @Autowired
    NhanVienRepo nhanVienRepo;
    @Autowired
    DuAnRepo duAnRepo;
    @Autowired
    PhanCongRepo phanCongRepo;
    @Override
    public NhanVien removeNhanVien(int idNv) {
        NhanVien nhanVien = nhanVienRepo.findById(idNv).orElse(null);
        if (nhanVien == null) {
            throw new IllegalArgumentException("Nhân viên không tồn tại");
        }
        for(PhanCong pc : nhanVien.getPhanCongs()){
            phanCongRepo.delete(pc);
        }
        nhanVienRepo.delete(nhanVien);
        return nhanVien;
    }
}
