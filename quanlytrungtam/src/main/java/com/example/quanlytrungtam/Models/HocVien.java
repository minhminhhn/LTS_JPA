package com.example.quanlytrungtam.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "hocvien")
public class HocVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hocvienid")
    private int hocVienId;

    @Column(name = "lopid",insertable=false, updatable=false)
    private int lopId;
    @Column(name = "hoten")
    @Size(min = 6, max = 50, message = "Họ và tên từ 6-50 kí tự")
    @NotNull(message = "Họ và tên không được để trống")
    private String hoTen;
    @Column(name = "ngaySinh")
    @NotNull(message = "Ngày sinh không được để trống.")
    private LocalDate ngaySinh;
    @Column(name = "gioitinh")
    @NotNull(message = "Giới tính không được để trống.")
    private String gioiTinh;

    @Size(min = 10, max = 100, message = "Email từ 10-100 kí tự.")
    @NotNull(message = "Email không được để trống.")
    @Email(message = "Email không hợp lệ.")
    private String email;

    @Size(min = 10, max = 15, message = "Sđt từ 10-15 ký tự.")
    @NotNull(message = "Sđt không được để trống.")
    private String sdt;
    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "ngaydangky")
    private LocalDate ngayDangKy;

    @ManyToOne()
    @JoinColumn(name = "lopid", foreignKey = @ForeignKey(name = "fk_hocvien_lop"))
    @JsonBackReference
    private Lop lop;

    public int getLopId() {
        return lopId;
    }

    public void setLopId(int lopId) {
        this.lopId = lopId;
    }

    public LocalDate getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(LocalDate ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public Lop getLop() {
        return lop;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    public int getHocVienId() {
        return hocVienId;
    }

    public void setHocVienId(int hocVienId) {
        this.hocVienId = hocVienId;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}
