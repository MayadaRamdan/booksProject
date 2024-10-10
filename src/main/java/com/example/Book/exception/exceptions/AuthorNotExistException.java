package com.example.Book.exception.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthorNotExistException extends RuntimeException {

    private String meg;
}
