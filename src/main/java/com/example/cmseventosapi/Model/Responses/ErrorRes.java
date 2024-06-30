package com.example.cmseventosapi.Model.Responses;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorRes {
    HttpStatus status;
    String message;
}
