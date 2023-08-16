package com.lts.quanlykhoahoc.models.baiviet;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "chude")
public class ChuDe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chudeid")
    private int chuDeId;
    @Column(name = "tenchude")
    private String tenChuDe;
    @Column(name = "noidung")
    private String noiDung;
    @Column(name = "loaibaivietid", updatable = false, insertable = false)
    private int loaiBaiVietId;

    @ManyToOne()
    @JoinColumn(name = "loaibaivietid", foreignKey = @ForeignKey(name = "fk_chude_loaibaiviet"))
    @JsonBackReference()
    private LoaiBaiViet loaiBaiViet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chuDe")
    @JsonManagedReference
    private Set<BaiViet> baiViets;

}
