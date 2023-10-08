package dev.nivesh.productservice.exceptions;

import dev.nivesh.productservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ControllerAdvices {

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionDto> handledNotFoundException(
            NotFoundException notFoundException
    ){
        return new ResponseEntity(
                new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
                HttpStatus.NOT_FOUND
        );
//        System.out.println("Not found exception happened");
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    private ResponseEntity<ExceptionDto> handleArrayIndexOutOfBound(
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException
    ){
        return new ResponseEntity(
                new ExceptionDto(HttpStatus.NOT_FOUND, arrayIndexOutOfBoundsException.getMessage()),
                HttpStatus.NOT_FOUND
        );
//        System.out.println("Not found exception happened");
    }
}
