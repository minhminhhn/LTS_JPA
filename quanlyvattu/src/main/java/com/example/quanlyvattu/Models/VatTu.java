package com.example.quanlyvattu.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

import java.lang.annotation.Target;
import java.util.Set;

@Entity
@Table(name = "vattu")
public class VatTu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vattuid")
    private int vatTuId;

    @Column(name = "tenvattu")
    private String tenVatTu;
    @Column(name = "soluongton")
    private int soLuongTon;

    @OneToMany(mappedBy = "vatTu", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<ChiTietPhieuNhap> chiTietPhieuNhaps;

    @OneToMany(mappedBy = "vatTu", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<ChiTietPhieuXuat> chiTietPhieuXuats;

    public int getVatTuId() {
        return vatTuId;
    }

    public void setVatTuId(int vatTuId) {
        this.vatTuId = vatTuId;
    }

    public String getTenVatTu() {
        return tenVatTu;
    }

    public void setTenVatTu(String tenVatTu) {
        this.tenVatTu = tenVatTu;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public Set<ChiTietPhieuNhap> getChiTietPhieuNhaps() {
        return chiTietPhieuNhaps;
    }

    public void setChiTietPhieuNhaps(Set<ChiTietPhieuNhap> chiTietPhieuNhaps) {
        this.chiTietPhieuNhaps = chiTietPhieuNhaps;
    }

    public Set<ChiTietPhieuXuat> getChiTietPhieuXuats() {
        return chiTietPhieuXuats;
    }

    public void setChiTietPhieuXuats(Set<ChiTietPhieuXuat> chiTietPhieuXuats) {
        this.chiTietPhieuXuats = chiTietPhieuXuats;
    }
}
