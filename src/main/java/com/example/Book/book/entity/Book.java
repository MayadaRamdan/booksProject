package com.example.Book.book.entity;

import com.example.Book.author.entity.Author;
import com.example.Book.book.enums.BookType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private BookType type;

    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;
}
