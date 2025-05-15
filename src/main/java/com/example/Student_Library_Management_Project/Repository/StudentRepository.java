package com.example.Student_Library_Management_Project.Repository;

import com.example.Student_Library_Management_Project.Models.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student ,Integer> {
    
}
