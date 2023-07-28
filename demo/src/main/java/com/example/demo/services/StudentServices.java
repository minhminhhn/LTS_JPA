package com.example.demo.services;

import com.example.demo.models.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServices implements IStudentServices{

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student addNewStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student removeStudent(int id) {

        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()) {
            return  null;
        }

        studentRepository.delete(student.get());
        return student.get();
    }

    @Override
    public Student remakeStudent(Student sts) {
        Optional<Student> student = studentRepository.findById(sts.getId());
        if(student.isEmpty()) {
            return  null;
        }
        Student st = student.get();
        st.setName(sts.getName());
        studentRepository.save(st);
        return st;
    }

    @Override
    public Student getStudentByID(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isEmpty()) {
            return  null;
        }
        return student.get();
    }

    @Override
    public List<Student> getListStudentByID(int begin, int end) {
        if(begin > end) {
            int tmp = begin;
            begin = end;
            end = tmp;
        }
        List<Student> studentList = new ArrayList<>();
        for(Student st : studentRepository.findAll()){
            if(st.getId() >= begin && st.getId()<=end) {
                studentList.add(st);
            }
        }
        return studentList;
    }
}
