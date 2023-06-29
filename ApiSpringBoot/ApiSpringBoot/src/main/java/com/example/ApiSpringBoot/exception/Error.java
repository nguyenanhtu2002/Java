package com.example.ApiSpringBoot.exception;


import org.springframework.http.HttpStatus;
import lombok.Data;
@Data
public class Error {
    private int code;
    private String message;
}
