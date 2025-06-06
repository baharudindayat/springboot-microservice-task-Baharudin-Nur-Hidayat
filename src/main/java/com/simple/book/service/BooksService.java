package com.simple.book.service;

import com.simple.book.dto.BooksDto;

import java.util.List;

public interface BooksService {

    String postBook(BooksDto booksDto);

    List<BooksDto> getAllBooks();

    BooksDto getBookById(Long id);

    String updateBook(Long id, BooksDto booksDto);

    String patchBook(Long id, BooksDto booksDto);

    String deleteBook(Long id);
}
