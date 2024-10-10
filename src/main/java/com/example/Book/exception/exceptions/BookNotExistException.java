package com.example.Book.exception.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookNotExistException extends RuntimeException {

    private String meg;

}
