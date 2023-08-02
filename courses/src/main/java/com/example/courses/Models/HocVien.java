package com.example.courses.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "hocvien")
public class HocVien{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hocvienid")
    private int hocVienID;
    @Column(name = "hoten")
    private String hoTen;
    @Column(name = "ngaysinh")
    private LocalDate ngaySinh;
    @Column(name = "quequan")
    private String queQuan;
    @Column(name = "diachi")
    private String diaChi;
    @Column(name = "sodienthoai")
    private String soDienThoai;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "khoahocid", foreignKey = @ForeignKey(name = "fk_hocvien_khoahoc"))
    @JsonIgnoreProperties(value = "hocViens")
    private KhoaHoc khoaHoc;

}
