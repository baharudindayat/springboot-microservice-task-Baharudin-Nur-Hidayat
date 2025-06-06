package com.simple.book.dto;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeneralResponse <T>{
    private String message;
    private String status;
    private T data;
}
