package com.example.employee.Controller;

import com.example.employee.Models.NhanVien;
import com.example.employee.Services.NhanVienServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "nhanvien")
public class NhanVienController {
    @Autowired
    NhanVienServices nhanVienServices;

    @RequestMapping(value = "removenv", method = RequestMethod.DELETE)
    public NhanVien removeNV(@RequestParam int idNv) {
        return nhanVienServices.removeNhanVien(idNv);   
    }

}
