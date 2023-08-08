package com.example.phieuthu.Controller;

import com.example.phieuthu.Models.PhieuThu;
import com.example.phieuthu.Services.PhieuThuService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "api/phieuthu")
public class PhieuThuController {

    @Autowired
    private PhieuThuService phieuThuService;

    @RequestMapping(value = "addnew", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public PhieuThu addNewPhieuThu(@RequestBody String phieu) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        PhieuThu phieuThu = gson.fromJson(phieu, PhieuThu.class);

        return phieuThuService.addNewPhieuThu(phieuThu);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public PhieuThu removePhieuThu(@RequestParam int idPT) {
        return phieuThuService.removePhieuThu(idPT);
    }

    @RequestMapping(value = "getpttheongay", method = RequestMethod.GET)
    public List<PhieuThu> getPhieuThu(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return phieuThuService.danhSachPT(date);
    }
}
