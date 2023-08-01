package com.example.employee.Controller;

import com.example.employee.Models.DuAn;
import com.example.employee.Models.PhanCong;
import com.example.employee.Services.DuAnServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "duan")
public class DuAnController {

    @Autowired
    private DuAnServices duAnServices;

    @RequestMapping(value = "getallduan", method = RequestMethod.GET)
    public List<DuAn> getAllDuAn(){
        return duAnServices.getallduan();
    }

    @RequestMapping(value = "addnvvaoduan", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public PhanCong addNvtoDa(@RequestBody String phanCong){
        Gson gson = new Gson();
        PhanCong phanCong1 = gson.fromJson(phanCong, PhanCong.class);
        return duAnServices.addNvtoDa(phanCong1);
    }

    @RequestMapping(value = "remakeduan", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public DuAn remakeDuAn(@RequestBody String duAn) {
        Gson gson = new Gson();
        DuAn duAn1 = gson.fromJson(duAn, DuAn.class);
        return duAnServices.remakeDuAn(duAn1);
    }
}
