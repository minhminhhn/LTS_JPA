package com.example.student.Controller;

import com.example.student.Models.Class;
import com.example.student.Models.Student;
import com.example.student.Services.ClassServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping(value = "api/version1.0")
public class ClassController {
    @Autowired
    private ClassServices classServices;

    @RequestMapping(value = "getallclass", method = RequestMethod.GET)
    public List<Class> getAllClass() {
        return classServices.getAllClass();
    }

    @RequestMapping(value = "getstudentbyclassid", method = RequestMethod.GET)
    public Set<Student> getStudentByClassId(@RequestParam int id) {
        return classServices.getStudentByClassId(id);
    }
}
