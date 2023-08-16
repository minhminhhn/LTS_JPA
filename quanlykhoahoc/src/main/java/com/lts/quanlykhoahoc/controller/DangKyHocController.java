package com.lts.quanlykhoahoc.controller;

import com.google.gson.*;
import com.lts.quanlykhoahoc.models.dangkyhoc.DangKyHoc;
import com.lts.quanlykhoahoc.models.dangkyhoc.TinhTrangHoc;
import com.lts.quanlykhoahoc.models.response.ApiResponse;
import com.lts.quanlykhoahoc.services.DangKyHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/dangkyhoc")
public class DangKyHocController {
    @Autowired
    private DangKyHocService dangKyHocService;

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

        DangKyHoc dangKyHoc= gson.fromJson(request, DangKyHoc.class);
        return dangKyHocService.addNew(dangKyHoc);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> remake(@RequestBody String request) {
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

        DangKyHoc dangKyHoc = gson.fromJson(request, DangKyHoc.class);
        return dangKyHocService.remake(dangKyHoc);
    }

    @RequestMapping(value = "remove", method = RequestMethod.DELETE)
    public ResponseEntity<ApiResponse> remove(@RequestParam int dangKyHocId) {
        return dangKyHocService.remove(dangKyHocId);
    }

    @RequestMapping(value = "getall", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<Map<String, Object>>>  getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return dangKyHocService.getAll(page, size);
    }
}
