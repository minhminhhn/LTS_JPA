package com.example.phieuthu.Controller;

import com.example.phieuthu.Models.ChiTietPhieuThu;
import com.example.phieuthu.Repositoties.ChiTietPhieuThuRepo;
import com.example.phieuthu.Services.ChiTietPhieuThuSv;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "api/chitietphieuthu")
public class ChiTietPhieuThuController {
    @Autowired
    private ChiTietPhieuThuSv chiTietPhieuThuSv;

    @RequestMapping(value = "addnew", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ChiTietPhieuThu> addNew(@RequestBody String ct) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();

        java.lang.reflect.Type listType = new TypeToken<List<ChiTietPhieuThu>>(){}.getType();
        List<ChiTietPhieuThu> chiTietPhieuThus = gson.fromJson(ct, listType);
        return chiTietPhieuThuSv.addNewChiTiet(chiTietPhieuThus);
    }
}
