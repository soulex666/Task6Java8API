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
    public String provideRaceStatistics(String filename1, String filename2,
                                        String filename3) throws IOException {

        validator.validate(filename1, filename2, filename3);

        List<String> abbreviations = fileReader.readFile(filename1);
        List<String> starts = fileReader.readFile(filename2);
        List<String> ends = fileReader.readFile(filename3);

        List<Racer> racers = parser.parseToRacers(abbreviations, starts, ends);

        racers.sort(Comparator.comparing(x ->
                Duration.between(x.getStartRace(), x.getEndRace()).toMillis()));

        return viewProvider.provideView(racers);
    }
}
