package ua.com.foxminded.java8api;

import ua.com.foxminded.java8api.cachedata.CacheDataRacers;
import ua.com.foxminded.java8api.domain.Racer;
import ua.com.foxminded.java8api.provider.DataParser;
import ua.com.foxminded.java8api.provider.ViewProvider;
import ua.com.foxminded.java8api.validator.FilePathValidator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Formula1CounterMaker {
    private static final String UNDERLINE_DELIMITER = "_";

    private final CacheDataRacers<String, Racer> racers;
    private final DataParser reader;
    private final FilePathValidator validator;
    private final ViewProvider viewProvider;

    public Formula1CounterMaker(FilePathValidator validator, CacheDataRacers<String, Racer> racers,
                                DataParser reader, ViewProvider viewProvider) {
        this.validator = validator;
        this.racers = racers;
        this.reader = reader;
        this.viewProvider = viewProvider;
    }

    public String calculate(String abbrPath, String startLogPath, String endLogPath) throws IOException {
        validator.validate(abbrPath);
        validator.validate(startLogPath);
        validator.validate(endLogPath);

        Path abbr = new File(abbrPath).toPath();
        Path startLog = new File(startLogPath).toPath();
        Path endLog = new File(endLogPath).toPath();
        try (Stream<String> fileStream = Files.newBufferedReader(abbr).lines()) {
            racers.putAll(fileStream
                    .map(s -> s.split(UNDERLINE_DELIMITER))
                    .collect(Collectors.toMap(s -> s[0],
                            reader::parseRacer)));
        }

        try (Stream<String> fileStream = Files.newBufferedReader(startLog).lines()) {
            fileStream
                    .forEach(s -> racers
                            .get(s.substring(0, 3))
                            .setStartRace(reader.parseLogFile(s.substring(3))));

        }

        try (Stream<String> fileStream = Files.newBufferedReader(endLog).lines()) {
            fileStream
                    .forEach(s -> racers
                            .get(s.substring(0, 3))
                            .setEndRace(reader.parseLogFile(s.substring(3))));

        }

        Map<String, Long> bestTimeMap = new LinkedHashMap<>();
        for (Map.Entry<String, Racer> tempEntry : racers.getMap().entrySet()) {
            bestTimeMap.put(tempEntry.getKey(), tempEntry.getValue().getEndRace().getTimeInMillis()
                    - tempEntry.getValue().getStartRace().getTimeInMillis());
        }

        Map<String, Long> tempMap2 = bestTimeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        return viewProvider.provideView(racers.getMap(), tempMap2);
    }
}
