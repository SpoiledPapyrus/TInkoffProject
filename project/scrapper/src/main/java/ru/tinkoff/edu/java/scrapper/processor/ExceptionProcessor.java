package ru.tinkoff.edu.java.scrapper.processor;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import ru.tinkoff.edu.java.scrapper.DTO.APIErrorResponse;
import ru.tinkoff.edu.java.scrapper.exception.IncorrectException;
import ru.tinkoff.edu.java.scrapper.exception.NotFoundException;

import java.util.Arrays;

@RestControllerAdvice
public class ExceptionProcessor {

    private APIErrorResponse HandleOutput(String message, Exception exception, HttpStatus httpStatus) {
        return new APIErrorResponse(
                message,
                String.valueOf(httpStatus.value()),
                exception.getClass().getName(),
                exception.getMessage(),
                Arrays.stream(exception.getStackTrace()).map(String::valueOf).toList()
        );
    }

    @ExceptionHandler({NotFoundException.class, NullPointerException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public APIErrorResponse handleResourceNotFoundException(RuntimeException Exception) {
        return HandleOutput("resource not found", Exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({IncorrectException.class, MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public APIErrorResponse handleIncorrectRequestParamsException(IncorrectException Exception) {
        return HandleOutput("This parameters is not correct", Exception, HttpStatus.BAD_REQUEST);
    }


}
