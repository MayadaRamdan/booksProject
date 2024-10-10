package com.example.Book.book.controller;


import com.example.Book.book.dto.CreateBookDto;
import com.example.Book.book.dto.UpdateBookDto;
import com.example.Book.book.service.AddBookUseCase;
import com.example.Book.book.service.DeleteBookUseCase;
import com.example.Book.book.service.FindAllBooksUseCase;
import com.example.Book.book.service.UpdateBookUseCase;
import com.example.Book.response.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {

    private final AddBookUseCase addBookUseCase;
    private final UpdateBookUseCase updateBookUseCase;
    private final DeleteBookUseCase deleteBookUseCase;
    private final FindAllBooksUseCase findAllBooksUseCase;

    @GetMapping
    public ResponseEntity<ApiResponse> getAllBook() {
        return ResponseEntity.ok(ApiResponse.ok(findAllBooksUseCase.execute()));
    }


    @PostMapping
    public ResponseEntity<ApiResponse> addBook(@RequestBody CreateBookDto createBookDto) {
        addBookUseCase.execute(createBookDto);
        return ResponseEntity.ok(ApiResponse.ok());
    }


    @PutMapping
    public ResponseEntity<ApiResponse> updateBook(@RequestBody UpdateBookDto updateBookDto){
        updateBookUseCase.execute(updateBookDto);
        return ResponseEntity.ok(ApiResponse.ok());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteBook(@PathVariable("id") long id) {
        deleteBookUseCase.execute(id);
        return ResponseEntity.ok(ApiResponse.ok());
    }






}
