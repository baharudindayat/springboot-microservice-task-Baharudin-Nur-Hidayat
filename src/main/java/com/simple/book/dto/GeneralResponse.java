package com.simple.book.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class GeneralResponse <T>{
    private String message;
    private String status;
    private T data;
}
