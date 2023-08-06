package com.example.quanlymonan.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table(name = "monan")
public class MonAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "monanid")
    private int monAnId;
    @Column(name = "loaimonanid", insertable=false, updatable=false)
    private int loaiMonAnId;
    @Column(name = "tenmon")
    @NotNull
    private String tenMon;
    @Column(name = "ghichu")
    private String ghiChu;

    @ManyToOne()
    @JoinColumn(name = "loaimonanid", foreignKey = @ForeignKey(name = "fk_monan_loaimonan"))
    @JsonBackReference
    private LoaiMonAn loaiMonAn;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "monAn")
    @JsonManagedReference
    private Set<CongThuc> congThucs;

    public LoaiMonAn getLoaiMonAn() {
        return loaiMonAn;
    }

    public void setLoaiMonAn(LoaiMonAn loaiMonAn) {
        this.loaiMonAn = loaiMonAn;
    }

    public Set<CongThuc> getCongThucs() {
        return congThucs;
    }

    public void setCongThucs(Set<CongThuc> congThucs) {
        this.congThucs = congThucs;
    }

    public int getMonAnId() {
        return monAnId;
    }

    public void setMonAnId(int monAnId) {
        this.monAnId = monAnId;
    }

    public int getLoaiMonAnId() {
        return loaiMonAnId;
    }

    public void setLoaiMonAnId(int loaiMonAnId) {
        this.loaiMonAnId = loaiMonAnId;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
