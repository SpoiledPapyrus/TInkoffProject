package ru.tinkoff.edu.java.bot.BotController;

import org.springframework.web.bind.annotation.*;
import ru.tinkoff.edu.java.bot.DTO.Webpage;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/updates")
public class BotController {

    private final List<Webpage> LinkUpdates = new ArrayList<>();

    @PostMapping
    public String updateChat(@RequestBody Webpage update){
        LinkUpdates.add(update);
        return "Chat was updated!";
    }
}