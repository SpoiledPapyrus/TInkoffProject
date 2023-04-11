package ru.tinkoff.edu.java.linkparser.parser;

import ru.tinkoff.edu.java.linkparser.LinkData.linkData;

public final class NullLinkParser extends AbstractLinkParser implements LinkParser {
    @Override
    public linkData parseLink(String site_url) {
        return null;
    }
}