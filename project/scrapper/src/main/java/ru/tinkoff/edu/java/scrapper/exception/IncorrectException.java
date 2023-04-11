package ru.tinkoff.edu.java.scrapper.exception;

public class IncorrectException extends IllegalArgumentException {
    public IncorrectException(String message) {
        super(message);
    }
}