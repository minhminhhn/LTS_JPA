package com.example.quanlyvattu.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "chitietphieuxuat")
public class ChiTietPhieuXuat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chitietphieuxuatid")
    private int chiTietPhieuXuatId;
    @Column(name = "vattuid", insertable = false, updatable = false)
    private int vatTuId;
    @Column(name = "phieuxuatid", insertable = false, updatable = false)
    private int phieuXuatId;
    @Column(name = "soluongxuat")
    private int soLuongXuat;

    @ManyToOne()
    @JoinColumn(name = "vattuid", foreignKey = @ForeignKey(name = "fk_chitietphieuxuat_vattu"))
    @JsonBackReference()
    private VatTu vatTu;

    @ManyToOne()
    @JoinColumn(name = "phieuxuatid", foreignKey = @ForeignKey(name = "fk_chitietphieuxuat_phieuxuat"))
    @JsonBackReference
    private PhieuXuat phieuXuat;

    public int getChiTietPhieuXuatId() {
        return chiTietPhieuXuatId;
    }

    public void setChiTietPhieuXuatId(int chiTietPhieuXuatId) {
        this.chiTietPhieuXuatId = chiTietPhieuXuatId;
    }

    public int getVatTuId() {
        return vatTuId;
    }

    public void setVatTuId(int vatTuId) {
        this.vatTuId = vatTuId;
    }

    public int getPhieuXuatId() {
        return phieuXuatId;
    }

    public void setPhieuXuatId(int phieuXuatId) {
        this.phieuXuatId = phieuXuatId;
    }

    public int getSoLuongXuat() {
        return soLuongXuat;
    }

    public void setSoLuongXuat(int soLuongXuat) {
        this.soLuongXuat = soLuongXuat;
    }

    public VatTu getVatTu() {
        return vatTu;
    }

    public void setVatTu(VatTu vatTu) {
        this.vatTu = vatTu;
    }

    public PhieuXuat getPhieuXuat() {
        return phieuXuat;
    }

    public void setPhieuXuat(PhieuXuat phieuXuat) {
        this.phieuXuat = phieuXuat;
    }
}
