package com.example.Student_Library_Management_Project.Controllers;
import com.example.Student_Library_Management_Project.DTOs.BookRequestDto;
import com.example.Student_Library_Management_Project.Models.Book;


import com.example.Student_Library_Management_Project.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/book")
public class BookController {
    @Autowired
    BookService bookService;

    /*@PostMapping("/add")
    public String addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }*/

    @PostMapping("/add")
    public String addBook(@RequestBody BookRequestDto  bookRequestDto){
        return bookService.addBook(bookRequestDto);


    }
}
