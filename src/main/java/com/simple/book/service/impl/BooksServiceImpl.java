package com.simple.book.service.impl;

import com.simple.book.dto.BooksAddDto;
import com.simple.book.dto.BooksResponseDto;
import com.simple.book.exception.BadRequestException;
import com.simple.book.exception.NotFoundException;
import com.simple.book.model.entity.Books;
import com.simple.book.repository.BooksRepository;
import com.simple.book.repository.BukuRepository;
import com.simple.book.service.BooksService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BooksServiceImpl implements BooksService {

    private final BooksRepository booksRepository;

    private final BukuRepository bukuRepository;


    @Override
    public String postBook(BooksAddDto booksAddDto) {
        if (booksAddDto.getTitle() == null || booksAddDto.getAuthor() == null ||
                booksAddDto.getIsbn() == null || booksAddDto.getPublishedDate() == null) {
            throw new BadRequestException("All fields are required to add a book.");
        }
        Books books = BooksAddDtoToEntity(booksAddDto);
        booksRepository.save(books);
        return "Book added successfully with ID: " + books.getId();
    }

    @Override
    public List<BooksResponseDto> getAllBooks() {
        List<Books> booksList = booksRepository.findAll();
        return booksList.stream()
                .map(this::booksEntityToDto)
                .toList();
    }

    @Override
    public BooksResponseDto getBookById(Long id) {
        Books books = bukuRepository.findById(id);
        return booksEntityToDto(books);
    }

    @Override
    public String updateBook(Long id, BooksAddDto booksAddDto) {
        if (booksAddDto.getTitle() == null || booksAddDto.getAuthor() == null ||
                booksAddDto.getIsbn() == null || booksAddDto.getPublishedDate() == null) {
            throw new BadRequestException("All fields are required to update a book.");
        }
        Books existingBook = booksRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found with ID: " + id));
        existingBook.setTitle(booksAddDto.getTitle());
        existingBook.setAuthor(booksAddDto.getAuthor());
        existingBook.setIsbn(booksAddDto.getIsbn());
        existingBook.setPublishedDate(booksAddDto.getPublishedDate());
        booksRepository.save(existingBook);
        return "Book updated successfully with ID: " + existingBook.getId();
    }

    @Override
    public String patchBook(Long id, BooksResponseDto booksResponseDto) {
        Books existingBook = booksRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found with ID: " + id));

        if (booksResponseDto.getTitle() != null) {
            existingBook.setTitle(booksResponseDto.getTitle());
        }
        if (booksResponseDto.getAuthor() != null) {
            existingBook.setAuthor(booksResponseDto.getAuthor());
        }
        if (booksResponseDto.getIsbn() != null) {
            existingBook.setIsbn(booksResponseDto.getIsbn());
        }
        if (booksResponseDto.getPublishedDate() != null) {
            existingBook.setPublishedDate(booksResponseDto.getPublishedDate());
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

    @Override
    public List<Books> getBuku() {
        return bukuRepository.findAll();
    }

    @Override
    public int countBooks() {
        return (int) booksRepository.count();
    }


    private BooksResponseDto booksEntityToDto(Books books) {
        return BooksResponseDto.builder()
                .id(books.getId())
                .title(books.getTitle())
                .author(books.getAuthor())
                .isbn(books.getIsbn())
                .publishedDate(books.getPublishedDate())
                .build();
    }

    private Books BooksAddDtoToEntity(BooksAddDto books) {
        return Books.builder()
                .title(books.getTitle())
                .author(books.getAuthor())
                .isbn(books.getIsbn())
                .publishedDate(books.getPublishedDate())
                .build();
    }
}
