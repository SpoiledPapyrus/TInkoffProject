package ru.tinkoff.edu.java.linkparser.LinkData;

public record StackOverflowLinkData(String question_id) implements linkData {
    @Override
    public String toString() {
        return question_id;
    }
}
