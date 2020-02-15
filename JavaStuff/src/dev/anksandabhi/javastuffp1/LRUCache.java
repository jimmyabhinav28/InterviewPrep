package dev.anksandabhi.javastuffp1;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.TreeSet;

public class LRUCache<T extends Comparable<T>> {
    int cacheSize;

    public LRUCache(int cacheSize) {
        cache = new TreeSet<>(new LRUCacheComparator<>());
        this.cacheSize = cacheSize;
    }

    TreeSet<CacheObject<T>> cache;

    public void printCache() {
        for (CacheObject<T> cacheObject : cache) {
            System.out.println(cacheObject.toString());

        }
        System.out.println("*****************************************");
    }

    public void addToCache(CacheObject<T> cacheObject) {
        cacheObject.cacheAccessTime = LocalDateTime.now();
        if (cache.contains(cacheObject)) {
            cache.remove(cacheObject);
            cache.add(cacheObject);
            return;
        }

        System.out.println("added " + cacheObject.value.toString());
        if (cache.size() + 1 > cacheSize) {
            Iterator<CacheObject<T>> iterator = cache.iterator();
            CacheObject<T> next = iterator.next();

            System.out.println("removing " + next.value.toString());
            iterator.remove();

        }
        cache.add(cacheObject);
    }

    public void removeFromCache(CacheObject<T> cacheObject) {
        if (cache.contains(cacheObject))
            cache.remove(cacheObject);
    }
}
