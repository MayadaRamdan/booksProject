package com.example.Book.book.service;

import com.example.Book.author.entity.Author;
import com.example.Book.author.repository.AuthorRepo;
import com.example.Book.book.dto.UpdateBookDto;
import com.example.Book.book.entity.Book;
import com.example.Book.book.mapper.BookMapper;
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
    private final BookMapper bookMapper;

    public void execute(UpdateBookDto updateBookDto) {

        log.info("UpdateBookUseCase -> execute");
        bookMapper.toEntity(updateBookDto);
        bookRepo.save(bookMapper.toEntity(updateBookDto));
    }


}
