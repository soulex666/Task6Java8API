package ua.com.foxminded.java8api.provider;

import ua.com.foxminded.java8api.domain.Racer;
import ua.com.foxminded.java8api.reader.FileReader;
import ua.com.foxminded.java8api.validator.Validator;
import ua.com.foxminded.java8api.parser.Parser;

import java.io.IOException;
import java.time.Duration;
import java.util.Comparator;
import java.util.List;

public class StatisticProviderImpl implements StatisticProvider {

    private final Validator validator;
    private final FileReader fileReader;
    private final Parser parser;
    private final ViewProvider viewProvider;

    public StatisticProviderImpl(Validator validator, FileReader fileReader, Parser parser,
                                 ViewProvider viewProvider) {
        this.validator = validator;
        this.fileReader = fileReader;
        this.parser = parser;
        this.viewProvider = viewProvider;
    }

    @Override
    public String provideRaceStatistics(String abbreviationsPath, String startRacePath,
                                        String endRacePath) throws IOException {

        validator.validate(abbreviationsPath, startRacePath, endRacePath);

        List<String> abbreviations = fileReader.readFile(abbreviationsPath);
        List<String> starts = fileReader.readFile(startRacePath);
        List<String> ends = fileReader.readFile(endRacePath);

        List<Racer> racers = parser.parseToRacers(abbreviations, starts, ends);

        racers.sort(Comparator.comparing(x ->
                Duration.between(x.getStartRace(), x.getEndRace()).toMillis()));

        return viewProvider.provideView(racers);
    }
}
