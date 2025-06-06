package com.simple.book.controller;

import com.simple.book.dto.BooksAddDto;
import com.simple.book.dto.BooksResponseDto;
import com.simple.book.dto.GeneralResponse;
import com.simple.book.service.BooksService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@AllArgsConstructor
@RequestMapping("/api/books")
public class BooksController {

    private final BooksService booksService;

    @PostMapping(
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<GeneralResponse<?>> addBook(
            @RequestBody BooksAddDto booksAddDto) {
        return ResponseEntity.ok()
                .body(GeneralResponse.builder()
                        .message("Book added successfully")
                        .status("success")
                        .data(booksService.postBook(booksAddDto))
                        .build());
    }

    @GetMapping(
            produces = "application/json"
    )
    public ResponseEntity<GeneralResponse<?>> getAllBooks() {
        return ResponseEntity.ok()
                .body(GeneralResponse.builder()
                        .message("Books retrieved successfully")
                        .status("success")
                        .data(booksService.getAllBooks())
                        .build());
    }

    @GetMapping(
            value = "/{id}",
            produces = "application/json"
    )
    public ResponseEntity<GeneralResponse<?>> getBookById(
            @PathVariable("id") Long id
    ) {
        return ResponseEntity.ok()
                .body(GeneralResponse.builder()
                        .message("Book retrieved successfully")
                        .status("success")
                        .data(booksService.getBookById(id))
                        .build());
    }

    @PutMapping(
            value = "/{id}",
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<GeneralResponse<?>> updateBook(
            @PathVariable("id") Long id,
            @RequestBody BooksAddDto booksAddDto
    ) {
        return ResponseEntity.ok()
                .body(GeneralResponse.builder()
                        .message("Book updated successfully")
                        .status("success")
                        .data(booksService.updateBook(id, booksAddDto))
                        .build());
    }

    @PatchMapping(
            value = "/{id}",
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<GeneralResponse<?>> patchBook(
            @PathVariable("id") Long id,
            @RequestBody BooksResponseDto booksAddDto
    ) {
        return ResponseEntity.ok()
                .body(GeneralResponse.builder()
                        .message("Book patched successfully")
                        .status("success")
                        .data(booksService.patchBook(id, booksAddDto))
                        .build());
    }

    @DeleteMapping(
            value = "/{id}",
            produces = "application/json"
    )
    public ResponseEntity<GeneralResponse<?>> deleteBook(
            @PathVariable("id") Long id
    ) {
        return ResponseEntity.ok()
                .body(GeneralResponse.builder()
                        .message("Book deleted successfully")
                        .status("success")
                        .data(booksService.deleteBook(id))
                        .build());
    }
}
