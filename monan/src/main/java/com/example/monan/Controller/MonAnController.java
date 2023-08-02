package com.example.monan.Controller;

import com.example.monan.Models.LoaiMonAn;
import com.example.monan.Models.MonAn;
import com.example.monan.Repository.LoaiMonAnRepo;
import com.example.monan.Repository.MonAnRepo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class MonAnController {
    @Autowired
    private MonAnRepo monAnRepo;
    @Autowired
    private LoaiMonAnRepo loaiMonAnRepo;

    @RequestMapping(value = "monan/addmonan", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public MonAn addMonAn(@RequestBody String monAn) {
        Gson gson = new Gson();
        MonAn monAn1 = gson.fromJson(monAn, MonAn.class);
        LoaiMonAn loaiMonAn = loaiMonAnRepo.findById(monAn1.getLoaiMonAnId()).orElse(null);
        if(loaiMonAn == null) {
            throw new IllegalArgumentException("Loại món ăn không tồn tại.");
        }
        monAn1.setLoaiMonAn(loaiMonAn);
        monAnRepo.save(monAn1);
        return monAn1;
    }

    @RequestMapping(value = "monan/getallmonan", method = RequestMethod.GET)
    public List<MonAn> getAllMonAn() {
        return monAnRepo.findAll();
    }

}
