package com.simple.book.service.impl;

import com.simple.book.dto.BooksDto;
import com.simple.book.exception.NotFoundException;
import com.simple.book.model.entity.Books;
import com.simple.book.repository.BooksRepository;
import com.simple.book.service.BooksService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BooksServiceImpl implements BooksService {

    private final BooksRepository booksRepository;


    @Override
    public String postBook(BooksDto booksDto) {
        Books books = booksDtoToEntity(booksDto);
        booksRepository.save(books);
        return "Book added successfully with ID: " + books.getId();
    }

    @Override
    public List<BooksDto> getAllBooks() {
        List<Books> booksList = booksRepository.findAll();
        return booksList.stream()
                .map(this::booksEntityToDto)
                .toList();
    }

    @Override
    public BooksDto getBookById(Long id) {
        Books books = booksRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found with ID: " + id));
        return booksEntityToDto(books);
    }

    @Override
    public String updateBook(Long id, BooksDto booksDto) {
        Books existingBook = booksRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found with ID: " + id));
        existingBook.setTitle(booksDto.getTitle());
        existingBook.setAuthor(booksDto.getAuthor());
        existingBook.setIsbn(booksDto.getIsbn());
        existingBook.setPublishedDate(booksDto.getPublishedDate());

        booksRepository.save(existingBook);
        return "Book updated successfully with ID: " + existingBook.getId();
    }

    @Override
    public String patchBook(Long id, BooksDto booksDto) {
        Books existingBook = booksRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found with ID: " + id));

        if (booksDto.getTitle() != null) {
            existingBook.setTitle(booksDto.getTitle());
        }
        if (booksDto.getAuthor() != null) {
            existingBook.setAuthor(booksDto.getAuthor());
        }
        if (booksDto.getIsbn() != null) {
            existingBook.setIsbn(booksDto.getIsbn());
        }
        if (booksDto.getPublishedDate() != null) {
            existingBook.setPublishedDate(booksDto.getPublishedDate());
        }

        booksRepository.save(existingBook);
        return "Book patched successfully with ID: " + existingBook.getId();
    }

    @Override
    public String deleteBook(Long id) {
        Books existingBook = booksRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found with ID: " + id));
        booksRepository.delete(existingBook);
        return "Book deleted successfully with ID: " + existingBook.getId();
    }

    private Books booksDtoToEntity(BooksDto booksDto) {
        return Books.builder()
                .id(booksDto.getId())
                .title(booksDto.getTitle())
                .author(booksDto.getAuthor())
                .isbn(booksDto.getIsbn())
                .publishedDate(booksDto.getPublishedDate())
                .build();
    }
    private BooksDto booksEntityToDto(Books books) {
        return BooksDto.builder()
                .id(books.getId())
                .title(books.getTitle())
                .author(books.getAuthor())
                .isbn(books.getIsbn())
                .publishedDate(books.getPublishedDate())
                .build();
    }
}
