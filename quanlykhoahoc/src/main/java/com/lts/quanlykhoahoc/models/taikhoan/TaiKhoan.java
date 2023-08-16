package com.lts.quanlykhoahoc.models.taikhoan;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lts.quanlykhoahoc.models.baiviet.BaiViet;
import com.lts.quanlykhoahoc.models.dangkyhoc.DangKyHoc;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "taikhoan")

public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taikhoanid")
    private int taiKhoanId;
    @Column(name = "tennguoidung")
    private String tenNguoiDung;
    @Column(name = "taikhoan")
    private String taiKhoan;
    @Column(name = "matkhau")
    private String matKhau;
    @Column(name = "quyenhanid", updatable = false, insertable = false)
    private int quyenHanId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "taiKhoan")
    @JsonManagedReference
    private Set<DangKyHoc> dangKyHocs;

    @ManyToOne()
    @JoinColumn(name = "quyenhanid", foreignKey = @ForeignKey(name = "fk_taikhoan_quyenhan"))
    @JsonBackReference
    private QuyenHan quyenHan;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "taiKhoan")
    @JsonManagedReference
    private Set<BaiViet> baiViets;

    public Set<BaiViet> getBaiViets() {
        return baiViets;
    }

    public void setBaiViets(Set<BaiViet> baiViets) {
        this.baiViets = baiViets;
    }

    public int getTaiKhoanId() {
        return taiKhoanId;
    }

    public void setTaiKhoanId(int taiKhoanId) {
        this.taiKhoanId = taiKhoanId;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public int getQuyenHanId() {
        return quyenHanId;
    }

    public void setQuyenHanId(int quyenHanId) {
        this.quyenHanId = quyenHanId;
    }

    public Set<DangKyHoc> getDangKyHocs() {
        return dangKyHocs;
    }

    public void setDangKyHocs(Set<DangKyHoc> dangKyHocs) {
        this.dangKyHocs = dangKyHocs;
    }

    public QuyenHan getQuyenHan() {
        return quyenHan;
    }

    public void setQuyenHan(QuyenHan quyenHan) {
        this.quyenHan = quyenHan;
    }
}
