package ru.tinkoff.edu.java.scrapper.DTO;

import java.util.List;

public record APIErrorResponse(
        String description,
        String code,
        String exceptionName,
        String exceptionMessage,
        List<String> stacktrace) {
}