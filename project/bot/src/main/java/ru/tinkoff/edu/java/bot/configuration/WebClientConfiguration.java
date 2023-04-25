package ru.tinkoff.edu.java.bot.configuration;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import ru.tinkoff.edu.java.bot.scrapper.API.HTTPScrapperClient;
import ru.tinkoff.edu.java.bot.scrapper.API.ScrapperClient;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebClientConfiguration {

    @Bean
    public WebClient webClient(
            @Value("${web.timeout.httpclient.ms}") int httpClientTimeout,
            @Value("${web.timeout.read.ms}") int readTimeout,
            @Value("${web.timeout.write.ms}") int writeTimeout
    ) {
        var httpClient = HttpClient
                .create().option(ChannelOption.CONNECT_TIMEOUT_MILLIS, httpClientTimeout)
                .doOnConnected(con -> {
                    con.addHandlerLast(new ReadTimeoutHandler(readTimeout, TimeUnit.MILLISECONDS));
                    con.addHandlerLast(new WriteTimeoutHandler(writeTimeout, TimeUnit.MILLISECONDS));
                }).compress(true);
        return WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient)).build();
    }

    @Bean
    public ScrapperClient scrapperClient(WebClient webClient) {
        return new HTTPScrapperClient(webClient);
    }
}