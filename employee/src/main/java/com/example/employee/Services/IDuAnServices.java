package com.example.employee.Services;

import com.example.employee.Models.DuAn;
import com.example.employee.Models.PhanCong;

import java.util.List;

public interface IDuAnServices {
    public List<DuAn> getallduan();
    public PhanCong addNvtoDa(PhanCong phanCong);
    public DuAn remakeDuAn(DuAn duAnRm);
}
