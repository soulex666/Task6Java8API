package ua.com.foxminded.java8api.provider;

import org.junit.jupiter.api.Test;
import ua.com.foxminded.java8api.domain.Racer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ViewProviderImplTest {
    private static final String DATE_FORMATTER = "yyyy-MM-dd_HH:mm:ss.SSS";

    private final ViewProvider provider = new ViewProviderImpl();

    @Test
    void provideViewShouldReturnCorrectResult() {
        String expected =   "1.  Sebastian Vettel | FERRARI                  | 1:04.415\n" +
                "2.  Daniel Ricciardo | RED BULL RACING TAG HEUER| 1:12.013\n" +
                "3.  Valtteri Bottas  | MERCEDES                 | 1:12.434\n" +
                "4.  Lewis Hamilton   | MERCEDES                 | 1:12.460\n" +
                "5.  Stoffel Vandoorne| MCLAREN RENAULT          | 1:12.463\n" +
                "6.  Kimi Raikkonen   | FERRARI                  | 1:12.639\n" +
                "7.  Fernando Alonso  | MCLAREN RENAULT          | 1:12.657\n" +
                "8.  Sergey Sirotkin  | WILLIAMS MERCEDES        | 1:12.706\n" +
                "9.  Charles Leclerc  | SAUBER FERRARI           | 1:12.829\n" +
                "10. Sergio Perez     | FORCE INDIA MERCEDES     | 1:12.848\n" +
                "11. Romain Grosjean  | HAAS FERRARI             | 1:12.930\n" +
                "12. Pierre Gasly     | SCUDERIA TORO ROSSO HONDA| 1:12.941\n" +
                "13. Carlos Sainz     | RENAULT                  | 1:12.950\n" +
                "14. Esteban Ocon     | FORCE INDIA MERCEDES     | 1:13.028\n" +
                "15. Nico Hulkenberg  | RENAULT                  | 1:13.065\n" +
                "----------------------------------------------------------\n" +
                "16. Brendon Hartley  | SCUDERIA TORO ROSSO HONDA| 1:13.179";

        final List<Racer> temp = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);

        temp.add(Racer.builder()
                .withRacerName("Sebastian Vettel")
                .withTeamName("FERRARI")
                .withStartRace(LocalDateTime.parse("2018-05-24_12:02:58.917", formatter))
                .withEndRace(LocalDateTime.parse("2018-05-24_12:04:03.332", formatter))
                .build());
        temp.add(Racer.builder()
                .withRacerName("Daniel Ricciardo")
                .withTeamName("RED BULL RACING TAG HEUER")
                .withStartRace(LocalDateTime.parse("2018-05-24_12:14:12.054", formatter))
                .withEndRace(LocalDateTime.parse("2018-05-24_12:15:24.067", formatter))
                .build());
        temp.add(Racer.builder()
                .withRacerName("Valtteri Bottas")
                .withTeamName("MERCEDES")
                .withStartRace(LocalDateTime.parse("2018-05-24_12:00:00.000", formatter))
                .withEndRace(LocalDateTime.parse("2018-05-24_12:01:12.434", formatter))
                .build());
        temp.add(Racer.builder()
                .withRacerName("Lewis Hamilton")
                .withTeamName("MERCEDES")
                .withStartRace(LocalDateTime.parse("2018-05-24_12:18:20.125", formatter))
                .withEndRace(LocalDateTime.parse("2018-05-24_12:19:32.585", formatter))
                .build());
        temp.add(Racer.builder()
                .withRacerName("Stoffel Vandoorne")
                .withTeamName("MCLAREN RENAULT ")
                .withStartRace(LocalDateTime.parse("2018-05-24_12:18:37.735", formatter))
                .withEndRace(LocalDateTime.parse("2018-05-24_12:19:50.198", formatter))
                .build());
        temp.add(Racer.builder()
                .withRacerName("Kimi Raikkonen")
                .withTeamName("FERRARI")
                .withStartRace(LocalDateTime.parse("2018-05-24_12:03:01.250", formatter))
                .withEndRace(LocalDateTime.parse("2018-05-24_12:04:13.889", formatter))
                .build());
        temp.add(Racer.builder()
                .withRacerName("Fernando Alonso")
                .withTeamName("MCLAREN RENAULT")
                .withStartRace(LocalDateTime.parse("2018-05-24_12:13:04.512", formatter))
                .withEndRace(LocalDateTime.parse("2018-05-24_12:14:17.169", formatter))
                .build());
        temp.add(Racer.builder()
                .withRacerName("Sergey Sirotkin")
                .withTeamName("WILLIAMS MERCEDES")
                .withStartRace(LocalDateTime.parse("2018-05-24_12:16:11.648", formatter))
                .withEndRace(LocalDateTime.parse("2018-05-24_12:17:24.354", formatter))
                .build());
        temp.add(Racer.builder()
                .withRacerName("Charles Leclerc")
                .withTeamName("SAUBER FERRARI")
                .withStartRace(LocalDateTime.parse("2018-05-24_12:09:41.921", formatter))
                .withEndRace(LocalDateTime.parse("2018-05-24_12:10:54.750", formatter))
                .build());
        temp.add(Racer.builder()
                .withRacerName("Sergio Perez")
                .withTeamName("FORCE INDIA MERCEDES")
                .withStartRace(LocalDateTime.parse("2018-05-24_12:12:01.035", formatter))
                .withEndRace(LocalDateTime.parse("2018-05-24_12:13:13.883", formatter))
                .build());
        temp.add(Racer.builder()
                .withRacerName("Romain Grosjean")
                .withTeamName("HAAS FERRARI")
                .withStartRace(LocalDateTime.parse("2018-05-24_12:05:14.511", formatter))
                .withEndRace(LocalDateTime.parse("2018-05-24_12:06:27.441", formatter))
                .build());
        temp.add(Racer.builder()
                .withRacerName("Pierre Gasly")
                .withTeamName("SCUDERIA TORO ROSSO HONDA")
                .withStartRace(LocalDateTime.parse("2018-05-24_12:07:23.645", formatter))
                .withEndRace(LocalDateTime.parse("2018-05-24_12:08:36.586", formatter))
                .build());
        temp.add(Racer.builder()
                .withRacerName("Carlos Sainz")
                .withTeamName("RENAULT")
                .withStartRace(LocalDateTime.parse("2018-05-24_12:03:15.145", formatter))
                .withEndRace(LocalDateTime.parse("2018-05-24_12:04:28.095", formatter))
                .build());
        temp.add(Racer.builder()
                .withRacerName("Esteban Ocon")
                .withTeamName("FORCE INDIA MERCEDES")
                .withStartRace(LocalDateTime.parse("2018-05-24_12:17:58.810", formatter))
                .withEndRace(LocalDateTime.parse("2018-05-24_12:19:11.838", formatter))
                .build());
        temp.add(Racer.builder()
                .withRacerName("Nico Hulkenberg")
                .withTeamName("RENAULT")
                .withStartRace(LocalDateTime.parse("2018-05-24_12:02:49.914", formatter))
                .withEndRace(LocalDateTime.parse("2018-05-24_12:04:02.979", formatter))
                .build());
        temp.add(Racer.builder()
                .withRacerName("Brendon Hartley")
                .withTeamName("SCUDERIA TORO ROSSO HONDA")
                .withStartRace(LocalDateTime.parse("2018-05-24_12:14:51.985", formatter))
                .withEndRace(LocalDateTime.parse("2018-05-24_12:16:05.164", formatter))
                .build());

        String actual = provider.provideView(temp);

        assertThat(actual).isEqualTo(expected);
    }
}



