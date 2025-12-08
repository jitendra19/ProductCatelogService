package org.example.productcatelogservice1.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(Exception exp) {
        return new ResponseEntity<String>(exp.getMessage(), HttpStatus.BAD_REQUEST); // 400
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(Exception exp) {
        exp.printStackTrace();
//        System.out.println("NullPointerException- " + exp.getStackTrace());
        return new ResponseEntity<>(exp.getMessage(), HttpStatus.NOT_FOUND); // 404
    }

}
