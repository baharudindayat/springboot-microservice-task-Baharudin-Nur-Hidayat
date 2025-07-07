package com.simple.book.service;

import com.simple.book.dto.BooksAddDto;
import com.simple.book.dto.BooksResponseDto;
import com.simple.book.model.entity.Books;

import java.util.List;

public interface BooksService {

    String postBook(BooksAddDto booksAddDto);

    List<BooksResponseDto> getAllBooks();

    BooksResponseDto getBookById(Long id);

    String updateBook(Long id, BooksAddDto booksAddDto);

    String patchBook(Long id, BooksResponseDto booksResponseDto);

    String deleteBook(Long id);

    List<Books> getBuku();

    int countBooks();

}
