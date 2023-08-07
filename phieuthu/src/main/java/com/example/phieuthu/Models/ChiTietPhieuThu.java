package com.example.phieuthu.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "chitietphieuthu")
public class ChiTietPhieuThu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chitietphieuthuid")
    private int chiTietPhieuThuId;
    @Column(name = "nguyenlieuid", updatable = false, insertable = false)
    private int nguyenLieuId;
    @Column(name = "phieuthuid", updatable = false, insertable = false)
    private int phieuThuId;
    @Column(name = "soluongban")
    private int soLuongBan;

    @ManyToOne()
    @JoinColumn(name = "nguyenlieuid", foreignKey = @ForeignKey(name = "fk_chitiet_nguyenlieu"))
    @JsonBackReference
    private NguyenLieu nguyenLieu;

    @ManyToOne()
    @JoinColumn(name = "phieuthuid", foreignKey = @ForeignKey(name = "fk_chitiet_phieuthu"))
    @JsonBackReference
    private PhieuThu phieuThu;


    public int getChiTietPhieuThuId() {
        return chiTietPhieuThuId;
    }

    public void setChiTietPhieuThuId(int chiTietPhieuThuId) {
        this.chiTietPhieuThuId = chiTietPhieuThuId;
    }

    public int getNguyenLieuId() {
        return nguyenLieuId;
    }

    public void setNguyenLieuId(int nguyenLieuId) {
        this.nguyenLieuId = nguyenLieuId;
    }

    public int getPhieuThuId() {
        return phieuThuId;
    }

    public void setPhieuThuId(int phieuThuId) {
        this.phieuThuId = phieuThuId;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public NguyenLieu getNguyenLieu() {
        return nguyenLieu;
    }

    public void setNguyenLieu(NguyenLieu nguyenLieu) {
        this.nguyenLieu = nguyenLieu;
    }

    public PhieuThu getPhieuThu() {
        return phieuThu;
    }

    public void setPhieuThu(PhieuThu phieuThu) {
        this.phieuThu = phieuThu;
    }
}
