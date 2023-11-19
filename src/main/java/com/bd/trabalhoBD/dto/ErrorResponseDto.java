package com.bd.trabalhoBD.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public record ErrorResponseDto(String msg, Integer code, HttpStatus status, LocalDateTime timeStamp) {

}
