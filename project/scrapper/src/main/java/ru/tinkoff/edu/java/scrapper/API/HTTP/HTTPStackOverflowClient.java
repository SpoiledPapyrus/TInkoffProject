package ru.tinkoff.edu.java.scrapper.API.HTTP;
import org.springframework.web.reactive.function.client.WebClient;
import ru.tinkoff.edu.java.linkparser.LinkData.StackOverflowLinkData;
import ru.tinkoff.edu.java.scrapper.API.HTTP.interfaces.StackOverflowClient;
import ru.tinkoff.edu.java.scrapper.API.response.StackOverflow.StackOverflowItemAPIResponse;
import ru.tinkoff.edu.java.scrapper.API.response.StackOverflow.StackOverflowRootAPIResponse;

public class HTTPStackOverflowClient implements StackOverflowClient {
    private static final String BASE_URL = "https://api.stackexchange.com/2.3/questions/";
    private static final String STACKOVERFLOW_MANDATORY_REQUEST_PARAMS = "?order=desc&sort=activity&site=stackoverflow";

    private final String baseUrl;
    private final WebClient webClient;

    public HTTPStackOverflowClient(WebClient webClient) {
        this.webClient = webClient;
        baseUrl = BASE_URL;
    }

    public HTTPStackOverflowClient(String baseUrl, WebClient webClient) {
        this.baseUrl = baseUrl;
        this.webClient = webClient;
    }

    @Override
    public StackOverflowItemAPIResponse GetQuestion(StackOverflowLinkData id) {
        var response = webClient.get()
                .uri(baseUrl + id.question_id() + STACKOVERFLOW_MANDATORY_REQUEST_PARAMS)
                .retrieve().bodyToMono(StackOverflowRootAPIResponse.class).block();
        return response.items().get(0);
    }
}

