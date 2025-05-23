package com.example.Student_Library_Management_Project.DTOs;

import java.util.List;
//book my show models
public class AuthorResponseDtos {
    private  String name;
    private int age ;
    private double rating ;
    private String country ;
    List<BookResposeDtos> bookWritten;

    public AuthorResponseDtos() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<BookResposeDtos> getBookWritten() {
        return bookWritten;
    }

    public void setBookWritten(List<BookResposeDtos> bookWritten) {
        this.bookWritten = bookWritten;
    }
}
