package com.PatternProject.University.service;

import com.PatternProject.University.dao.StudentDAO;
import com.PatternProject.University.dao.StudentDAOImpl;
import com.PatternProject.University.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public void removeStudent(int id) {
        studentDAO.removeStudent(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public Student getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }

    @Override
    public Student getStudentByName(String name) {
        return studentDAO.getStudentByName(name);
    }

    @Override
    public Student getStudentBySurname(String surname) {
        return studentDAO.getStudentBySurname(surname);
    }
}
