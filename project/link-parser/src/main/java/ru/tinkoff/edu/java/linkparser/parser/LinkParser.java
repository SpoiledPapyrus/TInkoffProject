package ru.tinkoff.edu.java.linkparser.parser;

import ru.tinkoff.edu.java.linkparser.LinkData.linkData;

public sealed interface LinkParser permits AbstractLinkParser, NullLinkParser, GitHubLinkParser, StackOverflowLinkParser {
    linkData parseLink(String site_url);
}