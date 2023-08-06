package com.example.quanlymonan.Controller;

import com.example.quanlymonan.Models.CongThuc;
import com.example.quanlymonan.Models.LoaiMonAn;
import com.example.quanlymonan.Models.MonAn;
import com.example.quanlymonan.Models.NguyenLieu;
import com.example.quanlymonan.Repository.CongThucRepo;
import com.example.quanlymonan.Repository.LoaiMonAnRepo;
import com.example.quanlymonan.Repository.MonAnRepo;
import com.example.quanlymonan.Repository.NguyenLieuRepo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class MonAnController {
    @Autowired
    private MonAnRepo monAnRepo;
    @Autowired
    private CongThucRepo congThucRepo;
    @Autowired
    private NguyenLieuRepo nguyenLieuRepo;
    @Autowired
    private LoaiMonAnRepo loaiMonAnRepo;

    @RequestMapping(value = "hienthi")
    public MonAn hienThiDanhSach() {
        List<MonAn> monAns = monAnRepo.findAll();
        for (MonAn monAn : monAns) {
            System.out.println("Món ăn " + monAn.getTenMon() + ":");
            List<CongThuc> congThucs = congThucRepo.getCongThuc(monAn.getMonAnId());
            for (CongThuc congThuc : congThucs) {
                NguyenLieu nguyenLieu = nguyenLieuRepo.findById(congThuc.getNguyenLieuId()).orElse(null);
                assert nguyenLieu != null;
                System.out.println(nguyenLieu.getTenNguyenLieu() + "-" + congThuc.getSoLuong() + "-" + congThuc.getDonViTinh());
            }
            System.out.println();
        }
        return monAnRepo.findById(22).orElse(null);
    }

    @RequestMapping(value = "timkiem/nguyenlieu", method = RequestMethod.GET)
    public List<MonAn> getMonAn(@RequestParam String tenNguyenLieu) {
        NguyenLieu nguyenLieu = nguyenLieuRepo.getNguyenLieu(tenNguyenLieu);

        List<MonAn> monAns = congThucRepo.getListMonAn(nguyenLieu.getNguyenLieuId());

        return monAns;
    }

    //    @RequestMapping(value = "addnewmonan", method = RequestMethod.POST)
//    public MonAn addNewMonAn(@RequestBody String monAn) {
//        Gson gson = new Gson();
//        MonAn monAn1 = gson.fromJson(monAn, MonAn.class);
//        LoaiMonAn loaiMonAn = loaiMonAnRepo.findById(monAn1.getLoaiMonAnId()).orElse(null);
//        monAn1.setLoaiMonAn(loaiMonAn);
//        for(CongThuc congThuc :monAn1.getCongThucs()){
//            NguyenLieu nguyenLieu = nguyenLieuRepo.findById(congThuc.getNguyenLieuId()).orElse(null);
//            congThuc.setNguyenLieu(nguyenLieu);
//            congThuc.setMonAn(monAn1);
//        }
//
//        monAnRepo.save(monAn1);
//        return monAn1;
//    }
    @RequestMapping(value = "addnewmonan", method = RequestMethod.POST)
    public MonAn addNewMonAn(@RequestBody String monAn) {
        Gson gson = new Gson();
        MonAn monAn1 = gson.fromJson(monAn, MonAn.class);
        LoaiMonAn loaiMonAn = loaiMonAnRepo.findById(monAn1.getLoaiMonAnId()).orElse(null);
        monAn1.setLoaiMonAn(loaiMonAn);
        monAnRepo.save(monAn1);
        // Thiết lập mối quan hệ giữa MonAn và CongThuc
        for (CongThuc congThuc : monAn1.getCongThucs()) {
            NguyenLieu nguyenLieu = nguyenLieuRepo.findById(congThuc.getNguyenLieuId()).orElse(null);
            congThuc.setNguyenLieu(nguyenLieu);
            congThuc.setMonAn(monAn1);
            congThucRepo.save(congThuc);
        }

        // Lưu MonAn và các CongThuc liên quan vào cơ sở dữ liệu


        return monAn1;
    }



}
