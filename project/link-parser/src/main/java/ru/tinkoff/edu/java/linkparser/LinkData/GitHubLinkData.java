package ru.tinkoff.edu.java.linkparser.LinkData;

public record GitHubLinkData(String user_name, String repository_name) implements linkData {
    @Override
    public String toString() {
        return user_name + "/" + repository_name;

    }

}