package com.example.courses.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "ngayhoc")
public class NgayHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ngayhocid")
    private int ngayHocID;
    @Column(name = "noidung")
    private String noiDung;
    @Column(name = "ghichu")
    private String ghiChu;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "khoahocid", foreignKey = @ForeignKey(name = "fk_ngayhoc_khoahoc"))
    @JsonIgnoreProperties(value = "ngayHocs")
    private KhoaHoc khoaHoc;
}
