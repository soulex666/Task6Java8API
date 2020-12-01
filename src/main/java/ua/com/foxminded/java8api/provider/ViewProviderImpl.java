package ua.com.foxminded.java8api.provider;

import ua.com.foxminded.java8api.domain.Racer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Map;

public class ViewProviderImpl implements ViewProvider {
    private static final String NEWLINE_DELIMITER = "\n";
    private static final String EMPTY_STRING = "";
    private static final String VERTICAL_LINE_DELIMITER = "|";
    private static final String COUNTER_DELIMITER = "%-4s";
    private static final String DASH_DELIMITER = "-";
    private static final String DOT_DELIMITER = ".";
    private static final String OUTPUT_TIME_FORMATTER = "m:ss.SSS";
    private static final String VERTICAL_LINE_FORMATTER = "%-2s";
    private static final String PERCENT_DASH_DELIMITER = "%-";
    private static final String LOWER_CASE_S = "s";

    @Override
    public String provideView(Map<String, Racer> racers, Map<String, Long> markers) {
        StringBuilder finalView = new StringBuilder();
        int maxNameLength = 0;
        int maxTeamLength = 0;

        for (Map.Entry<String, Racer> temp : racers.entrySet()) {
            if (temp.getValue().getRacerName().length() > maxNameLength) {
                maxNameLength = temp.getValue().getRacerName().length();
            }

            if (temp.getValue().getTeamName().length() > maxTeamLength) {
                maxTeamLength = temp.getValue().getTeamName().length();
            }
        }

        int count = 0;
        for (Map.Entry<String, Long> temp : markers.entrySet()) {
            count++;
            finalView.append(String.format(COUNTER_DELIMITER, count + DOT_DELIMITER))
                    .append(String.format((PERCENT_DASH_DELIMITER + maxNameLength + LOWER_CASE_S),
                            racers.get(temp.getKey()).getRacerName()))
                    .append(String.format(VERTICAL_LINE_FORMATTER, VERTICAL_LINE_DELIMITER))
                    .append(String.format((PERCENT_DASH_DELIMITER + maxTeamLength + LOWER_CASE_S),
                            racers.get(temp.getKey()).getTeamName()))
                    .append(String.format(VERTICAL_LINE_FORMATTER, VERTICAL_LINE_DELIMITER))
                    .append(getBestRacerTime(temp.getValue()))
                    .append(NEWLINE_DELIMITER);
            if (count == 15) {
                finalView.append(String.join(EMPTY_STRING,
                        Collections.nCopies((maxNameLength + maxTeamLength + 16),
                                DASH_DELIMITER)))
                        .append(NEWLINE_DELIMITER);
            }
        }

        return finalView.substring(0, finalView.length() - 1);
    }

    private String getBestRacerTime(long timeInMillis) {
        DateFormat format = new SimpleDateFormat(OUTPUT_TIME_FORMATTER);
        Calendar calendar = format.getCalendar();
        calendar.setTimeInMillis(timeInMillis);

        return format.format(calendar.getTime());
    }
}
