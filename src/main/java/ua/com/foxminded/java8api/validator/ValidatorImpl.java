package ua.com.foxminded.java8api.validator;

import java.io.File;
import java.io.FileNotFoundException;

public class ValidatorImpl implements Validator {
    private static final String THROWS_MESSAGE = "File on the path \"%s\" not found";

    @Override
    public void validate(String abbreviationsPath, String startRacePath, String endRacePath) throws FileNotFoundException {
        if (abbreviationsPath == null || startRacePath == null
                || endRacePath == null) {
            throw new IllegalArgumentException("One of the arguments is null");
        }

        if (abbreviationsPath.trim().isEmpty() || startRacePath.trim().isEmpty() || endRacePath.trim().isEmpty()) {
            throw new IllegalArgumentException("One of the arguments is empty");
        }

        File f = new File(abbreviationsPath);

        if (!f.exists() || f.isDirectory()) {
            throw new FileNotFoundException(String.format(THROWS_MESSAGE, f.getAbsolutePath()));
        }

        File f2 = new File(startRacePath);

        if (!f2.exists() || f2.isDirectory()) {
            throw new FileNotFoundException(String.format(THROWS_MESSAGE, f2.getAbsolutePath()));
        }

        File f3 = new File(endRacePath);

        if (!f3.exists() || f3.isDirectory()) {
            throw new FileNotFoundException(String.format(THROWS_MESSAGE, f3.getAbsolutePath()));
        }
    }
}
