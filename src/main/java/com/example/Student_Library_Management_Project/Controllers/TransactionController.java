package com.example.Student_Library_Management_Project.Controllers;

import com.example.Student_Library_Management_Project.DTOs.IssueBookRequestDto;
import com.example.Student_Library_Management_Project.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/issueBook")
    public String issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto){
       try {
           return transactionService.issueBook(issueBookRequestDto);
       }
       catch(Exception e){
           return e.getMessage();
        }
    }

    //native query
    @GetMapping("/getTnxInfo")
    public String getTransactionEntry (@RequestParam ("bookId") Integer bookId , @RequestParam("cardId") Integer cardId){
        return transactionService.getTransactions (bookId ,cardId);
    }
}
