package ua.com.foxminded.java8api.validator;

import java.io.File;
import java.io.FileNotFoundException;

public class ValidatorImpl implements Validator {
    private static final String THROWS_MESSAGE = "File on the path \"%s\" not found";

    @Override
    public void validate(String filename1, String filename2, String filename3) throws FileNotFoundException {
        if (filename1 == null) {
            throw new IllegalArgumentException("First argument is null");
        }

        if (filename2 == null) {
            throw new IllegalArgumentException("Second argument is null");
        }

        if (filename3 == null) {
            throw new IllegalArgumentException("Third argument is null");
        }

        if (filename1.trim().isEmpty()) {
            throw new IllegalArgumentException("First argument is empty");
        }

        if (filename2.trim().isEmpty()) {
            throw new IllegalArgumentException("Second argument is empty");
        }

        if (filename3.trim().isEmpty()) {
            throw new IllegalArgumentException("Third argument is empty");
        }

        File f = new File(filename1);

        if (!f.exists() || f.isDirectory()) {
            throw new FileNotFoundException(String.format(THROWS_MESSAGE, f.getAbsolutePath()));
        }

        File f2 = new File(filename2);

        if (!f2.exists() || f2.isDirectory()) {
            throw new FileNotFoundException(String.format(THROWS_MESSAGE, f2.getAbsolutePath()));
        }

        File f3 = new File(filename3);

        if (!f3.exists() || f3.isDirectory()) {
            throw new FileNotFoundException(String.format(THROWS_MESSAGE, f3.getAbsolutePath()));
        }
    }
}
