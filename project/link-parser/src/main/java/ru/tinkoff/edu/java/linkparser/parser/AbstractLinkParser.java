package ru.tinkoff.edu.java.linkparser.parser;

import ru.tinkoff.edu.java.linkparser.LinkData.linkData;

public abstract non-sealed class AbstractLinkParser implements LinkParser {
    private AbstractLinkParser next_parser;
    public AbstractLinkParser setNext(AbstractLinkParser next_parser) {
        this.next_parser = next_parser;
        return next_parser;
    }
    public linkData handleNext(String url) {
        if (next_parser != null) {
            return next_parser.parseLink(url);
        }
        return null;
    }
}