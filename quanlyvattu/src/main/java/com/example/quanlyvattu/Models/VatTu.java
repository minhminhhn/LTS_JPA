package com.example.quanlyvattu.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.NaturalId;

import java.lang.annotation.Target;
import java.util.Set;

@Entity
@Table(name = "vattu")
public class VatTu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vattuid")
    private int vatTuId;

    @Column(name = "tenvattu")
    private String tenVatTu;
    @Column(name = "soluongton")
    private int soLuongTon;

    @OneToMany(mappedBy = "vatTu", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<ChiTietPhieuNhap> chiTietPhieuNhaps;

    @OneToMany(mappedBy = "vatTu", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<ChiTietPhieuXuat> chiTietPhieuXuats;

}
