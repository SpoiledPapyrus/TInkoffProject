package ru.tinkoff.edu.java.linkparser.parser;

import ru.tinkoff.edu.java.linkparser.LinkData.linkData;
import ru.tinkoff.edu.java.linkparser.LinkData.StackOverflowLinkData;

public final class StackOverflowLinkParser extends AbstractLinkParser implements LinkParser {
    private static final String STACKOF_HOST = "stackoverflow.com";
    @Override
    public linkData parseLink(String stack_url) {
        if (stack_url != null && stack_url.contains(STACKOF_HOST) && stack_url.contains("questions")) {
            String[] parts = stack_url.split("/");
            if (parts.length >= 5) {
                String question_id = parts[4];
                return new StackOverflowLinkData(question_id);
            }
        }
        return handleNext(stack_url);
    }
}