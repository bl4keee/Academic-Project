package com.PatternProject.University.dao;

import com.PatternProject.University.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private List<Student> students;

    public StudentDAOImpl() {
        initStudents();
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public void removeStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    @Override
    public Student getStudentByName(String studentName) {
        return filterStudentsByAttribute("name", studentName);
    }

    @Override
    public Student getStudentBySurname(String studentSurname) {
        return filterStudentsByAttribute("surname", studentSurname);
    }

    @Override
    public Student getStudentById(int studentId) {
        return students.get(studentId);
    }

    private void initStudents() {
        students = new ArrayList<>();
        students.add(new Student(1, "Adam", "Kowalski"));
        students.add(new Student(2, "Jacek", "Lewandowski"));
        students.add(new Student(3, "Michał", "Mikulski"));
        students.add(new Student(4, "Dawid", "Dawidowicz"));
        students.add(new Student(5, "Wojciech", "Czwartek"));
    }

    private Student filterStudentsByAttribute(String attributeName, String attributeValue) {
        if (attributeName.equals("name")) {
            return students.stream().filter(student -> student.getName().equals(attributeValue)).findAny().orElse(null);
        } else {
            return students.stream().filter(student -> student.getSurname().equals(attributeValue)).findAny().orElse(null);
        }
    }
}
