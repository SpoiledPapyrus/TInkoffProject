package ru.tinkoff.edu.java.bot.scrapper.API.ErrorException;

import ru.tinkoff.edu.java.bot.DTO.APIErrorResponse;


public class APIServerErrorException extends RuntimeException {

    private final APIErrorResponse apiErrorResponse;

    public APIServerErrorException(APIErrorResponse apiErrorResponse) {
        super("Something went wrong on Scrapper server");
        this.apiErrorResponse = apiErrorResponse;
    }

    public APIErrorResponse getAPIErrorResponse() {
        return apiErrorResponse;
    }
}