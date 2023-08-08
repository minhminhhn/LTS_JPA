package com.example.phieuthu.Services;

import com.example.phieuthu.Models.ChiTietPhieuThu;
import com.example.phieuthu.Models.NguyenLieu;
import com.example.phieuthu.Models.PhieuThu;
import com.example.phieuthu.Repositoties.ChiTietPhieuThuRepo;
import com.example.phieuthu.Repositoties.NguyenLieuRepo;
import com.example.phieuthu.Repositoties.PhieuThuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhieuThuService implements IPhieuThuService{

    @Autowired
    private NguyenLieuRepo nguyenLieuRepo;
    @Autowired
    private ChiTietPhieuThuRepo chiTietPhieuThuRepo;
    @Autowired
    private PhieuThuRepo phieuThuRepo;

    @Override
    public PhieuThu removePhieuThu(int id) {
        PhieuThu phieuThu = phieuThuRepo.findById(id).orElse(null);
        phieuThu.getChiTietPhieuThus().forEach(chiTietPhieuThu -> {
            chiTietPhieuThuRepo.delete(chiTietPhieuThu);
        });
        phieuThuRepo.delete(phieuThu);
        return phieuThu;
    }

    @Override
    public List<PhieuThu> danhSachPT(LocalDate ngayLap) {
        List<PhieuThu> result  = new ArrayList<>();
        List<PhieuThu> phieuThus = phieuThuRepo.findAll();
        for (PhieuThu phieuThu : phieuThus) {
            if(phieuThu.getNgayLap().isEqual(ngayLap)) {
                result.add(phieuThu);
            };
        }
        return result;
    }

    @Override
    public PhieuThu addNewPhieuThu(PhieuThu phieuThu) {
        phieuThuRepo.save(phieuThu);
        for (ChiTietPhieuThu chiTietPhieuThu : phieuThu.getChiTietPhieuThus()) {
            chiTietPhieuThu.setPhieuThu(phieuThu);
            NguyenLieu nguyenLieu = nguyenLieuRepo.findById(chiTietPhieuThu.getNguyenLieuId()).orElse(null);
            if (nguyenLieu == null) {
                throw  new IllegalArgumentException("Nguyên liệu không tồn tại");
            }
            nguyenLieu.setSoLuongKho(nguyenLieu.getSoLuongKho() - chiTietPhieuThu.getSoLuongBan());
            chiTietPhieuThu.setNguyenLieu(nguyenLieu);
            nguyenLieuRepo.save(nguyenLieu);
            phieuThu.setThanhTien(phieuThu.getThanhTien() +
                    chiTietPhieuThu.getSoLuongBan()*nguyenLieu.getGiaBan());
        }
        chiTietPhieuThuRepo.saveAll(phieuThu.getChiTietPhieuThus());
        phieuThuRepo.save(phieuThu);

        return phieuThu;
    }

}
