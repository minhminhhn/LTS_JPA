package com.example.quanlymonan.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "congthuc")
public class CongThuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "congthucid")
    private int congThucId;
    @Column(name = "nguyenlieuid", insertable=false, updatable=false)
    private int nguyenLieuId;
    @Column(name = "monanid", insertable=false, updatable=false)
    private int monAnId;


    @Column(name = "soluong")
    @NotNull
    private int soLuong;
    @Column(name = "donvitinh")
    @NotNull
    private String donViTinh;

    @ManyToOne()
    @JoinColumn(name = "monanid", foreignKey = @ForeignKey(name = "fk_congthuc_monan"))
    @JsonBackReference
    private MonAn monAn;

    @ManyToOne()
    @JoinColumn(name = "nguyenlieuid", foreignKey = @ForeignKey(name = "fk_congthuc_nguyenlieu"))
    @JsonBackReference
    private NguyenLieu nguyenLieu;

    public MonAn getMonAn() {
        return monAn;
    }

    public void setMonAn(MonAn monAn) {
        this.monAn = monAn;
    }

    public NguyenLieu getNguyenLieu() {
        return nguyenLieu;
    }

    public void setNguyenLieu(NguyenLieu nguyenLieu) {
        this.nguyenLieu = nguyenLieu;
    }

    public int getCongThucId() {
        return congThucId;
    }

    public void setCongThucId(int congThucId) {
        this.congThucId = congThucId;
    }

    public int getNguyenLieuId() {
        return nguyenLieuId;
    }

    public void setNguyenLieuId(int nguyenLieuId) {
        this.nguyenLieuId = nguyenLieuId;
    }

    public int getMonAnId() {
        return monAnId;
    }

    public void setMonAnId(int monAnId) {
        this.monAnId = monAnId;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }
}

