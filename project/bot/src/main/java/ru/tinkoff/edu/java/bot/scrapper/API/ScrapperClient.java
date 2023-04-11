package ru.tinkoff.edu.java.bot.scrapper.API;


import ru.tinkoff.edu.java.bot.scrapper.API.model.AllLinksAPIResponse;
import ru.tinkoff.edu.java.bot.scrapper.API.model.LinkResponse;

public interface ScrapperClient {

    void registerChat(long chatId);

    void deleteChat(long chatId);

    AllLinksAPIResponse getAllLinks(long tgChatId);

    LinkResponse addLink(long tgChatId, String link);

    LinkResponse deleteLink(long tgChatId, String link);
}
