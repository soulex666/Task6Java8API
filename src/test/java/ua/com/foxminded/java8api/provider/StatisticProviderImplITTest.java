package ua.com.foxminded.java8api.provider;

import org.junit.jupiter.api.Test;
import ua.com.foxminded.java8api.parser.ParserImpl;
import ua.com.foxminded.java8api.reader.FileReaderImpl;
import ua.com.foxminded.java8api.validator.ValidatorImpl;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class StatisticProviderImplITTest {
    final StatisticProvider maker = new StatisticProviderImpl(new ValidatorImpl(), new FileReaderImpl(),
            new ParserImpl(), new ViewProviderImpl());

    @Test
    void provideRaceStatisticsShouldReturnCorrectResult() throws IOException {
        String expected =   "1.  Sebastian Vettel| FERRARI                  | 1:04.415\n" +
                "2.  Daniel Ricciardo| RED BULL RACING TAG HEUER| 1:12.013\n" +
                "3.  Valtteri Bottas | MERCEDES                 | 1:12.434";

        String actual = maker.provideRaceStatistics("src\\test\\resources\\abbreviations.txt",
                "src\\test\\resources\\start.log",
                "src\\test\\resources\\end.log");

        assertThat(actual).isEqualTo(expected);
    }
}
