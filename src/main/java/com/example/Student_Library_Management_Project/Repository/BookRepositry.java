package com.example.Student_Library_Management_Project.Repository;
import com.example.Student_Library_Management_Project.Models.Book;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepositry extends JpaRepository<Book , Integer> {
}
