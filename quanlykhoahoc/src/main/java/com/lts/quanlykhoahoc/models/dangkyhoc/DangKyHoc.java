package com.lts.quanlykhoahoc.models.dangkyhoc;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lts.quanlykhoahoc.models.hocvien.HocVien;
import com.lts.quanlykhoahoc.models.khoahoc.KhoaHoc;
import com.lts.quanlykhoahoc.models.taikhoan.TaiKhoan;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "dangkyhoc")
public class DangKyHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "khoahocid", updatable = false, insertable = false)
    private int khoaHocId;
    @Column(name = "hocvienid", updatable = false, insertable = false)
    private int hocVienId;
    @Column(name = "ngaydangky")
    private LocalDate ngayDangKy;
    @Column(name = "ngaybatdau")
    private LocalDate ngayBatDau;
    @Column(name = "ngayketthuc")
    private LocalDate ngayKetThuc;
    @Column(name = "tinhtranghocid", updatable = false, insertable = false)
    private int tinhTrangHocId;
    @Column(name = "taikhoanid", updatable = false, insertable = false)
    private int taiKhoanId;

    @ManyToOne
    @JoinColumn(name = "khoahocid", foreignKey = @ForeignKey(name = "fk_dangkyhoc_khoahoc"))
    @JsonBackReference
    private KhoaHoc khoaHoc;

    @ManyToOne
    @JoinColumn(name = "tinhtranghocid", foreignKey = @ForeignKey(name = "fk_dangkyhoc_tinhtranghoc"))
    @JsonBackReference
    private TinhTrangHoc tinhTrangHoc;

    @ManyToOne
    @JoinColumn(name = "hocvienid", foreignKey = @ForeignKey(name = "fk_dangkyhoc_hocvien"))
    @JsonBackReference
    private HocVien hocVien;

    @ManyToOne
    @JoinColumn(name = "taikhoanid", foreignKey = @ForeignKey(name = "fk_dangkyhoc_taikhoan"))
    @JsonBackReference
    private TaiKhoan taiKhoan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKhoaHocId() {
        return khoaHocId;
    }

    public void setKhoaHocId(int khoaHocId) {
        this.khoaHocId = khoaHocId;
    }

    public int getHocVienId() {
        return hocVienId;
    }

    public void setHocVienId(int hocVienId) {
        this.hocVienId = hocVienId;
    }

    public LocalDate getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(LocalDate ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getTinhTrangHocId() {
        return tinhTrangHocId;
    }

    public void setTinhTrangHocId(int tinhTrangHocId) {
        this.tinhTrangHocId = tinhTrangHocId;
    }

    public int getTaiKhoanId() {
        return taiKhoanId;
    }

    public void setTaiKhoanId(int taiKhoanId) {
        this.taiKhoanId = taiKhoanId;
    }

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public TinhTrangHoc getTinhTrangHoc() {
        return tinhTrangHoc;
    }

    public void setTinhTrangHoc(TinhTrangHoc tinhTrangHoc) {
        this.tinhTrangHoc = tinhTrangHoc;
    }

    public HocVien getHocVien() {
        return hocVien;
    }

    public void setHocVien(HocVien hocVien) {
        this.hocVien = hocVien;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
}
