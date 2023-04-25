package ru.tinkoff.edu.java.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.tinkoff.edu.java.parser.parsers.GitHubLinkParser;
import ru.tinkoff.edu.java.parser.record.GitHubRecord;

public class GitHubLinkParserTest {
    private final GitHubLinkParser gitHubLinkParser = new GitHubLinkParser(null);
    private final String username = "SpoiledPapyrus";
    private final String repo = "Test";


    @Test
    public void invalidLinkParse() {
        String link1 = "https://github.com/" + username;
        String link2 = "https://github.com/" + username + "/" + repo + "/" + "pulls";

        Record record1 = gitHubLinkParser.parseLink(link1);
        Record record2 = gitHubLinkParser.parseLink(link2);

        Assertions.assertNull(record1);
        Assertions.assertNull(record2);
    }
}
