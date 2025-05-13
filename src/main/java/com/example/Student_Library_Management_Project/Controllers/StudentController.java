package com.example.Student_Library_Management_Project.Controllers;

import com.example.Student_Library_Management_Project.Models.Student;
import com.example.Student_Library_Management_Project.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
}
