package com.example.Book.book.service;

import com.example.Book.author.entity.Author;
import com.example.Book.author.repository.AuthorRepo;
import com.example.Book.book.dto.CreateBookDto;
import com.example.Book.book.entity.Book;
import com.example.Book.book.repository.BookRepo;
import com.example.Book.exception.exceptions.AuthorNotExistException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class AddBookUseCase {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;

    public void execute(CreateBookDto createBookDto) {
        log.info("AddBookUseCase -> execute");

        Author author = authorRepo.findById(createBookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotExistException(" THERE IS NO AUTHOR WITH THIS ID"));

        Book book = new Book();
        book.setName(createBookDto.getName());
        book.setType(createBookDto.getType());
        book.setAuthor(author);

        bookRepo.save(book);
    }
}
