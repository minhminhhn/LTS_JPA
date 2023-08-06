package com.example.quanlymonan.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table(name = "loaimonan")
public class LoaiMonAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loaimonanid")
    private int loaiMonAnId;
    @Column(name = "tenloai")
    @NotNull
    private String tenLoai;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "loaiMonAn")
    @JsonManagedReference
    private Set<MonAn> monAns;

    public Set<MonAn> getMonAns() {
        return monAns;
    }

    public void setMonAns(Set<MonAn> monAns) {
        this.monAns = monAns;
    }

    public int getLoaiMonAnId() {
        return loaiMonAnId;
    }

    public void setLoaiMonAnId(int loaiMonAnId) {
        this.loaiMonAnId = loaiMonAnId;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }
}
