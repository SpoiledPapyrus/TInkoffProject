package ru.tinkoff.edu.java.bot.scrapper.API.ErrorException;

import ru.tinkoff.edu.java.bot.DTO.APIErrorResponse;


public class APIClientErrorException extends RuntimeException {

    private final APIErrorResponse apiErrorResponse;

    public APIClientErrorException(APIErrorResponse apiErrorResponse) {
        super("Incorrect request for Scrapper");
        this.apiErrorResponse = apiErrorResponse;
    }

    public APIErrorResponse getAPIErrorResponse() {
        return apiErrorResponse;
    }
}
