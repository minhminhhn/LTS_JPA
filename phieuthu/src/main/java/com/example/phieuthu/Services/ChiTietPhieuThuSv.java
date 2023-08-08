package com.example.phieuthu.Services;

import com.example.phieuthu.Models.ChiTietPhieuThu;
import com.example.phieuthu.Models.NguyenLieu;
import com.example.phieuthu.Models.PhieuThu;
import com.example.phieuthu.Repositoties.ChiTietPhieuThuRepo;
import com.example.phieuthu.Repositoties.NguyenLieuRepo;
import com.example.phieuthu.Repositoties.PhieuThuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietPhieuThuSv implements IChiTietPhieuThuSv {
    @Autowired
    private PhieuThuRepo phieuThuRepo;
    @Autowired
    private ChiTietPhieuThuRepo chiTietPhieuThuRepo;
    @Autowired
    private NguyenLieuRepo nguyenLieuRepo;

    @Override
    public List<ChiTietPhieuThu> addNewChiTiet(List<ChiTietPhieuThu> chiTietPhieuThus) {
        chiTietPhieuThus.forEach(chiTietPhieuThu -> {
            PhieuThu phieuThu = phieuThuRepo.findById(chiTietPhieuThu.getPhieuThuId()).orElse(null);
            NguyenLieu nguyenLieu = nguyenLieuRepo.findById(chiTietPhieuThu.getNguyenLieuId()).orElse(null);
            if (phieuThu == null || nguyenLieu == null) {
                throw new IllegalArgumentException("Phiếu thu hoặc nguyên liệu k tồn tại");
            }
            phieuThu.setThanhTien(phieuThu.getThanhTien() +
                    chiTietPhieuThu.getSoLuongBan() * nguyenLieu.getGiaBan());
            chiTietPhieuThu.setPhieuThu(phieuThu);
            chiTietPhieuThu.setNguyenLieu(nguyenLieu);
        });
        chiTietPhieuThuRepo.saveAll(chiTietPhieuThus);

        return chiTietPhieuThus;
    }
}
