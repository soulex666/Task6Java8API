package ua.com.foxminded.java8api;

import ua.com.foxminded.java8api.cachedata.CacheDataRacersImpl;
import ua.com.foxminded.java8api.provider.DataParserImpl;
import ua.com.foxminded.java8api.provider.ViewProviderImpl;
import ua.com.foxminded.java8api.validator.FilePathValidatorImpl;

import java.io.IOException;

public class Formula1Application {
    public static void main(String[] args) throws IOException {

        Formula1CounterMaker maker = new Formula1CounterMaker(new FilePathValidatorImpl(),
                new CacheDataRacersImpl<>(), new DataParserImpl(), new ViewProviderImpl());

        String test = maker.calculate("src\\main\\resources\\abbreviations.txt",
                    "src\\main\\resources\\start.log",
                    "src\\main\\resources\\end.log");

        System.out.println(test);
    }
}
