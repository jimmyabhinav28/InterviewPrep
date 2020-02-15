package dev.anksandabhi.javastuffp1;

import java.util.Comparator;

public class LRUCacheComparator<T extends CacheObject> implements Comparator<T>
{


    @Override
    public int compare(T t, T t1) {
        return t.cacheAccessTime.compareTo(t1.cacheAccessTime);
    }
}
