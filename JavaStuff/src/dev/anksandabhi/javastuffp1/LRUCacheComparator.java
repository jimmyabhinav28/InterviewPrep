package dev.anksandabhi.javastuffp1;

import java.util.Comparator;

public class LRUCacheComparator implements Comparator<CacheObject> {
    @Override
    public int compare(CacheObject obj1, CacheObject obj2) {
        return obj1.cacheAccessTime.compareTo(obj2.cacheAccessTime);
    }
}
