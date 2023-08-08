package com.example.phieuthu.Services;

import com.example.phieuthu.Models.LoaiNguyenLieu;
import com.example.phieuthu.Models.NguyenLieu;
import com.example.phieuthu.Repositoties.LoaiNguyenLieuRepo;
import com.example.phieuthu.Repositoties.NguyenLieuRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NguyenLieuService implements INguyenLieuService{

    @Autowired
    NguyenLieuRepo nguyenLieuRepo;
    @Autowired
    LoaiNguyenLieuRepo loaiNguyenLieuRepo;


    @Override
    public NguyenLieu addNguyenLieu( NguyenLieu nl) {
        LoaiNguyenLieu loaiNguyenLieu = loaiNguyenLieuRepo.findById(nl.getLoaiNguyenLieuId()).orElse(null);

        nl.setLoaiNguyenLieu(loaiNguyenLieu);
        nguyenLieuRepo.save(nl);
        return nl;
    }
}
