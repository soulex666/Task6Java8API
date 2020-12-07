package ua.com.foxminded.java8api.provider;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface StatisticProvider {
    String provideRaceStatistics(String abbreviationsPath, String startRacePath, String endRacePath) throws IOException;
}
