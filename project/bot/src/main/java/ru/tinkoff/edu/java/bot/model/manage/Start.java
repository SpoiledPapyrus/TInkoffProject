package ru.tinkoff.edu.java.bot.model.manage;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import ru.tinkoff.edu.java.bot.scrapper.API.ScrapperClient;
import ru.tinkoff.edu.java.bot.scrapper.API.ErrorException.APIClientErrorException;
import ru.tinkoff.edu.java.bot.scrapper.API.ErrorException.APIServerErrorException;

@AllArgsConstructor
public class Start implements Command {
    private final ScrapperClient scrapperClient;

    @Override
    public String command() {
        return "start";
    }

    @Override
    public String description() {
        return "Зарегистрировать пользователя";
    }

    @Override
    public SendMessage process(Update update) {
        try {
            scrapperClient.registerChat(update.message().chat().id());
        } catch (APIServerErrorException e) {
            System.out.println();
        } catch (APIClientErrorException e) {
            return new SendMessage(update.message().chat().id(),"Пользователь уже зарегистрирован");
        }
        return new SendMessage(update.message().chat().id(), getHelloText(update.message().chat().firstName()))
                .parseMode(ParseMode.HTML);
    }

    private String getHelloText(String name) {
        return "<b>Привет! Чтобы получить список доступных команд, используйте команду</b>  /help";
    }
}
