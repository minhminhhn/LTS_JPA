package com.example.student.Services;

import com.example.student.Models.Student;
import com.example.student.StudentApplication;

import java.util.List;

public interface IStudentServices {
    public List<Student> getAllStudent();
    public Student addNewStudent(Student student);
    public Student remakeStudent(Student studentRM);
    public Student removeStudent(int id);
    public Student changeClass(int idSt, int idCl);
    public boolean kiemTraHotenVaNamsinh(Student student);
}
