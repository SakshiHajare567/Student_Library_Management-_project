package com.example.Student_Library_Management_Project.Repository;

import com.example.Student_Library_Management_Project.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions,Integer> {
}
