package ua.com.foxminded.java8api.reader;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import ua.com.foxminded.java8api.validator.FileNotFoundExceptionRuntime;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderImpl implements FileReader {
    private static final Logger LOGGER = Logger.getLogger(FileReaderImpl.class.getName());

    @Override
    public List<String> readFile(String filename) {
        LOGGER.addHandler(new ConsoleHandler());
        final Path abbr = new File(filename).toPath();
        try (Stream<String> fileStream = Files.newBufferedReader(abbr).lines()) {
            return fileStream.collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.log(Level.WARNING,e.getMessage(), e);
            throw new FileNotFoundExceptionRuntime(e.getMessage());
        }
    }
}
