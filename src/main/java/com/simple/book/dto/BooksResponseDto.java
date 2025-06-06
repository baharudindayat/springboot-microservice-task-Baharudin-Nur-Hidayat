package com.simple.book.dto;

import lombok.*;

import java.util.Date;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BooksResponseDto {

    private Long id;

    private String title;

    private String author;

    private String isbn;

    private Date publishedDate;
}
