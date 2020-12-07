package ua.com.foxminded.java8api.validator;

import java.io.FileNotFoundException;

public interface Validator {
    void validate(String abbreviationsPath, String startRacePath,
                  String endRacePath) throws FileNotFoundException;
}
