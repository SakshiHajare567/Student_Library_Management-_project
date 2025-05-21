package com.example.Student_Library_Management_Project.Repository;

import com.example.Student_Library_Management_Project.Models.Transactions;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions,Integer> {
     @Query (value = "select * from transactions  where book_id=:bookId AND card_id=:cardId AND is_issue_operation = true" , nativeQuery = true)
    List<Transactions> getTransactionForBookANDCard(int bookId , int cardId);


}
