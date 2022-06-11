package com.example.architectureassibackend.service;

import com.example.architectureassibackend.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Student getStudentById(long id);
    public Student updateStudent(Student student,long id);
    public void deleteStudent(long id);
}
