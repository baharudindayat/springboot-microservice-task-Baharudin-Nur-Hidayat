package com.simple.book.exception;

public class NotFoundException extends RuntimeException{

        public NotFoundException(String message) {
            super(message);
        }
}
