package com.example.Book.book.service;

import com.example.Book.book.dto.ListingBookDto;
import com.example.Book.book.entity.Book;
import com.example.Book.book.mapper.BookMapper;
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
    private final BookMapper bookMapper;

    public List<ListingBookDto> execute() {

        log.info("FindAllBooksUseCase -> execute");
        List<Book> books = bookRepo.findAll();
        List<ListingBookDto> listingBookDtos =bookMapper.toListOfListingBookDto(books);

        return listingBookDtos;
    }

}
