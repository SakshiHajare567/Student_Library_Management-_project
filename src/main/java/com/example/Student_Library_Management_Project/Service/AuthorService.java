package com.example.Student_Library_Management_Project.Service;

import com.example.Student_Library_Management_Project.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_Project.DTOs.AuthorResponseDtos;
import com.example.Student_Library_Management_Project.DTOs.BookResposeDtos;
import com.example.Student_Library_Management_Project.Models.Author;
import com.example.Student_Library_Management_Project.Models.Book;
import com.example.Student_Library_Management_Project.Repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    //Book my show model
    public AuthorResponseDtos getAuthor(Integer authorId){
     Author author = authorRepository.findById(authorId).get();
     //list<Book> convertr to list<BookResposeDto>
        AuthorResponseDtos authorResponseDtos = new AuthorResponseDtos();
        List<Book> bookList = author.getBooksWritten();
        List<BookResposeDtos> bookWrittenDtos = new ArrayList<>();

        for (Book b : bookList) {
            BookResposeDtos bookResposeDtos = new BookResposeDtos();
            bookResposeDtos.setGenre(b.getGenre());
            bookResposeDtos.setPage(b.getPages());
            bookResposeDtos.setName(b.getName());

            bookWrittenDtos.add(bookResposeDtos);
        }

        // Set attributes of AuthorResponseDtos after loop
        authorResponseDtos.setBookWritten(bookWrittenDtos);
        authorResponseDtos.setAge(author.getAge());
        authorResponseDtos.setCountry(author.getCountry());
        authorResponseDtos.setName(author.getName());
        authorResponseDtos.setRating(author.getRating());

        return authorResponseDtos;

        }
}





