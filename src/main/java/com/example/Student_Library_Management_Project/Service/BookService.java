package com.example.Student_Library_Management_Project.Service;

import com.example.Student_Library_Management_Project.DTOs.BookRequestDto;
import com.example.Student_Library_Management_Project.Models.Author;
import com.example.Student_Library_Management_Project.Models.Book;
import com.example.Student_Library_Management_Project.Repository.AuthorRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository ;
    /*public String addBook(@NotNull Book book){
        //I want to get the author entity
         int authorId = book.getAuthor().getId();

         public String addBook(@NotNull Book book){
        //I want to get the author entity
         int authorId = book.getAuthor().getId();

         Author author = authorRepository.findById(authorId).get();

         book.setAuthor(author);

         List<Book> currentBooksWritten = author.getBooksWritten();

         currentBooksWritten.add(book);

         author.setBooksWritten(currentBooksWritten);

         authorRepository.save(author);
         return "Book added succesfully";




    }



    }*/
    public String addBook( BookRequestDto bookRequestDto){
        //I want to get the author entity
        int authorId = bookRequestDto.getAuthorId();

        Author author = authorRepository.findById(authorId).get();

        Book book = new Book();
        book.setGenre(bookRequestDto.getGenre());
        book.setIssued(false);
        book.setName(bookRequestDto.getName());
        book.setPages(bookRequestDto.getPages());

        book.setAuthor(author);

        List<Book> currentBooksWritten = author.getBooksWritten();

        currentBooksWritten.add(book);

        author.setBooksWritten(currentBooksWritten);

        authorRepository.save(author);
        return "Book added succesfully";




    }
}
