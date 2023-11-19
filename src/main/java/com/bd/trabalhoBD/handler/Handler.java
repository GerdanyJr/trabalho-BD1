package com.bd.trabalhoBD.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bd.trabalhoBD.dto.ErrorResponseDto;
import com.bd.trabalhoBD.handler.exception.ConflictException;
import com.bd.trabalhoBD.handler.exception.NotFoundException;

@RestControllerAdvice
public class Handler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> notFoundExceptionHandler(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponseDto(e.getMessage(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND,
                        LocalDateTime.now()));
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponseDto> conflictExceptionHandler(ConflictException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponseDto(e.getMessage(), HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT,
                        LocalDateTime.now()));
    }
}
