package ua.com.foxminded.java8api.provider;

import ua.com.foxminded.java8api.domain.Racer;

import java.util.Calendar;

public interface DataParser {
    Racer parseRacer(String[] sentence);

    Calendar parseLogFile(String sentence);
}
