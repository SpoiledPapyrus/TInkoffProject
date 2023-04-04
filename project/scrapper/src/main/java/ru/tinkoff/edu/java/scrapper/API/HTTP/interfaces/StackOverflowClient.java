package ru.tinkoff.edu.java.scrapper.API.HTTP.interfaces;

import ru.tinkoff.edu.java.linkparser.LinkData.StackOverflowLinkData;
import ru.tinkoff.edu.java.scrapper.API.response.StackOverflow.StackOverflowItemAPIResponse;

public interface StackOverflowClient {
    StackOverflowItemAPIResponse GetQuestion(StackOverflowLinkData question);
}
