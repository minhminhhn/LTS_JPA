package com.example.phieuthu.Controller;

import com.example.phieuthu.Models.NguyenLieu;
import com.example.phieuthu.Repositoties.NguyenLieuRepo;
import com.example.phieuthu.Services.NguyenLieuService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "api")
public class NguyenLieuController {
    @Autowired
    private NguyenLieuService nguyenLieuService;
    @Autowired
    private NguyenLieuRepo nguyenLieuRepo;

    @RequestMapping(value = "nguyenlieu/addnew", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public NguyenLieu addNew(@RequestBody String nl) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        NguyenLieu nguyenLieu = gson.fromJson(nl, NguyenLieu.class);
        return nguyenLieuService.addNguyenLieu(nguyenLieu);
    }

    @RequestMapping(value = "nguyenlieu/getall", method = RequestMethod.GET)
    public List<NguyenLieu> getall() {
        return nguyenLieuRepo.findAll();
    }
}
