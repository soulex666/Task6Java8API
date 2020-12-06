package ua.com.foxminded.java8api;

import ua.com.foxminded.java8api.parser.ParserImpl;
import ua.com.foxminded.java8api.provider.StatisticProvider;
import ua.com.foxminded.java8api.provider.StatisticProviderImpl;
import ua.com.foxminded.java8api.provider.ViewProviderImpl;
import ua.com.foxminded.java8api.reader.FileReaderImpl;
import ua.com.foxminded.java8api.validator.ValidatorImpl;

import java.io.IOException;

public class Formula1Application {
    public static void main(String[] args) throws IOException {

        StatisticProvider maker = new StatisticProviderImpl(new ValidatorImpl(), new FileReaderImpl(),
                new ParserImpl(), new ViewProviderImpl());

        String test = maker.provideRaceStatistics("src\\main\\resources\\abbreviations.txt",
                    "src\\main\\resources\\start.log",
                    "src\\main\\resources\\end.log");

        System.out.println(test);
    }
}
