package com.example.quanlyvattu.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "phieunhap")
public class PhieuNhap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phieunhapid")
    private int phieuNhapId;
    @Column(name = "maphieu")
    private String maPhieu;
    @Column(name = "tieude")
    private String tieuDe;
    @Column(name = "ngaynhap")
    private LocalDate ngayNhap;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "phieuNhap")
    @JsonManagedReference
    private Set<ChiTietPhieuNhap> chiTietPhieuNhaps;
}
