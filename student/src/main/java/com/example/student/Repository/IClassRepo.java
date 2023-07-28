package com.example.student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.student.Models.Class;

@Repository
public interface IClassRepo extends JpaRepository<Class, Integer> {
}
