package com.example.phieuthu.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "nguyenlieu")
public class NguyenLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nguyenlieuid")
    private int nguyenLieuId;
    @Column(name = "loainguyenlieuid", updatable = false, insertable = false)
    private int loaiNguyenLieuId;
    @Column(name = "tennguyenlieu")
    @Size(max = 20)
    private String tenNguyenLieu;
    @Column(name = "giaban")
    private int giaBan;
    @Column(name = "donvitinh")
    @Size(max = 10)
    private String donViTinh;
    @Column(name = "soluongkho")
    private int soLuongKho;

    @ManyToOne()
    @JoinColumn(name = "loainguyenlieuid", foreignKey = @ForeignKey(name = "fk_nguyenlieu_loainguyenlieu"))
    @JsonBackReference
    private LoaiNguyenLieu loaiNguyenLieu;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nguyenLieu")
    @JsonManagedReference
    private Set<ChiTietPhieuThu> chiTietPhieuThus;

    public int getNguyenLieuId() {
        return nguyenLieuId;
    }

    public void setNguyenLieuId(int nguyenLieuId) {
        this.nguyenLieuId = nguyenLieuId;
    }

    public int getLoaiNguyenLieuId() {
        return loaiNguyenLieuId;
    }

    public void setLoaiNguyenLieuId(int loaiNguyenLieuId) {
        this.loaiNguyenLieuId = loaiNguyenLieuId;
    }

    public String getTenNguyenLieu() {
        return tenNguyenLieu;
    }

    public void setTenNguyenLieu(String tenNguyenLieu) {
        this.tenNguyenLieu = tenNguyenLieu;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public int getSoLuongKho() {
        return soLuongKho;
    }

    public void setSoLuongKho(int soLuongKho) {
        this.soLuongKho = soLuongKho;
    }

    public LoaiNguyenLieu getLoaiNguyenLieu() {
        return loaiNguyenLieu;
    }

    public void setLoaiNguyenLieu(LoaiNguyenLieu loaiNguyenLieu) {
        this.loaiNguyenLieu = loaiNguyenLieu;
    }

    public Set<ChiTietPhieuThu> getChiTietPhieuThus() {
        return chiTietPhieuThus;
    }

    public void setChiTietPhieuThus(Set<ChiTietPhieuThu> chiTietPhieuThus) {
        this.chiTietPhieuThus = chiTietPhieuThus;
    }
}
