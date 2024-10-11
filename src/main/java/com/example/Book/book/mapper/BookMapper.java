package com.example.Book.book.mapper;

import com.example.Book.book.dto.CreateBookDto;
import com.example.Book.book.dto.ListingBookDto;
import com.example.Book.book.dto.UpdateBookDto;
import com.example.Book.book.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(source = "authorId" ,target = "author.id")
    Book toEntity(CreateBookDto createBookDto);


    @Mapping(source = "author.authorName" , target = "authorName")
    List<ListingBookDto> toListOfListingBookDto (List<Book> books);



    @Mapping(source = "authorId" ,target = "author.id")
    Book toEntity(UpdateBookDto updateBookDto);

    @Mapping(source = "author.id" , target = "authorId")
    UpdateBookDto toUpdateBookDto (Book book);


}
