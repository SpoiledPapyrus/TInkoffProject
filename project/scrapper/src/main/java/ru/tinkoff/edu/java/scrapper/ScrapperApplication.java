package ru.tinkoff.edu.java.scrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.reactive.function.client.WebClient;
import ru.tinkoff.edu.java.linkparser.LinkData.GitHubLinkData;
import ru.tinkoff.edu.java.linkparser.LinkData.StackOverflowLinkData;
import ru.tinkoff.edu.java.scrapper.API.HTTP.HTTPGitHubClient;
import ru.tinkoff.edu.java.scrapper.API.HTTP.HTTPStackOverflowClient;
import ru.tinkoff.edu.java.scrapper.API.response.GitHub.GitHubAPIResponse;
import ru.tinkoff.edu.java.scrapper.API.response.StackOverflow.StackOverflowItemAPIResponse;
import ru.tinkoff.edu.java.scrapper.configuration.ApplicationConfig;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class ScrapperApplication {
        public static void main(String[] args) {
                var ctx = SpringApplication.run(ScrapperApplication.class, args);
                ApplicationConfig config = ctx.getBean(ApplicationConfig.class);
                System.out.println(config);
                WebClient webClient = WebClient.create();

                HTTPGitHubClient gitHubClient = new HTTPGitHubClient(webClient);
                GitHubLinkData userAndRepoGit = new GitHubLinkData("SpoiledPapyrus", "TInkoffProject");
                GitHubAPIResponse response = gitHubClient.GetRepo(userAndRepoGit);

                System.out.println(response);
                HTTPStackOverflowClient stackOverflowClient = new HTTPStackOverflowClient(webClient);
                StackOverflowLinkData QuestStack = new StackOverflowLinkData("2876551");
                StackOverflowItemAPIResponse stackResponse =  stackOverflowClient.GetQuestion(QuestStack);
                System.out.println(stackResponse);
        }
}
