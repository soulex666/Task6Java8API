package ua.com.foxminded.java8api.validator;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorImplTest {
    private static final String THROWS_MESSAGE = "File on the path \"%s\" not found";
    private static final String PATH_FOR_TESTS = "src\\test\\resources";
    private static final String FILE_PATH_NULL_MESSAGE = "File path for file \"%s\" is null";
    private static final String FILE_PATH_EMPTY_MESSAGE = "File path for file \"%s\" is empty";
    private static final String MISSING_FILE_FOR_TESTS = "src\\test\\resources\\abbreviations2.txt";
    private static final String FIRST_FILE_FOR_TESTS = "src\\test\\resources\\abbreviations.txt";
    private static final String SECOND_FILE_FOR_TESTS = "src\\test\\resources\\start.log";
    private static final String THIRD_FILE_FOR_TESTS = "src\\test\\resources\\end.log";
    private static final String EMPTY_STRING_FOR_TESTS = "";
    private static final String ABBREVIATION_ROLE = "file with abbreviation";
    private static final String START_TIME_ROLE = "file with start time";
    private static final String END_TIME_ROLE= "file with end time";


    private final Validator validator = new ValidatorImpl();

    @Test
    void validateShouldThrowIllegalArgumentExceptionIfFirstArgumentIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validate(null, SECOND_FILE_FOR_TESTS, THIRD_FILE_FOR_TESTS));

        assertThat(exception.getMessage()).isEqualTo(String.format(FILE_PATH_NULL_MESSAGE, ABBREVIATION_ROLE));
    }

    @Test
    void validateShouldThrowIllegalArgumentExceptionIfSecondArgumentIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validate(FIRST_FILE_FOR_TESTS, null, THIRD_FILE_FOR_TESTS));

        assertThat(exception.getMessage()).isEqualTo(String.format(FILE_PATH_NULL_MESSAGE, START_TIME_ROLE));
    }

    @Test
    void validateShouldThrowIllegalArgumentExceptionIfThirdArgumentIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validate(FIRST_FILE_FOR_TESTS, SECOND_FILE_FOR_TESTS, null));

        assertThat(exception.getMessage()).isEqualTo(String.format(FILE_PATH_NULL_MESSAGE, END_TIME_ROLE));
    }

    @Test
    void validateShouldThrowIllegalArgumentExceptionIfFirstArgumentIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validate(EMPTY_STRING_FOR_TESTS,
                        SECOND_FILE_FOR_TESTS,
                        THIRD_FILE_FOR_TESTS));

        assertThat(exception.getMessage()).isEqualTo(String.format(FILE_PATH_EMPTY_MESSAGE, ABBREVIATION_ROLE));
    }

    @Test
    void validateShouldThrowIllegalArgumentExceptionIfSecondArgumentIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validate(FIRST_FILE_FOR_TESTS,
                        EMPTY_STRING_FOR_TESTS,
                        THIRD_FILE_FOR_TESTS));

        assertThat(exception.getMessage()).isEqualTo(String.format(FILE_PATH_EMPTY_MESSAGE, START_TIME_ROLE));
    }

    @Test
    void validateShouldThrowIllegalArgumentExceptionIfThirdArgumentIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validate(FIRST_FILE_FOR_TESTS,
                        SECOND_FILE_FOR_TESTS,
                        EMPTY_STRING_FOR_TESTS));

        assertThat(exception.getMessage()).isEqualTo(String.format(FILE_PATH_EMPTY_MESSAGE, END_TIME_ROLE));
    }

    @Test
    void validateShouldThrowFileNotFoundExceptionRuntimeIfFirstArgumentIsDirectory() {
        File test = new File(PATH_FOR_TESTS);
        FileNotFoundExceptionRuntime exception = assertThrows(FileNotFoundExceptionRuntime.class,
                () -> validator.validate(PATH_FOR_TESTS,
                        SECOND_FILE_FOR_TESTS,
                        THIRD_FILE_FOR_TESTS));

        assertThat(exception.getMessage()).isEqualTo(String.format(THROWS_MESSAGE, test.getAbsolutePath()));
    }

    @Test
    void validateShouldThrowFileNotFoundExceptionRuntimeIfSecondArgumentIsDirectory() {
        File test = new File(PATH_FOR_TESTS);
        FileNotFoundExceptionRuntime exception = assertThrows(FileNotFoundExceptionRuntime.class,
                () -> validator.validate(FIRST_FILE_FOR_TESTS,
                        PATH_FOR_TESTS,
                        THIRD_FILE_FOR_TESTS));

        assertThat(exception.getMessage()).isEqualTo(String.format(THROWS_MESSAGE, test.getAbsolutePath()));
    }

    @Test
    void validateShouldThrowFileNotFoundExceptionRuntimeIfThirdArgumentIsDirectory() {
        File test = new File(PATH_FOR_TESTS);
        FileNotFoundExceptionRuntime exception = assertThrows(FileNotFoundExceptionRuntime.class,
                () -> validator.validate(FIRST_FILE_FOR_TESTS,
                        SECOND_FILE_FOR_TESTS,
                        PATH_FOR_TESTS));

        assertThat(exception.getMessage()).isEqualTo(String.format(THROWS_MESSAGE, test.getAbsolutePath()));
    }

    @Test
    void validateShouldThrowFileNotFoundExceptionRuntimeIfFirstArgumentDoesNotExists() {
        File test = new File(MISSING_FILE_FOR_TESTS);
        FileNotFoundExceptionRuntime exception = assertThrows(FileNotFoundExceptionRuntime.class,
                () -> validator.validate(MISSING_FILE_FOR_TESTS,
                        SECOND_FILE_FOR_TESTS,
                        THIRD_FILE_FOR_TESTS));

        assertThat(exception.getMessage()).isEqualTo(String.format(THROWS_MESSAGE, test.getAbsolutePath()));
    }

    @Test
    void validateShouldThrowFileNotFoundExceptionRuntimeIfSecondArgumentDoesNotExists() {
        File test = new File(MISSING_FILE_FOR_TESTS);
        FileNotFoundExceptionRuntime exception = assertThrows(FileNotFoundExceptionRuntime.class,
                () -> validator.validate(FIRST_FILE_FOR_TESTS,
                        MISSING_FILE_FOR_TESTS,
                        THIRD_FILE_FOR_TESTS));

        assertThat(exception.getMessage()).isEqualTo(String.format(THROWS_MESSAGE, test.getAbsolutePath()));
    }

    @Test
    void validateShouldThrowFileNotFoundExceptionRuntimeIfThirdArgumentDoesNotExists() {
        File test = new File(MISSING_FILE_FOR_TESTS);
        FileNotFoundExceptionRuntime exception = assertThrows(FileNotFoundExceptionRuntime.class,
                () -> validator.validate(FIRST_FILE_FOR_TESTS,
                        SECOND_FILE_FOR_TESTS,
                        MISSING_FILE_FOR_TESTS));

        assertThat(exception.getMessage()).isEqualTo(String.format(THROWS_MESSAGE, test.getAbsolutePath()));
    }

    @Test
    void validateShouldNotThrowIllegalArgumentExceptionRuntimeIfArgumentsQualifiedParameters() {
        assertDoesNotThrow(() -> validator.validate(FIRST_FILE_FOR_TESTS,
                SECOND_FILE_FOR_TESTS,
                THIRD_FILE_FOR_TESTS));
    }
}
