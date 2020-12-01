package ua.com.foxminded.java8api.validator;

import java.io.FileNotFoundException;

public interface FilePathValidator {
    void validate(String filePath) throws FileNotFoundException;
}
