package com.example.quanlyvattu.Controller;

import com.example.quanlyvattu.Models.PhieuNhap;
import com.example.quanlyvattu.Models.VatTu;
import com.example.quanlyvattu.Repository.*;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "api/phieunhap")
public class PhieuNhapController {

    @Autowired
    private VatTuRepo vatTuRepo;
    @Autowired
    private ChiTietPhieuNhapRepo chiTietPhieuNhapRepo;
    @Autowired
    private PhieuNhapRepo phieuNhapRepo;

    @RequestMapping(value = "addnew", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public PhieuNhap addNew(@RequestBody String px) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        PhieuNhap phieuNhap = gson.fromJson(px, PhieuNhap.class);
        phieuNhapRepo.save(phieuNhap);
        phieuNhap.getChiTietPhieuNhaps().forEach(chiTietPhieuNhap -> {
            chiTietPhieuNhap.setPhieuNhap(phieuNhap);
            VatTu vatTu = vatTuRepo.findById(chiTietPhieuNhap.getVatTuId()).orElse(null);
            vatTu.setSoLuongTon(vatTu.getSoLuongTon() + chiTietPhieuNhap.getSoLuongNhap());
            vatTuRepo.save(vatTu);
            chiTietPhieuNhap.setVatTu(vatTu);
        });
        chiTietPhieuNhapRepo.saveAll(phieuNhap.getChiTietPhieuNhaps());
        return phieuNhap;
    }
}
