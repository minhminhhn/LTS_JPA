package com.lts.quanlykhoahoc.controller;

import com.google.gson.*;
import com.lts.quanlykhoahoc.models.khoahoc.KhoaHoc;
import com.lts.quanlykhoahoc.models.response.ApiResponse;
import com.lts.quanlykhoahoc.repositories.KhoaHocRepo;
import com.lts.quanlykhoahoc.services.KhoaHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.PrimitiveIterator;

@RestController
@RequestMapping(value = "api/khoahoc")
public class KhoaHocController {
    @Autowired
    private KhoaHocService khoaHocService;

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
        KhoaHoc khoaHoc = gson.fromJson(request, KhoaHoc.class);
        return khoaHocService.addNew(khoaHoc);
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
        KhoaHoc khoaHoc = gson.fromJson(request, KhoaHoc.class);
        return khoaHocService.suaKhoaHoc(khoaHoc);
    }

    @RequestMapping(value = "remove", method = RequestMethod.DELETE)
    public ResponseEntity<ApiResponse> removeLoaiKhoaHoc(@RequestParam int khoaHocId) {
        return khoaHocService.xoaKhoaHoc(khoaHocId);
    }

    @RequestMapping(value = "getall", method = RequestMethod.GET)
    private ResponseEntity<ApiResponse<Map<String, Object>>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return khoaHocService.getAll(page, size);
    }

    @RequestMapping(value = "findByName", method = RequestMethod.GET)
    private ResponseEntity<ApiResponse<KhoaHoc>> findByName(@RequestParam String tenKhoaHoc){
        return khoaHocService.findByName(tenKhoaHoc);
    }
}
