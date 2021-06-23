package com.PatternProject.University.controller;

import com.PatternProject.University.entity.Student;
import com.PatternProject.University.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    /*
    For academic and simplicity purposes all the endpoints return normal entity.
    Ideally you would want to return a DTO instead - in terms of further development.
     */

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/list")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @DeleteMapping("/student/remove/{id}")
    public void removeStudent(@PathVariable int id) {
        studentService.removeStudent(id);
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/student/name/{name}")
    public Student getStudentByName(@PathVariable String name) {
        return studentService.getStudentByName(name);
    }

    @GetMapping("/student/surname/{surname}")
    public Student getStudentBySurname(@PathVariable String surname) {
        return studentService.getStudentBySurname(surname);
    }
}
