package dev.anksandabhi.javastuffp1;

import java.time.LocalDateTime;

public class CacheObject<T extends Comparable<T>> implements Comparable<CacheObject<T>> {
    public CacheObject(T value) {
        this.value = value;
    }


    public T value;
    public LocalDateTime cacheAccessTime;

    @Override
    public boolean equals(Object o) {
        CacheObject<T> o1=(CacheObject<T>) o;
        return this.value.equals(o1.value);
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }


    @Override
    public int compareTo(CacheObject<T> cacheObject) {
        return this.value.compareTo(cacheObject.value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
