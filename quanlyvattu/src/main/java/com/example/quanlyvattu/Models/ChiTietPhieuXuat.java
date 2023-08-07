package com.example.quanlyvattu.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "chitietphieuxuat")
public class ChiTietPhieuXuat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chitietphieuxuatid")
    private int chiTietPhieuXuatId;
    @Column(name = "vattuid", insertable = false, updatable = false)
    private int vatTuId;
    @Column(name = "phieuxuatid", insertable = false, updatable = false)
    private int phieuXuatId;
    @Column(name = "soluongxuat")
    private int soLuongXuat;

    @ManyToOne()
    @JoinColumn(name = "vattuid", foreignKey = @ForeignKey(name = "fk_chitietphieuxuat_vattu"))
    @JsonBackReference()
    private VatTu vatTu;

    @ManyToOne()
    @JoinColumn(name = "phieuxuatid", foreignKey = @ForeignKey(name = "fk_chitietphieuxuat_phieuxuat"))
    @JsonBackReference
    private PhieuXuat phieuXuat;
}
