package ru.tinkoff.edu.java.bot.DTO;
import java.util.List;
public record Webpage (long id, String url, String description, List<Long> tgChatIds){
}
