package com.example.architectureassibackend.service.impl;

import com.example.architectureassibackend.exception.ResourceNotFoundException;
import com.example.architectureassibackend.model.Student;
import com.example.architectureassibackend.repository.StudentRepository;
import com.example.architectureassibackend.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student","Id",id));
    }

    @Override
    public Student updateStudent(Student student, long id) {
        Student existingStudent=studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student","Id",id));
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        studentRepository.save(existingStudent);
        return existingStudent;
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student","Id",id));
        studentRepository.deleteById(id);
    }
}
