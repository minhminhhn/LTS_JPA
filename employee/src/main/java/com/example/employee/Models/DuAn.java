package com.example.employee.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "duan")
public class DuAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "duanid")
    private int duAnId;
    @Column(name = "tenduan")
    private String tenDuAn;
    @Column(name = "mota")
    private String moTa;
    @Column(name = "ghichu")
    private String ghiChu;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "duAn")
    @JsonManagedReference
    private Set<PhanCong> phanCongs;

    public Set<PhanCong> getPhanCongs() {
        return phanCongs;
    }

    public void setPhanCongs(Set<PhanCong> phanCongs) {
        this.phanCongs = phanCongs;
    }

    public int getDuAnId() {
        return duAnId;
    }

    public void setDuAnId(int duAnId) {
        this.duAnId = duAnId;
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
