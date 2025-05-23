package com.example.Student_Library_Management_Project.DTOs;

import com.example.Student_Library_Management_Project.Enums.Genre;

public class BookResposeDtos {
    private String name;
    private int page;
    //private double rating ;
    private Genre genre;


    public BookResposeDtos() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
