package com.example.Student_Library_Management_Project.Repository;

import com.example.Student_Library_Management_Project.Models.Student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository <Student ,Integer> {

    Student findByEmail(String email);

    //select *from where country=India;
    List<Student>findByCountry(String Country);
    
}
