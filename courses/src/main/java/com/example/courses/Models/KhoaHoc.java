package com.example.courses.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "khoahoc")
public class KhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "khoahocid")
    private int khoaHocID;
    @Column(name = "tenkhoahoc")
    private String tenKhoaHoc;
    @Column(name = "mota")
    private String moTa;
    @Column(name = "hocphi")
    private int hocPhi;

    @Column(name = "ngaybatdau")
    private LocalDate ngayBatDau;
    @Column(name = "ngaykeythuc")
    private LocalDate ngayKetThuc;

    @OneToMany(mappedBy = "khoaHoc")
    @JsonIgnoreProperties(value = "khoahoc")
    private Set<HocVien> hocViens;

    @OneToMany(mappedBy = "khoaHoc")
    @JsonIgnoreProperties(value = "khoahoc")
    private Set<NgayHoc> ngayHocs;


}
