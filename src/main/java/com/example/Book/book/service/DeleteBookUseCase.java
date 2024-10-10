package com.example.Book.book.service;

import com.example.Book.book.entity.Book;
import com.example.Book.book.repository.BookRepo;
import com.example.Book.exception.exceptions.BookNotExistException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class DeleteBookUseCase {

    private final BookRepo bookRepo;

    public void execute(long id) {
        log.info("DeleteBookUseCase -> execute");
        Book book = bookRepo.findById(id).orElseThrow(
                () -> new BookNotExistException("THERE IS NO BOOK WITH THIS ID"));
        bookRepo.delete(book);
    }
}
