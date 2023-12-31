package com.example.quanlymonan.Models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table(name = "nguyenlieu")
public class NguyenLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nguyenlieuid")
    private int nguyenLieuId;
    @Column(name = "tennguyenlieu")
    @NotNull
    private String tenNguyenLieu;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "nguyenLieu")
    @JsonManagedReference
    private Set<CongThuc> congThucs;

    public int getNguyenLieuId() {
        return nguyenLieuId;
    }

    public void setNguyenLieuId(int nguyenLieuId) {
        this.nguyenLieuId = nguyenLieuId;
    }

    public String getTenNguyenLieu() {
        return tenNguyenLieu;
    }

    public void setTenNguyenLieu(String tenNguyenLieu) {
        this.tenNguyenLieu = tenNguyenLieu;
    }


    public Set<CongThuc> getCongThucs() {
        return congThucs;
    }

    public void setCongThucs(Set<CongThuc> congThucs) {
        this.congThucs = congThucs;
    }
}
