package com.example.phieuthu.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "phieuthu")
public class PhieuThu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phieuthuid")
    private int phieuThuId;
    @Column(name = "ngaylap")
    private LocalDate ngayLap;
    @Column(name = "nhanvienlap")
    private String nhanVienLap;
    @Column(name = "ghichu")
    private String ghiChu;
    @Column(name = "thanhtien")
    private int thanhTien;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "phieuThu")
    @JsonManagedReference
    private Set<ChiTietPhieuThu> chiTietPhieuThus;

    public int getPhieuThuId() {
        return phieuThuId;
    }

    public void setPhieuThuId(int phieuThuId) {
        this.phieuThuId = phieuThuId;
    }

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getNhanVienLap() {
        return nhanVienLap;
    }

    public void setNhanVienLap(String nhanVienLap) {
        this.nhanVienLap = nhanVienLap;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Set<ChiTietPhieuThu> getChiTietPhieuThus() {
        return chiTietPhieuThus;
    }

    public void setChiTietPhieuThus(Set<ChiTietPhieuThu> chiTietPhieuThus) {
        this.chiTietPhieuThus = chiTietPhieuThus;
    }
}
