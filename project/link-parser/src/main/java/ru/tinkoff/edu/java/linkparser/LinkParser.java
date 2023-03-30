package ru.tinkoff.edu.java.linkparser;

import ru.tinkoff.edu.java.linkparser.parser.StackOverflowParser;
import ru.tinkoff.edu.java.linkparser.parser.GitHubParser;
import ru.tinkoff.edu.java.linkparser.parser.AbstractParser;
import ru.tinkoff.edu.java.linkparser.result.ParseResult;

public class LinkParser {
    public ParseResult parseUrl(String url) {
        AbstractParser parser1 = new GitHubParser(null);
        AbstractParser parser2 = new StackOverflowParser(parser1);

        return parser2.parseResult(url);
    }

}
