package ua.com.foxminded.java8api.parser;

import ua.com.foxminded.java8api.domain.Racer;

import java.util.List;

public interface Parser {
    List<Racer> parseToRacers(List<String> list1,
                                     List<String> list2, List<String> list3);
}
