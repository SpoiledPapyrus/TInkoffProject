package ru.tinkoff.edu.java.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.tinkoff.edu.java.bot.configuration.ApplicationConfig;
import ru.tinkoff.edu.java.bot.model.core.BotCreator;
import ru.tinkoff.edu.java.bot.model.manage.*;
import ru.tinkoff.edu.java.bot.scrapper.API.ScrapperClient;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class BotApplication {
        public static void main(String[] args) {
                var ctx = SpringApplication.run(BotApplication.class, args);
                ApplicationConfig config = ctx.getBean(ApplicationConfig.class);
                System.out.println(config);
                ScrapperClient client = ctx.getBean(ScrapperClient.class);
                BotCreator TgBot = new BotCreator(
                        config.bot().token(),
                        new Start(client),
                        new List(client),
                        new Track(client),
                        new Untrack(client),
                        new Help());
        }
}
