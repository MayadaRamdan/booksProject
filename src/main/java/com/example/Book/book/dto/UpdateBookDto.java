package com.example.Book.book.dto;

import com.example.Book.book.enums.BookType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class UpdateBookDto implements Serializable {

    private Long id;
    private String name;
    private BookType type;
    private Long authorId;

}
