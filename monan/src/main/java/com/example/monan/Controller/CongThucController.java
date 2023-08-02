package com.example.monan.Controller;

import com.example.monan.Models.CongThuc;
import com.example.monan.Models.MonAn;
import com.example.monan.Models.NguyenLieu;
import com.example.monan.Repository.CongThucRepo;
import com.example.monan.Repository.MonAnRepo;
import com.example.monan.Repository.NguyenLieuRepo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class CongThucController {
    @Autowired
    private MonAnRepo monAnRepo;
    @Autowired
    private CongThucRepo congThucRepo;
    @Autowired
    private NguyenLieuRepo nguyenLieuRepo;

    @RequestMapping(value = "congthuc/themcongthuc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CongThuc> addCongthuc(@RequestBody String congThucs) {
        Gson gson = new Gson();
        java.lang.reflect.Type listType = new TypeToken<List<CongThuc>>(){}.getType();
        List<CongThuc> listCongThuc = gson.fromJson(congThucs, listType);

        for(CongThuc congThuc : listCongThuc) {
            MonAn monAn = monAnRepo.findById(congThuc.getMonAnId()).orElse(null);
            NguyenLieu nguyenLieu = nguyenLieuRepo.findById(congThuc.getNguyenLieuId()).orElse(null);
            if(monAn == null || nguyenLieu == null) {
                throw new IllegalArgumentException("Món ăn hoặc nguyên liệu không tồn tại.");
            }
            monAn.setCachLam((monAn.getCachLam() == null ? "": monAn.getCachLam()) + nguyenLieu.getTenNguyenLieu() + " : " +
                    congThuc.getSoLuong() + " " +
                    congThuc.getDonViTinh() + "\n");
            monAnRepo.save(monAn);
            congThuc.setMonAn(monAn);
            congThuc.setNguyenLieu(nguyenLieu);
            congThucRepo.save(congThuc);
        }
        return listCongThuc;
    }
}
