package ua.com.foxminded.java8api.parser;

import ua.com.foxminded.java8api.domain.Racer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;


public class ParserImpl implements Parser {
    private static final String DATE_FORMATTER = "yyyy-MM-dd_HH:mm:ss.SSS";
    private static final String UNDERLINE_DELIMITER = "_";
    private static final int NUMBER_ZERO = 0;
    private static final int NUMBER_ONE = 1;
    private static final int NUMBER_THREE = 3;
    private static final int NUMBER_FOUR = 4;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMATTER);

    @Override
    public List<Racer> parseToRacers(List<String> listFromAbbreviationsFile,
                                     List<String> listFromStartFile, List<String> listFromEndFile) {

        Map<String, LocalDateTime> startTimes = dateTimeParser(listFromStartFile);

        Map<String, LocalDateTime> endTimes = dateTimeParser(listFromEndFile);

        return listFromAbbreviationsFile.stream()
                .collect(toMap(
                        str -> str.substring(NUMBER_ZERO, NUMBER_THREE),
                        str -> str.substring(NUMBER_FOUR)))
                .entrySet()
                .stream()
                .map(x -> createRacer(
                        x.getValue().split(UNDERLINE_DELIMITER)[NUMBER_ZERO],
                        x.getValue().split(UNDERLINE_DELIMITER)[NUMBER_ONE],
                        startTimes.get(x.getKey()),
                        endTimes.get(x. getKey())))
                .collect(Collectors.toList());
    }

    private Racer createRacer(String racerName, String teamName,
                              LocalDateTime startRace, LocalDateTime endRace) {

        return Racer.builder()
                .withRacerName(racerName)
                .withTeamName(teamName)
                .withStartRace(startRace)
                .withEndRace(endRace)
                .build();
    }

    private Map<String, LocalDateTime> dateTimeParser(List<String> stringsForParser) {
        return stringsForParser.stream()
                .collect(toMap(
                        str -> str.substring(NUMBER_ZERO, NUMBER_THREE),
                        str -> LocalDateTime.parse(str
                                .substring(NUMBER_THREE), FORMATTER)));
    }
}
