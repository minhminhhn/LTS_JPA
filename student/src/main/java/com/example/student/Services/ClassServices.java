package com.example.student.Services;

import com.example.student.Models.Class;
import com.example.student.Models.Student;
import com.example.student.Repository.IClassRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ClassServices implements IClassServices{
    @Autowired
    private IClassRepo classRepo;


    @Override
    public List<Class> getAllClass() {
        return classRepo.findAll();
    }

    @Override
    public Set<Student> getStudentByClassId(int classId) {
        Class aClass = classRepo.findById(classId).get();
        return aClass.getStudents();
    }

    @Override
    public boolean kiemTraTenLop(String tenLop) {
        return tenLop.length() <= 10;
    }
}
