package ua.com.foxminded.java8api.parser;

import ua.com.foxminded.java8api.domain.Racer;

import java.util.List;

public interface Parser {
    List<Racer> parseToRacers(List<String> listFromAbbreviationsFile,
                                     List<String> listFromStartFile, List<String> listFromEndFile);
}
