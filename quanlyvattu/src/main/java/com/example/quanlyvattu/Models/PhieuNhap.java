package com.example.quanlyvattu.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "phieunhap")
public class PhieuNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phieunhapid")
    private int phieuNhapId;
    @Column(name = "maphieu")
    private String maPhieu;
    @Column(name = "tieude")
    private String tieuDe;
    @Column(name = "ngaynhap")
    private LocalDate ngayNhap;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "phieuNhap")
    @JsonManagedReference
    private Set<ChiTietPhieuNhap> chiTietPhieuNhaps;

    public int getPhieuNhapId() {
        return phieuNhapId;
    }

    public void setPhieuNhapId(int phieuNhapId) {
        this.phieuNhapId = phieuNhapId;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public Set<ChiTietPhieuNhap> getChiTietPhieuNhaps() {
        return chiTietPhieuNhaps;
    }

    public void setChiTietPhieuNhaps(Set<ChiTietPhieuNhap> chiTietPhieuNhaps) {
        this.chiTietPhieuNhaps = chiTietPhieuNhaps;
    }
}
