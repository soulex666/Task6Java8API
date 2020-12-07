package ua.com.foxminded.java8api.parser;

import ua.com.foxminded.java8api.domain.Racer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;


public class ParserImpl implements Parser {
    private static final String DATE_FORMATTER = "yyyy-MM-dd_HH:mm:ss.SSS";
    private static final String UNDERLINE_DELIMITER = "_";
    private static final int NUMBER_THREE = 3;

    @Override
    public List<Racer> parseToRacers(List<String> listFromAbbreviationsFile,
                                     List<String> listFromStartFile, List<String> listFromEndFile) {
        final List<Racer> listOfRaces = new ArrayList<>();

        Collections.sort(listFromAbbreviationsFile);
        Collections.sort(listFromStartFile);
        Collections.sort(listFromEndFile);


        for (int i = 0; i < listFromAbbreviationsFile.size(); i++) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
            String[] temps = listFromAbbreviationsFile.get(i).split(UNDERLINE_DELIMITER);
            String racerName = temps[1];
            String teamName = temps[2];
            LocalDateTime startRace = LocalDateTime.parse(listFromStartFile.get(i)
                    .substring(NUMBER_THREE), formatter);
            LocalDateTime endRace= LocalDateTime.parse(listFromEndFile.get(i)
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
