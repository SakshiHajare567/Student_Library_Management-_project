package com.example.Student_Library_Management_Project.Service;

import com.example.Student_Library_Management_Project.DTOs.StudentUpdateMobRequestDto;
import com.example.Student_Library_Management_Project.Enums.CardStatus;
import com.example.Student_Library_Management_Project.Models.Card;
import com.example.Student_Library_Management_Project.Models.Student;
import com.example.Student_Library_Management_Project.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String createStudent(Student student) {
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudentVariableName(student);

        // Set card for student
        student.setCard(card);

        studentRepository.save(student); // Will also save the card due to CascadeType.ALL

        return "Student and card added successfully";
    }

    //Get function
    public String findNameByEmail(String email){
        Student student = studentRepository.findByEmail(email);
        return  student.getName();

    }

    //update mobno

   /* public String updateMob(Student newStudent) {
        Student originalStudent = studentRepository.findById(newStudent.getId()).get();


        originalStudent.setMobNo(newStudent.getMobNo());
        studentRepository.save(originalStudent);

        return "Student UpdatMobNo succesfully" ;

    }*/

    public String updateMob(StudentUpdateMobRequestDto studentReq) {
        Student originalStudent = studentRepository.findById(studentReq.getId()).get();


        originalStudent.setMobNo(studentReq.getMobNo());
        studentRepository.save(originalStudent);

        return "Student UpdatMobNo succesfully" ;

    }



}
