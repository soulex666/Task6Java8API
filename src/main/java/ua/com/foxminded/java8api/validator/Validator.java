package ua.com.foxminded.java8api.validator;

import java.io.FileNotFoundException;

public interface Validator {
    void validate(String filename1, String filename2, String filename3) throws FileNotFoundException;
}
