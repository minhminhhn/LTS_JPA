package com.lts.quanlykhoahoc.controller;

import com.google.gson.*;
import com.lts.quanlykhoahoc.models.dangkyhoc.TinhTrangHoc;
import com.lts.quanlykhoahoc.models.response.ApiResponse;
import com.lts.quanlykhoahoc.services.TinhTrangHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(value = "api/tinhtranghoc")
public class TinhTrangHocController {

    @Autowired
    private TinhTrangHocService tinhTrangHocService;

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

        TinhTrangHoc tinhTrangHoc = gson.fromJson(request, TinhTrangHoc.class);
        return tinhTrangHocService.addNew(tinhTrangHoc);
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

        TinhTrangHoc tinhTrangHoc = gson.fromJson(request, TinhTrangHoc.class);
        return tinhTrangHocService.remake(tinhTrangHoc);
    }

    @RequestMapping(value = "remove", method = RequestMethod.DELETE)
    public ResponseEntity<ApiResponse> remove(@RequestParam int tinhTrangHocId) {
        return tinhTrangHocService.remove(tinhTrangHocId);
    }

    @RequestMapping(value = "getall", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<TinhTrangHoc>>> getAll() {
        return tinhTrangHocService.getAll();
    }
}
