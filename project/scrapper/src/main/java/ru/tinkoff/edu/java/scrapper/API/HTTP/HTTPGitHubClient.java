package ru.tinkoff.edu.java.scrapper.API.HTTP;
import org.springframework.web.reactive.function.client.WebClient;
import ru.tinkoff.edu.java.linkparser.LinkData.GitHubLinkData;
import ru.tinkoff.edu.java.scrapper.API.HTTP.interfaces.GitHubClient;
import ru.tinkoff.edu.java.scrapper.API.response.GitHub.GitHubAPIResponse;
public class HTTPGitHubClient implements GitHubClient {

    private static final String GIT_URL = "https://api.github.com/repos/";
    private static final String PATH_DELIMITER = "/";

    private final String GitUrl;
    private final WebClient webClient;

    public HTTPGitHubClient(WebClient webClient) {
        this.webClient = webClient;
        GitUrl = GIT_URL;
    }

    public HTTPGitHubClient(String baseUrl, WebClient webClient) {
        this.GitUrl = baseUrl;
        this.webClient = webClient;
    }

    @Override
    public GitHubAPIResponse GetRepo(GitHubLinkData userAndRepo) {
        return webClient
                .get()
                .uri(GitUrl + userAndRepo.user_name() + PATH_DELIMITER + userAndRepo.repository_name())
                .retrieve().bodyToMono(GitHubAPIResponse.class).block();
    }

}
