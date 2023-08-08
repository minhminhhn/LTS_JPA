package com.example.phieuthu.Services;

import com.example.phieuthu.Models.LoaiNguyenLieu;
import com.example.phieuthu.Models.PhieuThu;

import java.time.LocalDate;
import java.util.List;

public interface IPhieuThuService {
    public PhieuThu addNewPhieuThu(PhieuThu phieuThu);
    public PhieuThu removePhieuThu(int id);
    public List<PhieuThu> danhSachPT(LocalDate ngayLap);
}
