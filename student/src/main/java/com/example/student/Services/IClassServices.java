package com.example.student.Services;

import com.example.student.Models.Class;
import com.example.student.Models.Student;

import java.util.List;
import java.util.Set;

public interface IClassServices {
    public List<Class> getAllClass();
    public Set<Student> getStudentByClassId(int classId);
    public boolean kiemTraTenLop(String tenLop);
}
