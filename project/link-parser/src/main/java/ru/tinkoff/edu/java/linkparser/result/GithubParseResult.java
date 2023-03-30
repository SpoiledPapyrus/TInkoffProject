package ru.tinkoff.edu.java.linkparser.result;


public record GithubParseResult(String username, String repository) implements ParseResult {

}