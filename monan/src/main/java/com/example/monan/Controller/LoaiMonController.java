package com.example.monan.Controller;

import com.example.monan.Models.LoaiMonAn;
import com.example.monan.Repository.LoaiMonAnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class LoaiMonController {
    @Autowired
    private LoaiMonAnRepo loaiMonAnRepo;

    @RequestMapping(value = "loaimonan/removeloaimon", method = RequestMethod.DELETE)
    public LoaiMonAn removeLoaiMon(@RequestParam int loaiMonId) {
        LoaiMonAn loaiMonAn = loaiMonAnRepo.findById(loaiMonId).orElse(null);
        if(loaiMonAn == null) {
            throw new IllegalArgumentException("Loại món ăn không tồn tại.");
        }
        loaiMonAnRepo.delete(loaiMonAn);
        return loaiMonAn;
    }

    @RequestMapping(value = "getall", method = RequestMethod.GET)
    public List<LoaiMonAn> getall() {
        return loaiMonAnRepo.findAll();
    }
}
