package ua.com.foxminded.java8api.reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> readFile(String filename) throws IOException {
        final List<String> fileList;
        final Path abbr = new File(filename).toPath();
        try (Stream<String> fileStream = Files.newBufferedReader(abbr).lines()) {
            fileList = fileStream.collect(Collectors.toList());
        }

        return fileList;
    }
}
