package ua.com.foxminded.java8api.cachedata;

import java.util.LinkedHashMap;
import java.util.Map;

public interface CacheDataRacers<K, V> {
    V get(K key);

    Map<K, V> getMap();

    int size();

    void put(K key, V value);

    void putAll(Map <K, V> map);

    boolean containsKey(K sentence);
}
