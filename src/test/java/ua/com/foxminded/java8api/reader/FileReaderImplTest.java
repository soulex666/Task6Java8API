package ua.com.foxminded.java8api.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.java8api.validator.FileNotFoundExceptionRuntime;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileReaderImplTest {
    private final FileReader reader = new FileReaderImpl();

    @Test
    void readFileShouldReturnCorrectResult() throws IOException {
        List<String> expected = new ArrayList<>();
        expected.add("test");
        expected.add("test1");
        expected.add("test2");
        List<String> actual = reader.readFile("src/test/resources/text file for tests.txt");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void readFileShouldThrowFileNotFoundExceptionRuntimeIfArgumentIsIncorrect() {
        FileNotFoundExceptionRuntime exception = assertThrows(FileNotFoundExceptionRuntime.class,
                () -> reader.readFile("mock path"));

        assertThat(exception.getClass()).isEqualTo(FileNotFoundExceptionRuntime.class);
    }
}
