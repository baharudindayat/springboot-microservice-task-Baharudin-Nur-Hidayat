package com.simple.book.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BooksAddDto {

    @NotNull(message = "Title cannot be null")
    private String title;

    @NotNull(message = "Author cannot be null")
    private String author;

    @NotNull(message = "ISBN cannot be null")
    private String isbn;

    @NotNull(message = "Published date cannot be null")
    private String publishedDate;
}