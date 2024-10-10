package com.example.Book.exception.exceptionhandler;

import com.example.Book.exception.exceptions.AuthorNotExistException;
import com.example.Book.exception.exceptions.BookNotExistException;
import com.example.Book.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(BookNotExistException.class)
    public ResponseEntity<ApiResponse> handelRunTime(BookNotExistException ex) {
        return ResponseEntity.ok(ApiResponse.of(HttpStatus.BAD_REQUEST, ex.getMeg()));
    }

    @ExceptionHandler(AuthorNotExistException.class)
    public ResponseEntity<ApiResponse> handelRunTime (AuthorNotExistException ex){
        return ResponseEntity.ok(ApiResponse.of(HttpStatus.BAD_REQUEST ,ex.getMeg()));
    }
}
