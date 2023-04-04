package ru.tinkoff.edu.java.bot.DTO;
import java.util.List;
public record Error(String description,
                   String code,
                   String exceptionName,
                   String exceptionMessage,
                   List<String> stacktrace) {
}
