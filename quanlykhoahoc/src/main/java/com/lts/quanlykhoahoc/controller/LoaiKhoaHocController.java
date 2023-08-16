package com.lts.quanlykhoahoc.controller;

import com.google.gson.*;
import com.lts.quanlykhoahoc.models.khoahoc.LoaiKhoaHoc;
import com.lts.quanlykhoahoc.models.response.ApiResponse;
import com.lts.quanlykhoahoc.services.LoaiKhoaHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("api/loaikhoahoc")
public class LoaiKhoaHocController {
    @Autowired
    private LoaiKhoaHocService loaiKhoaHocService;

    @RequestMapping(value = "addnew", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> addNew(@RequestBody String request) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
                    @Override
                    public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                        return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
                    }
                })
                .registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                    @Override
                    public LocalDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                        return LocalDateTime.parse(jsonElement.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ISO_DATE_TIME);
                    }
                })
                .create();
        LoaiKhoaHoc loaiKhoaHoc = gson.fromJson(request, LoaiKhoaHoc.class);
        return loaiKhoaHocService.addNew(loaiKhoaHoc);
    }

    @RequestMapping(value = "sualoaikhoahoc", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> suaLoaiKhoaHoc(@RequestBody String request) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
                    @Override
                    public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                        return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
                    }
                })
                .registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                    @Override
                    public LocalDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                        return LocalDateTime.parse(jsonElement.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ISO_DATE_TIME);
                    }
                })
                .create();
        LoaiKhoaHoc loaiKhoaHoc = gson.fromJson(request, LoaiKhoaHoc.class);
        return loaiKhoaHocService.suaLoaiKhoaHoc(loaiKhoaHoc);
    }

    @RequestMapping(value = "remove", method = RequestMethod.DELETE)
    public ResponseEntity<ApiResponse> removeLoaiKhoaHoc(@RequestParam int loaiKhoaHocId) {
        return loaiKhoaHocService.xoaLoaiKhoaHoc(loaiKhoaHocId);
    }

}
