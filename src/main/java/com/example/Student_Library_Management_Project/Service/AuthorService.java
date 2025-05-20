package com.example.Student_Library_Management_Project.Service;

import com.example.Student_Library_Management_Project.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_Project.Models.Author;
import com.example.Student_Library_Management_Project.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public String createAuthor(AuthorEntryDto authorEntryDto) {
        //convert to authorEntryDto to Author
        Author author = new Author();
        author.setName(authorEntryDto.getName());
        author.setAge(authorEntryDto.getAge());
        author.setCountry(authorEntryDto.getCountry());
        author.setRating(authorEntryDto.getRating());

        authorRepository.save(author);
        return "Author added successfully";
    }
}


