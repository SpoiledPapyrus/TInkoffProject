package ru.tinkoff.edu.java.scrapper.API.response.StackOverflow;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record StackOverflowRootAPIResponse(@JsonProperty("items") List<StackOverflowItemAPIResponse> items){}


