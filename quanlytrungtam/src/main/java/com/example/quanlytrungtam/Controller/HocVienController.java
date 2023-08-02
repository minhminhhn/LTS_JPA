package com.example.quanlytrungtam.Controller;

import com.example.quanlytrungtam.Models.HocVien;
import com.example.quanlytrungtam.Models.Lop;
import com.example.quanlytrungtam.Repository.HocVienRepo;
import com.example.quanlytrungtam.Repository.LopRepo;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "api")
public class HocVienController {
    @Autowired
    private HocVienRepo hocVienRepo;
    @Autowired
    private LopRepo lopRepo;

    @RequestMapping(value = "hocvien/getdanhsach", method = RequestMethod.GET)
    public List<HocVien> getDanhSachHocVien() {
        return hocVienRepo.findAllHocVien();
    }
    @RequestMapping(value = "hocvien/gethocvien", method = RequestMethod.GET)
    public List<HocVien> getHocVien() {
        return hocVienRepo.findHocVien();
    }
    @RequestMapping(value = "hocvien/addhocvien", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
    public HocVien addHocVien(@RequestBody String hv) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        HocVien hocVien = gson.fromJson(hv, HocVien.class);
        Lop lop = lopRepo.findById(hocVien.getLopId()).orElse(null);
        hocVien.setLop(lop);
        hocVienRepo.save(hocVien);
        return hocVien;
    }
    @RequestMapping(value = "hocvien/remakehocvien", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public HocVien remakeHocVien(@RequestBody String hv) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();

        HocVien hocVienRM = gson.fromJson(hv, HocVien.class);
        HocVien hocVien = hocVienRepo.findById(hocVienRM.getHocVienId()).orElse(null);
        if(hocVien == null) {
            return null;
        }
        Lop lop = lopRepo.findById(hocVienRM.getLopId()).orElse(null);
        hocVienRM.setLop(lop);
        hocVienRepo.save(hocVienRM);
        return hocVienRM;
    }

    @RequestMapping(value = "hocvien/removehocvien", method = RequestMethod.DELETE)
    public HocVien removeHocVien(@RequestParam int hocVienId) {
        HocVien hocVien = hocVienRepo.findById(hocVienId).orElse(null);
        if(hocVien == null) {
            return null;
        }
        hocVienRepo.delete(hocVien);
        return hocVien;
    }
}
