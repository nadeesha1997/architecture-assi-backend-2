package com.example.architectureassibackend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "second_name", nullable = false)
    private String lastName;
    @Column(name = "age" ,nullable = false)
    private int age;
    @Column(name = "grade", nullable = false)
    private int grade;
}
