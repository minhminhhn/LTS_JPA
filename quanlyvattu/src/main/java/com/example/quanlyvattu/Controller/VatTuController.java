package com.example.quanlyvattu.Controller;

import com.example.quanlyvattu.Models.VatTu;
import com.example.quanlyvattu.Repository.VatTuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/vattu")
public class VatTuController {

    @Autowired
    private VatTuRepo vatTuRepo;


    @RequestMapping(value = "hienthidanhsach")
    public ResponseEntity<StringBuffer> hienThiDanhSach() {
        StringBuffer result = new StringBuffer();

        List<VatTu> vatTus = vatTuRepo.findAll();
        result.append("<div>");
        for(VatTu vatTu :  vatTus) {
            result.append(vatTu.getTenVatTu() + " - SLTK: " +
                    (vatTu.getSoLuongTon() > 0 ? vatTu.getSoLuongTon() : "Hết hàng.") + "<br>");
        }
        result.append("</div>");
        return ResponseEntity.ok(result);
    }


    @RequestMapping(value = "hienthidanhsachcannhap")
    public ResponseEntity<StringBuffer> hienThiDanhSachCanNhap() {
        StringBuffer result = new StringBuffer();

        List<VatTu> vatTus = vatTuRepo.findAll();
        result.append("<div>");
        for(VatTu vatTu :  vatTus) {
            if(vatTu.getSoLuongTon() == 0) {
                result.append(vatTu.getTenVatTu() + " - SLTK: " +
                        (vatTu.getSoLuongTon() > 0 ? vatTu.getSoLuongTon() : "Hết hàng.") + "<br>");
            }
        }
        result.append("</div>");
        return ResponseEntity.ok(result);
    }
}
