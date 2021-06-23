package com.PatternProject.University.service;


import com.PatternProject.University.entity.Student;
import java.util.List;

public interface StudentService {

    void removeStudent(int id);

    List<Student> getAllStudents();

    Student getStudentById(int id);

    Student getStudentByName(String name);

    Student getStudentBySurname(String surname);
}
