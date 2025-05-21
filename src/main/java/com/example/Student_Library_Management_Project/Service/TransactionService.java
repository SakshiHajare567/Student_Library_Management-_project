package com.example.Student_Library_Management_Project.Service;

import com.example.Student_Library_Management_Project.DTOs.IssueBookRequestDto;
import com.example.Student_Library_Management_Project.Enums.CardStatus;
import com.example.Student_Library_Management_Project.Enums.TransactionStatus;
import com.example.Student_Library_Management_Project.Models.Book;
import com.example.Student_Library_Management_Project.Models.Card;
import com.example.Student_Library_Management_Project.Models.Transactions;
import com.example.Student_Library_Management_Project.Repository.BookRepositry;
import com.example.Student_Library_Management_Project.Repository.CardRepository;
import com.example.Student_Library_Management_Project.Repository.TransactionRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    BookRepositry bookRepositry;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public String issueBook(@NotNull IssueBookRequestDto issueBookRequestDto) throws Exception {
        int bookId = issueBookRequestDto.getBookId();
        int cardId = issueBookRequestDto.getCardId();

        Book book = bookRepositry.findById(bookId).get();
        Card card = cardRepository.findById(cardId).get();

        Transactions transactions = new Transactions();
        transactions.setBook(book);
        transactions.setCard(card);
        transactions.setIssueOperation(true);
        transactions.setTransactionId(UUID.randomUUID().toString());
        transactions.setTransactionStatus(TransactionStatus.PENDING);

        if (book.isIssued()) {
            transactions.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transactions);
            throw new Exception("Book is not available");
        }

        if (card.getCardStatus() != CardStatus.ACTIVATED) {
            transactions.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transactions);
            throw new Exception("Card is not valid");
        }

        // Update book and card info
        transactions.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);

        // Book <-> Transaction mapping
        List<Transactions> bookTransactionList = book.getListOfTransaction();
        bookTransactionList.add(transactions);
        book.setListOfTransactions(bookTransactionList);

        // Card <-> Book mapping
        List<Book> issuedBooks = card.getBookIssued();
        issuedBooks.add(book);
        card.setBookIssued(issuedBooks);

        // Card <-> Transaction mapping
        List<Transactions> cardTransactionList = card.getListOfTransaction();
        cardTransactionList.add(transactions);
        card.setListOfTransaction(cardTransactionList);

        // Save all entities
        bookRepositry.save(book);
        cardRepository.save(card);
        transactionRepository.save(transactions);

        return "Book issued successfully";
    }

    //native Query
    public  String getTransactions (int bookId ,int cardId){
        List<Transactions>transactionsList=transactionRepository.getTransactionForBookANDCard(bookId ,cardId);

      String transactionId=   transactionsList.get(0).getTransactionId();
         return  transactionId;
    }
}
