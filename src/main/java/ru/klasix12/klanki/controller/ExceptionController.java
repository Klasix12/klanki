package ru.klasix12.klanki.controller;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.klasix12.klanki.dto.ExceptionDTO;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus
    @ResponseBody
    public ExceptionDTO handleNoSuchElementException(final NoSuchElementException e) {
        return ExceptionDTO.builder()
                .message(e.getMessage())
                .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionDTO handleConstraintViolationException(final ConstraintViolationException e) {
        StringBuilder sb = new StringBuilder();
        for (ConstraintViolation<?> cv : e.getConstraintViolations()) {
            sb.append(cv.getPropertyPath()).append(" ").append(cv.getMessage()).append(";");
        }
        return ExceptionDTO.builder().message(sb.toString()).build();
    }
}