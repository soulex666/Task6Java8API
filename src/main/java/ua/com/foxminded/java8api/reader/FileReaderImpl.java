package ua.com.foxminded.java8api.reader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> readFile(String filename) {
        List<String> fileList = new ArrayList<>();
        final Path abbr = new File(filename).toPath();
        try (Stream<String> fileStream = Files.newBufferedReader(abbr).lines()) {
            fileList.addAll(fileStream.collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileList;
    }
}
