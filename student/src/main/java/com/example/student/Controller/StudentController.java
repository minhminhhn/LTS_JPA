package com.example.student.Controller;

import com.example.student.Models.Student;
import com.example.student.Services.StudentServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/version1.0")
public class StudentController {

    @Autowired
    private StudentServices studentServices;

    @RequestMapping(value = "getallstudent", method = RequestMethod.GET)
    public List<Student> getAllStudent() {
        return studentServices.getAllStudent();
    }
    @RequestMapping(value = "addnewstudent", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student addNewStudent(@RequestBody String student) {
        Gson gson = new Gson();
        Student st = gson.fromJson(student, Student.class);
        return studentServices.addNewStudent(st);
    }

    @RequestMapping(value = "remakestudent", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student remakeStudent(@RequestBody String student) {
        Gson gson = new Gson();
        Student st = gson.fromJson(student, Student.class);
        return studentServices.remakeStudent(st);
    }

    @RequestMapping(value = "removestudent", method = RequestMethod.DELETE)
    public Student removeStudent(@RequestParam int id) {
        return studentServices.removeStudent(id);
    }
    @RequestMapping(value = "changeclass", method = RequestMethod.PUT)
    public Student changeClass(@RequestParam int idSt, int idCl){
        return studentServices.changeClass(idSt, idCl);
    }
}
