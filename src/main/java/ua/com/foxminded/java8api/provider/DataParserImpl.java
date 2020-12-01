package ua.com.foxminded.java8api.provider;

import ua.com.foxminded.java8api.domain.Racer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataParserImpl implements DataParser {
    private static final String DATE_FORMATTER = "yyyy-MM-dd'_'HH:mm:ss.SSS";

    @Override
    public Racer parseRacer(String[] sentence) {
        return Racer.builder()
                .withRacerName(sentence[1])
                .withTeamName(sentence[2])
                .build();
    }

    public Calendar parseLogFile(String sentence) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMATTER);
        Calendar date = formatter.getCalendar();

        try {
            date.setTime(formatter.parse(sentence));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }
}
