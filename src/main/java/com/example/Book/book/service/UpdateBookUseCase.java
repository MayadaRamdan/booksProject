package com.example.Book.book.service;

import com.example.Book.author.entity.Author;
import com.example.Book.author.repository.AuthorRepo;
import com.example.Book.book.dto.UpdateBookDto;
import com.example.Book.book.entity.Book;
import com.example.Book.book.repository.BookRepo;
import com.example.Book.exception.exceptions.AuthorNotExistException;
import com.example.Book.exception.exceptions.BookNotExistException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class UpdateBookUseCase {

    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;

    public void execute(UpdateBookDto updateBookDto) {
        log.info("UpdateBookUseCase -> execute");

        Book book = bookRepo.findById(updateBookDto.getId())
                .orElseThrow(() -> new BookNotExistException("THERE IS NO BOOK WITH THIS ID TO UPDATE IT"));

        Author author = authorRepo.findById(updateBookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotExistException("THERE IS NO Author WITH THIS ID"));

        book.setId(updateBookDto.getId());
        book.setName(updateBookDto.getName());
        book.setType(updateBookDto.getType());
        book.setAuthor(author);

        bookRepo.save(book);
    }
}
