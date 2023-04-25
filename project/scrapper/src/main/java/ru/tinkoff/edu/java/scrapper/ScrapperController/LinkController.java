package ru.tinkoff.edu.java.scrapper.ScrapperController;

import org.springframework.web.bind.annotation.*;
import ru.tinkoff.edu.java.scrapper.DTO.AddLinkRequest;
import ru.tinkoff.edu.java.scrapper.DTO.DeleteLinkRequest;
import ru.tinkoff.edu.java.scrapper.DTO.LinkResponse;
import ru.tinkoff.edu.java.scrapper.DTO.ListLinkResponse;
import ru.tinkoff.edu.java.scrapper.exception.IncorrectException;
import ru.tinkoff.edu.java.scrapper.exception.NotFoundException;

import java.util.*;

@RestController
@RequestMapping("/links")
public class LinkController {

    private final Map<Long, ListLinkResponse> ListLinks = new HashMap<>();
    private final Random RandomValue = new Random();

    public LinkController() {
        ListLinks.put(123456L, new ListLinkResponse(new ArrayList<>(
                Arrays.asList(new LinkResponse
                        (1, "https://github.com/SpoiledPapyrus/TInkoffProject"))), 1));
        ListLinks.put(654321L, new ListLinkResponse
                (new ArrayList<>(Arrays.asList(new LinkResponse(2, "https://stackoverflow.com/questions/64828589/what-is-the-meaning-of-generating-sources-in-java-building-process"))), 1));
        ListLinks.put(567890L, new ListLinkResponse(new ArrayList<>(
                Arrays.asList(new LinkResponse(3, "https://stackoverflow.com/questions/2469911/how-do-i-assert-my-exception-message-with-junit-test-annotation"))), 1));
    }

    @GetMapping
    public ListLinkResponse getLink(@RequestHeader ("Tg-Chat-Id") long tgChatId){
        var listLinkResponse = ListLinks.get(tgChatId);
        if (listLinkResponse != null) return listLinkResponse;
        else throw new IncorrectException(String.format("don`t exist this links for tg-chat-id", tgChatId));
    }

    @PostMapping
    public LinkResponse addLink(@RequestHeader ("Tg-Chat-Id") long tgChatId, @RequestBody AddLinkRequest request){
        var listLinksResponse = ListLinks.get(tgChatId);
        var newLinkResponse = new LinkResponse(RandomValue.nextLong(), request.link());
        if (listLinksResponse == null) {
            ListLinks.put(tgChatId, new ListLinkResponse(new ArrayList<>(Arrays.asList(newLinkResponse)), 1));
        } else {
            if (listLinksResponse.links().stream().anyMatch(linkResponse -> linkResponse.url().equals(newLinkResponse.url()))) {
                throw new IncorrectException("The link you adding already exists");
            } else {
                listLinksResponse.links().add(newLinkResponse);
                ListLinks.put(tgChatId, new ListLinkResponse(listLinksResponse.links(), listLinksResponse.size() + 1));
            }
        }
        return newLinkResponse;
    }

    @DeleteMapping
    public LinkResponse deleteLink(@RequestHeader("Tg-Chat-Id") long tgChatId, @RequestBody DeleteLinkRequest request) {
        if (!ListLinks.containsKey(tgChatId)) {
            throw new IncorrectException(String.format("There is no such tg-chat-id [%s]", tgChatId));
        }
        var listLinksResponse = ListLinks.get(tgChatId);
        if (!listLinksResponse.links().removeIf(x -> x.url().equals(request.link()))) {
            throw new NotFoundException(String.format("There is no such link [%s]", request.link()));
        } else {
            ListLinks.put(tgChatId, new ListLinkResponse(listLinksResponse.links(), listLinksResponse.size() - 1));
            return new LinkResponse(RandomValue.nextLong(), request.link());
        }
    }
}
