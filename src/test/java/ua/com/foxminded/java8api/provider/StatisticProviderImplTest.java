package ua.com.foxminded.java8api.provider;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ua.com.foxminded.java8api.domain.Racer;
import ua.com.foxminded.java8api.parser.Parser;
import ua.com.foxminded.java8api.reader.FileReader;
import ua.com.foxminded.java8api.validator.Validator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class StatisticProviderImplTest {

    @Mock
    private Validator validator;

    @Mock
    private FileReader fileReader;

    @Mock
    private Parser parser;

    @Mock
    private ViewProvider viewProvider;

    @InjectMocks
    private StatisticProviderImpl statisticProvider;

    @Test
    void provideRaceStatisticsShouldReturnExceptionWhenValidatorThrowsException() throws FileNotFoundException {
        doThrow(IllegalArgumentException.class).when(validator).validate(null, null, null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> statisticProvider.provideRaceStatistics(null, null, null));

        assertThat(IllegalArgumentException.class).isEqualTo(exception.getClass());

        verify(validator).validate(null, null, null);
        verifyNoMoreInteractions(fileReader, parser, viewProvider);
    }

    @Test
    void provideRaceStatisticsShouldPassAllStages() throws IOException {
        String fileName = "test";
        List<String> mockList = new ArrayList<>();
        List<Racer> mockRacerList = new ArrayList<>();
        String mockResult = "testResult";

        when(fileReader.readFile(fileName)).thenReturn(mockList);
        when(parser.parseToRacers(mockList, mockList, mockList)).thenReturn(mockRacerList);
        when(viewProvider.provideView(mockRacerList)).thenReturn(mockResult);

        assertThat(mockResult).isEqualTo(statisticProvider.provideRaceStatistics(fileName, fileName, fileName));

        verify(validator).validate(fileName, fileName, fileName);
        verify(fileReader, times(3)).readFile(fileName);
        verify(parser).parseToRacers(mockList, mockList, mockList);
        verify(viewProvider).provideView(mockRacerList);
    }
}
