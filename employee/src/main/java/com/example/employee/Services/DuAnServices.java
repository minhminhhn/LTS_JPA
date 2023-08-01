package com.example.employee.Services;

import com.example.employee.Models.DuAn;
import com.example.employee.Models.NhanVien;
import com.example.employee.Models.PhanCong;
import com.example.employee.Repository.DuAnRepo;
import com.example.employee.Repository.NhanVienRepo;
import com.example.employee.Repository.PhanCongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DuAnServices implements IDuAnServices{

    @Autowired
    private NhanVienRepo nhanVienRepo;
    @Autowired
    private DuAnRepo duAnRepo;
    @Autowired
    private PhanCongRepo phanCongRepo;

    @Override
    public List<DuAn> getallduan() {
        return duAnRepo.findAll();
    }

    @Override
    public PhanCong addNvtoDa(PhanCong phanCong) {
        NhanVien nhanVien = nhanVienRepo.findById(phanCong.getNhanVienId()).orElse(null);
        DuAn duAn = duAnRepo.findById(phanCong.getDuAnId()).orElse(null);
        if (nhanVien == null) {
            throw new IllegalArgumentException("Nhân viên không tồn tại");
        }
        if (duAn == null) {
            throw new IllegalArgumentException("Dự án không tồn tại");
        }

        phanCong.setDuAn(duAn);
        phanCong.setNhanVien(nhanVien);
        phanCongRepo.save(phanCong);
        return phanCong;
    }

    @Override
    public DuAn remakeDuAn(DuAn duAnRm) {
        DuAn duAn = duAnRepo.findById(duAnRm.getDuAnId()).orElse(null);

        if (duAn == null) {
            throw new IllegalArgumentException("Dự án không tồn tại");
        }

        duAnRm.setPhanCongs(duAn.getPhanCongs());
        duAnRepo.save(duAnRm);
        return duAnRm;
    }
}
