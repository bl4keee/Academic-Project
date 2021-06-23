package com.PatternProject.University.dao;

import com.PatternProject.University.entity.Student;

import java.util.List;

public interface StudentDAO {

    Student getStudentById(int id);

    void removeStudent(int id);

    List<Student> getAllStudents();

    Student getStudentByName(String name);

    Student getStudentBySurname(String surname);
}
