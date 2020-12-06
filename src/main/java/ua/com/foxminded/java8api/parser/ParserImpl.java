package ua.com.foxminded.java8api.parser;

import ua.com.foxminded.java8api.domain.Racer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ParserImpl implements Parser {
    private static final String DATE_FORMATTER = "yyyy-MM-dd_HH:mm:ss.SSS";
    private static final String UNDERLINE_DELIMITER = "_";
    private static final int NUMBER_THREE = 3;

    @Override
    public List<Racer> parseToRacers(List<String> list1, List<String> list2, List<String> list3) {
        final List<Racer> listOfRaces = new ArrayList<>();

        Collections.sort(list1);
        Collections.sort(list2);
        Collections.sort(list3);

        for (int i = 0; i < list1.size(); i++) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
            String[] temps = list1.get(i).split(UNDERLINE_DELIMITER);
            String racerName = temps[1];
            String teamName = temps[2];
            LocalDateTime startRace = LocalDateTime.parse(list2.get(i)
                    .substring(NUMBER_THREE), formatter);
            LocalDateTime endRace= LocalDateTime.parse(list3.get(i)
                    .substring(NUMBER_THREE), formatter);
            listOfRaces.add(createRacer(racerName, teamName, startRace, endRace));
        }

        return listOfRaces;
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
}
