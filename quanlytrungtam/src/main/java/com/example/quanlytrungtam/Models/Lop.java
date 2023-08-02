package com.example.quanlytrungtam.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "lop")
public class Lop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lopid")
    private int lopId;
    @Column(name = "tenlop")
    private String tenLop;

    @OneToMany(mappedBy = "lop")
    @JsonIgnoreProperties(value = "lop")
    private Set<HocVien> hocViens;
}
