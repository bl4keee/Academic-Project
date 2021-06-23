package com.PatternProject.University.controller;

import com.PatternProject.University.entity.Student;
import com.PatternProject.University.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    StudentService studentService;

    private List<Student> students;

    private final static int STUDENT_ID = 1;
    private final static int STUDENTS_LIST_SIZE = 5;
    private final static String NAME_ATTRIBUTE = "name";
    private final static String SURNAME_ATTRIBUTE = "surname";

    @BeforeEach
    @DisplayName("Initialize data")
    void init() {
        students = createListOfAllStudents();
    }

    @Test
    @DisplayName("Should return list of all students")
    void shouldGetAllStudents() {
        studentService.getAllStudents();

        when(studentService.getAllStudents()).thenReturn(students);
        verify(studentService, atLeastOnce()).getAllStudents();

        assertNotNull(students);
        assertThat(students, hasSize(STUDENTS_LIST_SIZE));
        assertEquals(studentService.getAllStudents(), students);
    }

    @Test
    @DisplayName("Should remove student of given id")
    void shouldRemoveStudent() {
        Student student = studentService.getStudentById(STUDENT_ID);
        studentService.removeStudent(STUDENT_ID);

        verify(studentService, atMostOnce()).removeStudent(STUDENT_ID);

        assertNotNull(students);
        assertThat(studentService.getAllStudents(), not(hasItem(student)));
        assertThat(studentService.getAllStudents(), not(hasSize(STUDENTS_LIST_SIZE)));
    }

    @Test
    @DisplayName("Should return student of given id")
    void shouldGetStudentById() {
        Student student = students.get(STUDENT_ID);
        studentService.getStudentById(STUDENT_ID);

        when(studentService.getStudentById(STUDENT_ID)).thenReturn(students.get(STUDENT_ID));
        verify(studentService, atMostOnce()).getStudentById(STUDENT_ID);

        assertNotNull(students.get(STUDENT_ID));
        assertEquals(studentService.getStudentById(STUDENT_ID).getId(), student.getId());
    }

    @Test
    @DisplayName("Should return student of given name")
    void shouldGetStudentByName() {
        Student student = filterStudentsByAttribute(NAME_ATTRIBUTE, "Adam");
        studentService.getStudentByName("Adam");

        when(studentService.getStudentByName("Adam"))
                .thenReturn(filterStudentsByAttribute(NAME_ATTRIBUTE, "Adam"));
        verify(studentService, atMostOnce()).getStudentByName("Adam");

        assertNotNull(filterStudentsByAttribute(NAME_ATTRIBUTE, "Adam"));
        assertEquals(studentService.getStudentByName("Adam").getName(), student.getName());
    }

    @Test
    @DisplayName("Should return student of given surname")
    void shouldGetStudentBySurname() {
        Student student = filterStudentsByAttribute(SURNAME_ATTRIBUTE, "Kowalski");
        studentService.getStudentBySurname("Kowalski");

        when(studentService.getStudentBySurname("Kowalski"))
                .thenReturn(filterStudentsByAttribute(SURNAME_ATTRIBUTE, "Kowalski"));
        verify(studentService, atMostOnce()).getStudentBySurname("Kowalski");

        assertNotNull(filterStudentsByAttribute(SURNAME_ATTRIBUTE, "Kowalski"));
        assertEquals(studentService.getStudentBySurname("Kowalski").getSurname(), student.getSurname());
    }

    private Student filterStudentsByAttribute(String attributeName, String attributeValue) {
        if (attributeName.equals(NAME_ATTRIBUTE)) {
            return students.stream()
                    .filter(student -> student.getName().equals(attributeValue)).findAny().orElse(null);
        } else {
            return students.stream()
                    .filter(student -> student.getSurname().equals(attributeValue)).findAny().orElse(null);
        }
    }

    private List<Student> createListOfAllStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Adam", "Kowalski"));
        students.add(new Student(2, "Jacek", "Lewandowski"));
        students.add(new Student(3, "Michał", "Mikulski"));
        students.add(new Student(4, "Dawid", "Dawidowicz"));
        students.add(new Student(5, "Wojciech", "Czwartek"));
        return students;
    }
}
