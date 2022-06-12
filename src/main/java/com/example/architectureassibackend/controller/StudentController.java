package com.example.architectureassibackend.controller;

import com.example.architectureassibackend.model.Student;
import com.example.architectureassibackend.repository.StudentRepository;
import com.example.architectureassibackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class StudentController {
    public StudentService studentService;
    public StudentController(StudentService studentService){
        super();
        this.studentService=studentService;
    }
    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        System.out.println("f"+student.getFirstName()+"l"+student.getLastName());
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") long id){
        return new ResponseEntity<Student>(studentService.getStudentById(id),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") long id){
        return new ResponseEntity<Student>(studentService.updateStudent(student,id),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
    }
}
