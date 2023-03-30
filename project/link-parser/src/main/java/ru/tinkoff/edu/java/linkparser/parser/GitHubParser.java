package ru.tinkoff.edu.java.linkparser.parser;

import ru.tinkoff.edu.java.linkparser.result.GithubParseResult;
import ru.tinkoff.edu.java.linkparser.result.ParseResult;

import java.net.URL;

public class GitHubParser extends AbstractParser {
    public GitHubParser(AbstractParser nextParser) {
        super(nextParser);
    }

    @Override
    public ParseResult parseResult(String url) {
        URL toParse = tweakUrl(url);
        if (toParse == null) return null;

        if (toParse.getHost().equals("github.com")) {
            String[] tokens = toParse.getFile().substring(1).split("/");
            if (tokens.length >= 2) {
                return new GithubParseResult(tokens[0], tokens[1]);
            } else return null;
        }


        if (nextParser != null) return nextParser.parseResult(url);

        return null;
    }
}