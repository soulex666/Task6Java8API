package ua.com.foxminded.java8api.provider;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface StatisticProvider {
    String provideRaceStatistics(String filename1, String filename2, String filename3) throws IOException;
}
