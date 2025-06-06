package com.simple.book.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BooksAddDto {

    @NotEmpty(message = "Title cannot be null")
    private String title;

    @NotEmpty(message = "Author cannot be null")
    private String author;

    @NotEmpty(message = "ISBN cannot be null")
    private String isbn;

    @NotEmpty(message = "Published date cannot be null")
    private Date publishedDate;
}