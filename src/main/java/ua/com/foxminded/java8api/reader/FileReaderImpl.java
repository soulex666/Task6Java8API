package ua.com.foxminded.java8api.reader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ua.com.foxminded.java8api.validator.FileNotFoundExceptionRuntime;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderImpl implements FileReader {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<String> readFile(String filename) {
        final Path abbr = new File(filename).toPath();
        try (Stream<String> fileStream = Files.newBufferedReader(abbr).lines()) {
            return fileStream.collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.error("Error message", e);
            throw new FileNotFoundExceptionRuntime(e.getMessage());
        }
    }
}
