package ua.com.foxminded.java8api.provider;

import ua.com.foxminded.java8api.domain.Racer;

import java.util.Map;

public interface ViewProvider {
    String provideView(Map<String, Racer> racers, Map<String, Long> markers);
}
