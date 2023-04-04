package ru.tinkoff.edu.java.linkparser;

import ru.tinkoff.edu.java.linkparser.LinkData.linkData;
import ru.tinkoff.edu.java.linkparser.parser.*;

public class LinkParserMain {

    public static void main(String[] args) {

        AbstractLinkParser gitHubParser = new GitHubLinkParser();
        AbstractLinkParser stackOverflowParser = new StackOverflowLinkParser();
        AbstractLinkParser nullParser = new NullLinkParser();

        gitHubParser.setNext(stackOverflowParser);
        stackOverflowParser.setNext(nullParser);

        String[] urls = {
                "https://github.com/SpoiledPapyrus/TInkoffProject",
                "https://github.com/sanyarnd/tinkoff-java-course-2022/",
                "https://stackoverflow.com/questions/1642028/what-is-the-operator-in-c",
                "https://stackoverflow.com/search?q=unsupported%20link"
        };

        for (String url : urls) {
            linkData data = gitHubParser.parseLink(url);
            System.out.println(data);
        }
    }
}

