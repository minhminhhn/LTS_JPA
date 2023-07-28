package com.example.demo.controller;

import com.example.demo.models.Student;
import com.example.demo.services.StudentServices;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
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
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Student student1 = gson.fromJson(student, Student.class);
        return studentServices.addNewStudent(student1);
    }

    @RequestMapping(value = "deletestudent", method = RequestMethod.DELETE)
    public Student removeStudent(@RequestParam int id) {
        return studentServices.removeStudent(id);
    }

    @RequestMapping(value = "remakestudent", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Student remakeStudent(@RequestBody String studentRemake) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Student student = gson.fromJson(studentRemake, Student.class);
        return studentServices.remakeStudent(student);
    }

    @RequestMapping(value = "getstudent", method = RequestMethod.GET)
    public Student getAllStudent(@RequestParam int id) {
        return studentServices.getStudentByID(id);
    }

    @RequestMapping(value = "getliststudent", method = RequestMethod.GET)
    public List<Student> getListStudent(@RequestParam int idStart, int idEnd) {
        return studentServices.getListStudentByID(idStart, idEnd);
    }
}
