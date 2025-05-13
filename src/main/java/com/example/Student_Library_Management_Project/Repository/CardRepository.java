package com.example.Student_Library_Management_Project.Repository;
import com.example.Student_Library_Management_Project.Models.Card;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {
}
