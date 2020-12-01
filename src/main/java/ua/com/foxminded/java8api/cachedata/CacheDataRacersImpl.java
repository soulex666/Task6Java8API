package ua.com.foxminded.java8api.cachedata;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class CacheDataRacersImpl<K, V> implements CacheDataRacers<K, V> {
    private final Map<K, V> innerMap;

    public CacheDataRacersImpl() {
        this.innerMap = new LinkedHashMap<>();
    }

    @Override
    public V get(K key) {
        return innerMap.get(key);
    }

    @Override
    public Map<K, V> getMap() {
        return innerMap;
    }

    @Override
    public int size() {
        return innerMap.size();
    }

    @Override
    public void put(K key, V value) {
        innerMap.put(key, value);
    }

    @Override
    public void putAll(Map<K, V> map) {
        innerMap.putAll(map);
    }

    @Override
    public boolean containsKey(K sentence) {
        return innerMap.containsKey(sentence);
    }
}
