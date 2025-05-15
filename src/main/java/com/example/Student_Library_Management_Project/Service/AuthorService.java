package com.example.Student_Library_Management_Project.Service;

import com.example.Student_Library_Management_Project.Models.Author;
import com.example.Student_Library_Management_Project.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public String createAuthor(Author author) {
        authorRepository.save(author);
        return "Author added successfully";
    }
}


