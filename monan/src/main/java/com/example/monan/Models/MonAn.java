package com.example.monan.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

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
    private String tenMon;
    @Column(name = "giaban")
    private int giaBan;
    @Column(name = "gioithieu")
    private String gioiThieu;
    @Column(name = "cachlam")
    private String cachLam;

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

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }

    public String getCachLam() {
        return cachLam;
    }

    public void setCachLam(String cachLam) {
        this.cachLam = cachLam;
    }
}
