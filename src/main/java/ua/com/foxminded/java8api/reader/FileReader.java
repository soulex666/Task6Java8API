package ua.com.foxminded.java8api.reader;

import java.io.IOException;
import java.util.List;

public interface FileReader {
    List<String> readFile(String filename) throws IOException;
}
