package com.example.aspect;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;
import java.util.stream.*;

@ControllerAdvice
//extends ResponseEntityExceptionHandler
public class HandleMethodArgumentNotValidAspect  {
//    @Override
//    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
//                                                               HttpHeaders headers,
//                                                               HttpStatus status,
//                                                               WebRequest request) {
//        System.out.println("Handling the custom exception");
//        List<String> errors = exception.getBindingResult().getFieldErrors()
//                .stream()
//                .map(x -> x.getDefaultMessage())
//                .collect(Collectors.toList());
//
//        Map<String, Object> responseBody = new LinkedHashMap<>();
//        responseBody.put("timestamp", new Date());
//        responseBody.put("status", status.value());
//        responseBody.put("errors", errors);
//        System.out.println(responseBody);
//        return new ResponseEntity<>(responseBody, headers, status);
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseBody
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        return new ResponseEntity<>("Product name cannot be blank", HttpStatus.BAD_REQUEST);
    }
}
