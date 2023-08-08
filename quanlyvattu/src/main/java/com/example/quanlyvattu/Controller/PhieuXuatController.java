package com.example.quanlyvattu.Controller;

import com.example.quanlyvattu.Models.ChiTietPhieuXuat;
import com.example.quanlyvattu.Models.PhieuXuat;
import com.example.quanlyvattu.Models.VatTu;
import com.example.quanlyvattu.Repository.ChiTietPhieuXuatRepo;
import com.example.quanlyvattu.Repository.PhieuXuatRepo;
import com.example.quanlyvattu.Repository.VatTuRepo;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "api/phieuxuat")
public class PhieuXuatController {

    @Autowired
    private VatTuRepo vatTuRepo;
    @Autowired
    private ChiTietPhieuXuatRepo chiTietPhieuXuatRepo;
    @Autowired
    private PhieuXuatRepo phieuXuatRepo;

    @RequestMapping(value = "addnew", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public PhieuXuat addNew(@RequestBody String px) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        PhieuXuat phieuXuat = gson.fromJson(px, PhieuXuat.class);
        phieuXuatRepo.save(phieuXuat);
        phieuXuat.getChiTietPhieuXuats().forEach(chiTietPhieuXuat -> {
            chiTietPhieuXuat.setPhieuXuat(phieuXuat);
            VatTu vatTu = vatTuRepo.findById(chiTietPhieuXuat.getVatTuId()).orElse(null);
            if(vatTu.getSoLuongTon()-chiTietPhieuXuat.getSoLuongXuat() < 0) {
                throw new IllegalArgumentException("Số lượng tồn nhỏ hơn số lượng xuất.");
            } else {
                vatTu.setSoLuongTon(vatTu.getSoLuongTon()-chiTietPhieuXuat.getSoLuongXuat());
                vatTuRepo.save(vatTu);
            }
            chiTietPhieuXuat.setVatTu(vatTu);
        });
        chiTietPhieuXuatRepo.saveAll(phieuXuat.getChiTietPhieuXuats());
        return phieuXuat;
    }
}
