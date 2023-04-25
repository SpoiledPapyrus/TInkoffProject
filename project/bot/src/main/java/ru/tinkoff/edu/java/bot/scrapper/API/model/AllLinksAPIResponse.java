package ru.tinkoff.edu.java.bot.scrapper.API.model;

import java.util.List;

public record AllLinksAPIResponse(List<LinkResponse> links, int size) {
}