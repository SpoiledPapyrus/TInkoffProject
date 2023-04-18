package ru.tinkoff.edu.java.bot.model.manage;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import ru.tinkoff.edu.java.bot.scrapper.API.ScrapperClient;
import ru.tinkoff.edu.java.bot.scrapper.API.ErrorException.APIClientErrorException;
import ru.tinkoff.edu.java.bot.scrapper.API.ErrorException.APIServerErrorException;
import ru.tinkoff.edu.java.bot.scrapper.API.model.AllLinksAPIResponse;

@AllArgsConstructor
public class List implements Command {
    private final ScrapperClient scrapperClient;

    @Override
    public String command() {
        return "list";
    }

    @Override
    public String description() {
        return "Показать список отслеживаемых ссылок";
    }

    @Override
    public SendMessage process(Update update) {
        AllLinksAPIResponse listLinksResponse;
        try {
            listLinksResponse = scrapperClient.getAllLinks(update.message().chat().id());
        } catch (APIClientErrorException e) {
            return new SendMessage(update.message().chat().id(),"Список отслеживаемых ссылок пуст!");
        } catch (APIServerErrorException e) {
            return new SendMessage(update.message().chat().id(),"Список отслеживаемых ссылок пуст!");
        }
        var builder = new StringBuilder();
        if (listLinksResponse.size() == 0) {
            builder.append("Список отслеживаемых ссылок пуст!");
        } else {
            builder.append("Вы отслеживаете следующие ссылки:\n");
            listLinksResponse.links().forEach(x -> builder.append(x.url()).append("\n"));
        }
        return new SendMessage(update.message().chat().id(), builder.toString());
    }

}