package com.example.quanlyvattu.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "chitietphieunhap")
public class ChiTietPhieuNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chitietphieunhapid")
    private int chiTietPhieuNhapId;
    @Column(name = "vattuid", insertable=false, updatable=false)
    private int vatTuId;
    @Column(name = "phieunhapid", insertable=false, updatable=false)
    private int phieuNhapId;
    @Column(name = "soluongnhap")
    private int soLuongNhap;

    @ManyToOne()
    @JoinColumn(name = "vattuid", foreignKey = @ForeignKey(name = "fk_chitietphieunhap_vattu"))
    @JsonBackReference()
    private VatTu vatTu;

    @ManyToOne()
    @JoinColumn(name = "phieunhapid", foreignKey = @ForeignKey(name = "fk_chitietphieunhap_phieunhap"))
    @JsonBackReference
    private PhieuNhap phieuNhap;

    public int getChiTietPhieuNhapId() {
        return chiTietPhieuNhapId;
    }

    public void setChiTietPhieuNhapId(int chiTietPhieuNhapId) {
        this.chiTietPhieuNhapId = chiTietPhieuNhapId;
    }

    public int getVatTuId() {
        return vatTuId;
    }

    public void setVatTuId(int vatTuId) {
        this.vatTuId = vatTuId;
    }

    public int getPhieuNhapId() {
        return phieuNhapId;
    }

    public void setPhieuNhapId(int phieuNhapId) {
        this.phieuNhapId = phieuNhapId;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public VatTu getVatTu() {
        return vatTu;
    }

    public void setVatTu(VatTu vatTu) {
        this.vatTu = vatTu;
    }

    public PhieuNhap getPhieuNhap() {
        return phieuNhap;
    }

    public void setPhieuNhap(PhieuNhap phieuNhap) {
        this.phieuNhap = phieuNhap;
    }
}
