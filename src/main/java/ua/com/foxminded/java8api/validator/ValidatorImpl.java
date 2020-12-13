package ua.com.foxminded.java8api.validator;

import java.io.File;
import java.io.FileNotFoundException;

public class ValidatorImpl implements Validator {
    private static final String THROWS_MESSAGE = "File on the path \"%s\" not found";
    private static final String FILE_PATH_NULL_MESSAGE = "File path for file \"%s\" is null";
    private static final String FILE_PATH_EMPTY_MESSAGE = "File path for file \"%s\" is empty";

    @Override
    public void validate(String abbreviationsPath, String startRacePath, String endRacePath) {
        validateFilePath(abbreviationsPath,"file with abbreviation");
        validateFilePath(startRacePath,"file with start time");
        validateFilePath(endRacePath,"file with end time");
    }

    private void validateFilePath(String filePath, String fileRole){
        if (filePath == null) {
            throw new IllegalArgumentException(String.format(FILE_PATH_NULL_MESSAGE, fileRole));
        }

        if (filePath.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(FILE_PATH_EMPTY_MESSAGE, fileRole));
        }

        File f = new File(filePath);

        if (!f.exists() || f.isDirectory()) {
            throw new FileNotFoundExceptionRuntime(String.format(THROWS_MESSAGE, f.getAbsolutePath()));
        }
    }
}
