package com.example.employee.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "nhanvien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nhanvienid")
    private int nhanVienId;

    @Column(name = "hoten")
    private String hoTen;

    @Column(name = "sodienthoai")
    private String soDienThoai;

    @Column(name = "diachi")
    private String diaChi;

    private String email;

    @Column(name = "hesoluong")
    private float heSoLuong;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nhanVien")
    @JsonManagedReference
    private Set<PhanCong> phanCongs;

    public Set<PhanCong> getPhanCongs() {
        return phanCongs;
    }

    public void setPhanCongs(Set<PhanCong> phanCongs) {
        this.phanCongs = phanCongs;
    }

    public int getNhanVienId() {
        return nhanVienId;
    }

    public void setNhanVienId(int nhanVienId) {
        this.nhanVienId = nhanVienId;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(float heSoLuong) {
        this.heSoLuong = heSoLuong;
    }
}
