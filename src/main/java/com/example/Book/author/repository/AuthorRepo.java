package com.example.Book.author.repository;

import com.example.Book.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
}
