package com.example.Book.book.service;

import com.example.Book.book.dto.ListingBookDto;
import com.example.Book.book.entity.Book;
import com.example.Book.book.repository.BookRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class FindAllBooksUseCase {

    private final BookRepo bookRepo;

    public List<ListingBookDto> execute() {
        log.info("FindAllBooksUseCase -> execute");
        List<Book> books = bookRepo.findAll();

        return books.stream().map(this::map).collect(Collectors.toList());
    }

    private ListingBookDto map(Book book) {
        ListingBookDto readBookDto = new ListingBookDto();
        readBookDto.setName(book.getName());
        readBookDto.setType(book.getType());
        readBookDto.setAuthorName(book.getAuthor().getAuthorName());
        return readBookDto;
    }

}
