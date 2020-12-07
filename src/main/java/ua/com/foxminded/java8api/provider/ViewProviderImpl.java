package ua.com.foxminded.java8api.provider;

import ua.com.foxminded.java8api.domain.Racer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    private static final int NUMBER_SIXTEEN = 16;
    private static final int NUMBER_FIFTEEN = 16;

    @Override
    public String provideView(List<Racer> racers) {
        StringBuilder finalView = new StringBuilder();
        int maxNameLength = 0;
        int maxTeamLength = 0;


        for (Racer temp : racers) {
            if (temp.getRacerName().length() > maxNameLength) {
                maxNameLength = temp.getRacerName().length();
            }

            if (temp.getTeamName().length() > maxTeamLength) {
                maxTeamLength = temp.getTeamName().length();
            }
        }

        int count = 0;
        for (Racer temp : racers) {
            count++;
            finalView.append(String.format(COUNTER_DELIMITER, count + DOT_DELIMITER))
                    .append(String.format((PERCENT_DASH_DELIMITER + maxNameLength + LOWER_CASE_S),
                            temp.getRacerName()))
                    .append(String.format(VERTICAL_LINE_FORMATTER, VERTICAL_LINE_DELIMITER))
                    .append(String.format((PERCENT_DASH_DELIMITER + maxTeamLength + LOWER_CASE_S),
                            temp.getTeamName()))
                    .append(String.format(VERTICAL_LINE_FORMATTER, VERTICAL_LINE_DELIMITER))
                    .append(calculateBestTime(temp.getStartRace(), temp.getEndRace()))
                    .append(NEWLINE_DELIMITER);
            if (count == NUMBER_FIFTEEN) {
                finalView.append(String.join(EMPTY_STRING,
                        Collections.nCopies((maxNameLength + maxTeamLength + NUMBER_SIXTEEN),
                                DASH_DELIMITER)))
                        .append(NEWLINE_DELIMITER);
            }
        }

        return finalView.substring(0, finalView.length() - 1);
    }

    private String calculateBestTime(LocalDateTime startRace, LocalDateTime endRace) {
        long bestRaceTime = Duration.between(startRace, endRace).toMillis();
        DateFormat formatter = new SimpleDateFormat(OUTPUT_TIME_FORMATTER);

        return formatter.format(bestRaceTime);
    }
}
