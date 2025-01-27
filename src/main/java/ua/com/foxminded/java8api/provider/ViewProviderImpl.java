package ua.com.foxminded.java8api.provider;

import ua.com.foxminded.java8api.domain.Racer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    private static final int NUMBER_ZERO = 0;
    private static final int NUMBER_ONE = 1;
    private static final int NUMBER_FIFTEEN = 15;
    private static final int NUMBER_SIXTEEN = 16;


    @Override
    public String provideView(List<Racer> racers) {
        StringBuilder finalView = new StringBuilder();

        int maxNameLength = Collections.max(racers.stream()
                .map(x -> x.getRacerName().length())
                .collect(Collectors.toList()));

        int maxTeamLength = Collections.max(racers.stream()
                .map(x -> x.getTeamName().length())
                .collect(Collectors.toList()));

        racers.forEach(racer ->
                finalView.append(stringView(racer, racers.indexOf(racer), maxNameLength, maxTeamLength)));

        return finalView.substring(NUMBER_ZERO, finalView.length() - NUMBER_ONE);
    }

    private String calculateBestTime(LocalDateTime startRace, LocalDateTime endRace) {
        long bestRaceTime = Duration.between(startRace, endRace).toMillis();
        DateFormat formatter = new SimpleDateFormat(OUTPUT_TIME_FORMATTER);

        return formatter.format(bestRaceTime);
    }

    private String stringView(Racer racer, int indexOfRacer, int maxNameLength, int maxTeamLength) {
        final StringBuilder stringView = new StringBuilder();
        int count = indexOfRacer + NUMBER_ONE;
        stringView.append(String.format(COUNTER_DELIMITER, count + DOT_DELIMITER))
                .append(String.format((PERCENT_DASH_DELIMITER + maxNameLength + LOWER_CASE_S),
                        racer.getRacerName()))
                .append(String.format(VERTICAL_LINE_FORMATTER, VERTICAL_LINE_DELIMITER))
                .append(String.format((PERCENT_DASH_DELIMITER + maxTeamLength + LOWER_CASE_S),
                        racer.getTeamName()))
                .append(String.format(VERTICAL_LINE_FORMATTER, VERTICAL_LINE_DELIMITER))
                .append(calculateBestTime(racer.getStartRace(), racer.getEndRace()))
                .append(NEWLINE_DELIMITER);
        if (count == NUMBER_FIFTEEN) {
            stringView.append(String.join(EMPTY_STRING,
                    Collections.nCopies((maxNameLength + maxTeamLength + NUMBER_SIXTEEN),
                            DASH_DELIMITER)))
                    .append(NEWLINE_DELIMITER);
        }

        return stringView.toString();
    }
}
