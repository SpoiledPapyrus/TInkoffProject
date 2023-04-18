package ru.tinkoff.edu.java.scrapper.ScrapperController;

import org.springframework.web.bind.annotation.*;
import ru.tinkoff.edu.java.scrapper.exception.IncorrectException;
import ru.tinkoff.edu.java.scrapper.exception.NotFoundException;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/tg-chat")
public class TelegramController {

    private final Set<Long> TelegramIds = new HashSet<>();

    @PostMapping("/{id}")
    public String registerChat(@PathVariable long id) {
        if (!TelegramIds.add(id))
            throw new IncorrectException(String.format("Chat was already exists", id));
        else return "Chat was registered";
    }

    @DeleteMapping("/{id}")
    public String deleteChat(@PathVariable long id){
        if (!TelegramIds.remove(id))
            throw new NotFoundException(String.format("Chat was doesn't exist", id));
        else return "Chat was deleted";
    }
}

