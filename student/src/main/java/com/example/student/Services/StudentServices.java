package com.example.student.Services;

import com.example.student.Models.Class;
import com.example.student.Models.Student;
import com.example.student.Repository.IClassRepo;
import com.example.student.Repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices implements IStudentServices {

    @Autowired
    private IStudentRepo studentRepo;
    @Autowired
    private IClassRepo classRepo;

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Student addNewStudent(Student student) {
        if (!kiemTraHotenVaNamsinh(student)) {
            throw new IllegalArgumentException("Họ tên hoặc năm sinh không hợp lệ");
        }
        Class aClass = classRepo.findById(student.getClassId()).orElse(null);
        if (aClass == null) {
            throw new IllegalArgumentException("Lớp không tồn tại");
        }
        if (aClass.getStudents().size() >= 20) {
            throw new IllegalArgumentException("Lớp đã đạt sĩ số tối đa");
        }
        try {
            student.setaClass(aClass);
            aClass.setNumber(aClass.getNumber() + 1);
            classRepo.save(aClass);
            studentRepo.save(student);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return student;
    }

    @Override
    public Student remakeStudent(Student studentRM) {
        Optional<Student> student = studentRepo.findById(studentRM.getStudentId());
        if (student.isEmpty()) {
            return null;
        }
        Class cl = classRepo.findById(studentRM.getClassId()).get();
        if (studentRM.getaClass().getId() != cl.getId()) {
            if (cl.getStudents().size() >= 20) {
                throw new IllegalArgumentException("Lớp đã đạt sĩ số tối đa");
            } else {
                Class cl1 = classRepo.findById(studentRM.getaClass().getId()).get();
                cl1.setNumber(cl1.getNumber() - 1);
                cl.setNumber(cl.getNumber() + 1);
                classRepo.save(cl);
                classRepo.save(cl1);
                studentRM.setaClass(cl);
            }
        }
        studentRepo.save(studentRM);
        return studentRM;
    }

    @Override
    public Student removeStudent(int id) {
        Optional<Student> st = studentRepo.findById(id);
        if (st == null) {
            return null;
        }
        studentRepo.delete(st.get());
        Class cl = classRepo.findById(st.get().getClassId()).get();
        cl.setNumber(cl.getNumber() - 1);
        classRepo.save(cl);
        return st.get();
    }

    @Override
    public Student changeClass(int idSt, int idCl) {
        Class cl = classRepo.findById(idCl).orElse(null);
        Student st = studentRepo.findById(idSt).orElse(null);
        if (cl == null) {
            throw new IllegalArgumentException("Lớp không tồn tại");
        } else {
            if (cl.getStudents().size() >= 20) {
                throw new IllegalArgumentException("Lớp đã đạt sĩ số tối đa");
            } else {
                Class cl1 = classRepo.findById(st.getaClass().getId()).get();
                cl1.setNumber(cl1.getNumber() - 1);
                cl.setNumber(cl.getNumber() + 1);
                classRepo.save(cl);
                classRepo.save(cl1);
                st.setaClass(cl);
                st.setClassId(idCl);
            }
        }
        return st;
    }

    @Override
    public boolean kiemTraHotenVaNamsinh(Student student) {
        String hoTen = student.getName();
        String[] words = hoTen.split("\\s+");
        if (words.length < 2 || hoTen.length() > 20) {
            return false;
        }

        int namSinh = student.getYearOfBirth();
        return namSinh >= 2002 && namSinh <= 2014;
    }

}
