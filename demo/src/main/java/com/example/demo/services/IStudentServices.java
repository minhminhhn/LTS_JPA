package com.example.demo.services;

import com.example.demo.models.Student;

import java.util.List;

public interface IStudentServices {
    public List<Student> getAllStudent();
    public Student addNewStudent(Student student);
    public Student removeStudent(int id);
    public Student remakeStudent(Student st);

    public Student getStudentByID(int id);

    public List<Student> getListStudentByID(int start, int end);
}
