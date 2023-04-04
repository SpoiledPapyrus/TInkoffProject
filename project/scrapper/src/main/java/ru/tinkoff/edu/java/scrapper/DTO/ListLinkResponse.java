package ru.tinkoff.edu.java.scrapper.DTO;

import java.util.List;

public record ListLinkResponse(List<LinkResponse> links, int size) {}