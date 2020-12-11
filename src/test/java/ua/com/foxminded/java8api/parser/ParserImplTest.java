package ua.com.foxminded.java8api.parser;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.java8api.domain.Racer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParserImplTest {
    private static final String DATE_FORMATTER = "yyyy-MM-dd_HH:mm:ss.SSS";

    private final Parser parser = new ParserImpl();

    @Test
    void parseToRacersShouldReturnCorrectResult() {
        List<String> list1 = new ArrayList<>();
        list1.add("KRF_Kimi Raikkonen_FERRARI");
        List<String> list2 = new ArrayList<>();
        list2.add("KRF2018-05-24_12:03:01.250");
        List<String> list3 = new ArrayList<>();
        list3.add("KRF2018-05-24_12:04:13.889");

        List<Racer> expected = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);

        expected.add(Racer.builder()
                .withRacerName("Kimi Raikkonen")
                .withTeamName("FERRARI")
                .withStartRace(LocalDateTime.parse("2018-05-24_12:03:01.250", formatter))
                .withEndRace(LocalDateTime.parse("2018-05-24_12:04:13.889", formatter))
                .build());

        List<Racer> actual = parser.parseToRacers(list1, list2, list3);

        assertThat(actual).isEqualTo(expected);
    }
}
