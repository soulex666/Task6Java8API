package ua.com.foxminded.java8api.provider;

import ua.com.foxminded.java8api.domain.Racer;

import java.util.List;

public interface ViewProvider {
    String provideView(List<Racer> racers);
}
