package ua.com.foxminded.java8api.validator;

import java.io.File;
import java.io.FileNotFoundException;

public class FilePathValidatorImpl implements FilePathValidator {

    @Override
    public void validate(String filePath) throws FileNotFoundException {
        File f = new File(filePath);

        if (!f.exists() || f.isDirectory()) {
            throw new FileNotFoundException("File not found");
        }
    }
}
