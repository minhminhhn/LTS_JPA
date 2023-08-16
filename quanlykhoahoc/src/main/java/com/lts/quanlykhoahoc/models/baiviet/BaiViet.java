package com.lts.quanlykhoahoc.models.baiviet;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lts.quanlykhoahoc.models.taikhoan.TaiKhoan;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "baiviet")
public class BaiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "baivietid")
    private int baiVietId;
    @Column(name = "tenbaiviet")
    private String tenBaiViet;
    @Column(name = "thoigiantao")
    private LocalDateTime thoiGianTao;
    @Column(name = "tentacgia")
    private String tenTacGia;
    @Column(name = "noidung")
    private String noiDung;
    @Column(name = "noidungngan")
    private String noiDungNgan;
    @Column(name = "hinhanh")
    private String hinhAnh;
    @Column(name = "chudeid", updatable = false, insertable = false)
    private int chuDeId;
    @Column(name = "taikhoanid", updatable = false, insertable = false)
    private int taiKhoanId;

    @ManyToOne()
    @JoinColumn(name = "taikhoanid",foreignKey = @ForeignKey(name = "fk_baiviet_taikhoan"))
    @JsonBackReference
    private TaiKhoan taiKhoan;

    @ManyToOne()
    @JoinColumn(name = "chudeid",foreignKey = @ForeignKey(name = "fk_baiviet_chude"))
    @JsonBackReference
    private ChuDe chuDe;
}
