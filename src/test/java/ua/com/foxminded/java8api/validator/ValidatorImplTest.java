package ua.com.foxminded.java8api.validator;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorImplTest {
    private static final String THROWS_MESSAGE = "File on the path \"%s\" not found";
    private static final String PATH_FOR_TESTS = "src\\test\\resources";
    private static final String MISSING_FILE_FOR_TESTS = "src\\test\\resources\\abbreviations2.txt";
    private static final String FIRST_FILE_FOR_TESTS = "src\\test\\resources\\abbreviations.txt";
    private static final String SECOND_FILE_FOR_TESTS = "src\\test\\resources\\start.log";
    private static final String THIRD_FILE_FOR_TESTS = "src\\test\\resources\\end.log";
    private static final String EMPTY_STRING_FOR_TESTS = "";

    private final Validator validator = new ValidatorImpl();

    @Test
    void validateShouldThrowIllegalArgumentExceptionIfFirstArgumentIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validate(null, SECOND_FILE_FOR_TESTS, THIRD_FILE_FOR_TESTS));

        assertThat(exception.getMessage()).isEqualTo("One of the arguments is null");
    }

    @Test
    void validateShouldThrowIllegalArgumentExceptionIfSecondArgumentIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validate(FIRST_FILE_FOR_TESTS, null, THIRD_FILE_FOR_TESTS));

        assertThat(exception.getMessage()).isEqualTo("One of the arguments is null");
    }

    @Test
    void validateShouldThrowIllegalArgumentExceptionIfThirdArgumentIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validate(FIRST_FILE_FOR_TESTS, SECOND_FILE_FOR_TESTS, null));

        assertThat(exception.getMessage()).isEqualTo("One of the arguments is null");
    }

    @Test
    void validateShouldThrowIllegalArgumentExceptionIfFirstArgumentIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validate(EMPTY_STRING_FOR_TESTS,
                        SECOND_FILE_FOR_TESTS,
                        THIRD_FILE_FOR_TESTS));

        assertThat(exception.getMessage()).isEqualTo("One of the arguments is empty");
    }

    @Test
    void validateShouldThrowIllegalArgumentExceptionIfSecondArgumentIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validate(FIRST_FILE_FOR_TESTS,
                        EMPTY_STRING_FOR_TESTS,
                        THIRD_FILE_FOR_TESTS));

        assertThat(exception.getMessage()).isEqualTo("One of the arguments is empty");
    }

    @Test
    void validateShouldThrowIllegalArgumentExceptionIfThirdArgumentIsEmpty() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> validator.validate(FIRST_FILE_FOR_TESTS,
                        SECOND_FILE_FOR_TESTS,
                        EMPTY_STRING_FOR_TESTS));

        assertThat(exception.getMessage()).isEqualTo("One of the arguments is empty");
    }

    @Test
    void validateShouldThrowFileNotFoundExceptionIfFirstArgumentIsDirectory() {
        File test = new File(PATH_FOR_TESTS);
        FileNotFoundException exception = assertThrows(FileNotFoundException.class,
                () -> validator.validate(PATH_FOR_TESTS,
                        SECOND_FILE_FOR_TESTS,
                        THIRD_FILE_FOR_TESTS));

        assertThat(exception.getMessage()).isEqualTo(String.format(THROWS_MESSAGE, test.getAbsolutePath()));
    }

    @Test
    void validateShouldThrowFileNotFoundExceptionIfSecondArgumentIsDirectory() {
        File test = new File(PATH_FOR_TESTS);
        FileNotFoundException exception = assertThrows(FileNotFoundException.class,
                () -> validator.validate(FIRST_FILE_FOR_TESTS,
                        PATH_FOR_TESTS,
                        THIRD_FILE_FOR_TESTS));

        assertThat(exception.getMessage()).isEqualTo(String.format(THROWS_MESSAGE, test.getAbsolutePath()));
    }

    @Test
    void validateShouldThrowFileNotFoundExceptionIfThirdArgumentIsDirectory() {
        File test = new File(PATH_FOR_TESTS);
        FileNotFoundException exception = assertThrows(FileNotFoundException.class,
                () -> validator.validate(FIRST_FILE_FOR_TESTS,
                        SECOND_FILE_FOR_TESTS,
                        PATH_FOR_TESTS));

        assertThat(exception.getMessage()).isEqualTo(String.format(THROWS_MESSAGE, test.getAbsolutePath()));
    }

    @Test
    void validateShouldThrowFileNotFoundExceptionIfFirstArgumentDoesNotExists() {
        File test = new File(MISSING_FILE_FOR_TESTS);
        FileNotFoundException exception = assertThrows(FileNotFoundException.class,
                () -> validator.validate(MISSING_FILE_FOR_TESTS,
                        SECOND_FILE_FOR_TESTS,
                        THIRD_FILE_FOR_TESTS));

        assertThat(exception.getMessage()).isEqualTo(String.format(THROWS_MESSAGE, test.getAbsolutePath()));
    }

    @Test
    void validateShouldThrowFileNotFoundExceptionIfSecondArgumentDoesNotExists() {
        File test = new File(MISSING_FILE_FOR_TESTS);
        FileNotFoundException exception = assertThrows(FileNotFoundException.class,
                () -> validator.validate(FIRST_FILE_FOR_TESTS,
                        MISSING_FILE_FOR_TESTS,
                        THIRD_FILE_FOR_TESTS));

        assertThat(exception.getMessage()).isEqualTo(String.format(THROWS_MESSAGE, test.getAbsolutePath()));
    }

    @Test
    void validateShouldThrowFileNotFoundExceptionIfThirdArgumentDoesNotExists() {
        File test = new File(MISSING_FILE_FOR_TESTS);
        FileNotFoundException exception = assertThrows(FileNotFoundException.class,
                () -> validator.validate(FIRST_FILE_FOR_TESTS,
                        SECOND_FILE_FOR_TESTS,
                        MISSING_FILE_FOR_TESTS));

        assertThat(exception.getMessage()).isEqualTo(String.format(THROWS_MESSAGE, test.getAbsolutePath()));
    }

    @Test
    void validateShouldNotThrowIllegalArgumentExceptionIfArgumentsQualifiedParameters() {
        assertDoesNotThrow(() -> validator.validate(FIRST_FILE_FOR_TESTS,
                SECOND_FILE_FOR_TESTS,
                THIRD_FILE_FOR_TESTS));
    }
}
