package com.lotfi.studentms.controller;

import com.lotfi.studentms.exceptions.ResourceNotFoundException;
import com.lotfi.studentms.exceptions.StudentAlreadyExist;
import com.lotfi.studentms.payload.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = StudentAlreadyExist.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody
    ErrorMessage handleCustomerAlreadyExistsException(StudentAlreadyExist ex, WebRequest web)
    {
        return new ErrorMessage(
                new Date(),
                HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                web.getDescription(false));
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public  ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                new Date(),
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getDescription(false));

        return message;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public  ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                new Date(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                request.getDescription(false));

        return message;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessage badException(HttpMessageNotReadableException ex,WebRequest request){
        ErrorMessage message = new ErrorMessage(
                new Date(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getDescription(false));

        return message;
    }

}
