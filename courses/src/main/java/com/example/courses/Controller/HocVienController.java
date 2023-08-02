package com.example.courses.Controller;


import com.example.courses.Models.KhoaHoc;
import com.example.courses.Models.NgayHoc;
import com.example.courses.Repository.KhoaHocRepo;
import com.example.courses.Repository.NgayHocRepo;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "api")
public class HocVienController {
    @Autowired
    private NgayHocRepo ngayHocRepo;
    @Autowired
    private KhoaHocRepo khoaHocRepo;
    @RequestMapping(value = "khoahoc/addngayhoc", method = RequestMethod.POST)
    public NgayHoc addNgayHoc(@RequestBody String ngayHoc) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();

        NgayHoc ngayHoc1 = gson.fromJson(ngayHoc, NgayHoc.class);
        ngayHocRepo.save(ngayHoc1);

        return ngayHoc1;
    }
}
