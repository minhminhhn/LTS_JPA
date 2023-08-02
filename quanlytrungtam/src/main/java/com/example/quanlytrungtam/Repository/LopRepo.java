package com.example.quanlytrungtam.Repository;

import com.example.quanlytrungtam.Models.Lop;
import jdk.jfr.Registered;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

@Registered
public interface LopRepo extends JpaRepository<Lop, Integer> {
}
