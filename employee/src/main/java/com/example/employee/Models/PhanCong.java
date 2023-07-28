package com.example.employee.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "phancong")
public class PhanCong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phancongid")
    private int phanCongId;
    @Column(name = "nhanvienid",insertable = false, updatable = false)
    private int nhanVienId;
    @Column(name = "duanid",insertable = false, updatable = false)
    private int duAnId;
    @Column(name = "sogiolam")
    private int soGioLam;

    @ManyToOne
    @JoinColumn(name = "duanid")
    @JsonBackReference
    private DuAn duAn;

    @ManyToOne
    @JoinColumn(name = "nhanvienid")
    @JsonBackReference
    private NhanVien nhanVien;

    public int getPhanCongId() {
        return phanCongId;
    }

    public void setPhanCongId(int phanCongId) {
        this.phanCongId = phanCongId;
    }

    public int getNhanVienId() {
        return nhanVienId;
    }

    public void setNhanVienId(int nhanVienId) {
        this.nhanVienId = nhanVienId;
    }

    public int getDuAnId() {
        return duAnId;
    }

    public void setDuAnId(int duAnId) {
        this.duAnId = duAnId;
    }

    public int getSoGioLam() {
        return soGioLam;
    }

    public void setSoGioLam(int soGioLam) {
        this.soGioLam = soGioLam;
    }

    public DuAn getDuAn() {
        return duAn;
    }

    public void setDuAn(DuAn duAn) {
        this.duAn = duAn;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }
}
