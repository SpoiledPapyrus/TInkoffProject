package ru.tinkoff.edu.java.scrapper.API.HTTP.interfaces;

import ru.tinkoff.edu.java.linkparser.LinkData.GitHubLinkData;
import ru.tinkoff.edu.java.scrapper.API.response.GitHub.GitHubAPIResponse;

public interface GitHubClient {
    GitHubAPIResponse GetRepo(GitHubLinkData userAndRepo);
}
