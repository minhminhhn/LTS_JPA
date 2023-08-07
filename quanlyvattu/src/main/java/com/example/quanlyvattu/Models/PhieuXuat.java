package com.example.quanlyvattu.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "phieuxuat")
public class PhieuXuat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phieuxuatid")
    private int phieuXuatId;
    @Column(name = "maphieu")
    private String maPhieu;
    @Column(name = "tieude")
    private String tieuDe;
    @Column(name = "ngayxuat")
    private LocalDate ngayXuat;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "phieuXuat")
    @JsonManagedReference
    private Set<ChiTietPhieuXuat> chiTietPhieuXuats;
}
