package com.example.phieuthu.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "loainguyenlieu")
public class LoaiNguyenLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loainguyenlieuid")
    private int loaiNguyenLieuId;
    @Column(name = "tenloai")
    private String tenLoai;
    @Column(name = "mota")
    private String moTa;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "loaiNguyenLieu")
    @JsonManagedReference
    private Set<NguyenLieu> nguyenLieus;

    public int getLoaiNguyenLieuId() {
        return loaiNguyenLieuId;
    }

    public void setLoaiNguyenLieuId(int loaiNguyenLieuId) {
        this.loaiNguyenLieuId = loaiNguyenLieuId;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Set<NguyenLieu> getNguyenLieus() {
        return nguyenLieus;
    }

    public void setNguyenLieus(Set<NguyenLieu> nguyenLieus) {
        this.nguyenLieus = nguyenLieus;
    }
}
