package dev.anksandabhi;

import dev.anksandabhi.javastuffp1.CacheObject;
import dev.anksandabhi.javastuffp1.LRUCache;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        testLRUCache();
    }

    public static void testLRUCache() throws InterruptedException {
        LRUCache<String> lruCache = new LRUCache<>(5);
        CacheObject<String> cacheObject1 = new CacheObject<>("o1");
        CacheObject<String> cacheObject2 = new CacheObject<>("o2");
        CacheObject<String> cacheObject3 = new CacheObject<>("o3");
        CacheObject<String> cacheObject4 = new CacheObject<>("o4");
        CacheObject<String> cacheObject5 = new CacheObject<>("o5");
        CacheObject<String> cacheObject6 = new CacheObject<>("o6");

        lruCache.addToCache(cacheObject1);
        Thread.sleep(1000);
        lruCache.addToCache(cacheObject2);
        Thread.sleep(1000);
        lruCache.addToCache(cacheObject3);
        Thread.sleep(1000);
        lruCache.addToCache(cacheObject4);
        Thread.sleep(1000);
        lruCache.addToCache(cacheObject5);
        Thread.sleep(1000);
        lruCache.addToCache(cacheObject6);

        lruCache.printCache();
        Thread.sleep(1000);
        lruCache.addToCache(cacheObject1);
        Thread.sleep(1000);
        lruCache.addToCache(cacheObject1);
        Thread.sleep(1000);
        lruCache.addToCache(cacheObject2);

        lruCache.printCache();

    }
}
