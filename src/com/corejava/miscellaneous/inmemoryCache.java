package com.corejava.miscellaneous;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Ashutosh
 */
public class inmemoryCache<K,V> {
    private long timeToLive = 1000L;
    private ConcurrentHashMap<K,CacheObject> inmemoryCacheMap;
    
    private class CacheObject{
        long lastAccsessTime = System.currentTimeMillis();
        V value;

        public CacheObject(V value) {
            this.value = value;
        }
    }
    public inmemoryCache(long timeToLive,final long timeInterval,int maxSize){
    this.timeToLive = timeToLive * 1000;
    inmemoryCacheMap = new ConcurrentHashMap<>(maxSize);
        if(timeToLive > 0 && timeInterval > 0){
            Thread thread = new Thread(new Runnable(){
                @Override
                public void run(){
                    try{
                        Thread.sleep(timeInterval * 1000);
                    }catch(InterruptedException ie){
                    }
                }
            });
            thread.setDaemon(true);
            thread.start();
        }
    }
    public void put(K key, V value){
        CacheObject c = new CacheObject(value);
            inmemoryCacheMap.put(key, c);
    }
    public V get(K key){
        if(inmemoryCacheMap.containsKey(key)){
        CacheObject c = (CacheObject) inmemoryCacheMap.get(key);
        if(c == null)
                return null;
        return c.value;
        }
        return null;
    }
    public void remove(K key){
            inmemoryCacheMap.remove(key);
    }
    public int size(){
        return inmemoryCacheMap.size();
    }
    public void cleanup(){
        long now = System.currentTimeMillis();
        for(K key : inmemoryCacheMap.keySet()){
            CacheObject c =   (CacheObject) inmemoryCacheMap.get(key);
            if(now > (timeToLive + c.lastAccsessTime)){
                System.out.println("Removing "+key);
                inmemoryCacheMap.remove(key);
            }
        }
    }
}

class InmemoryCacheTest {

    public static void main(String[] args) {
        inmemoryCache<String, String> cache = new inmemoryCache<>(200, 500, 6);
        cache.put("eBay", "eBay");
        cache.put("Paypal", "Paypal");
        cache.put("Google", "Google");
        cache.put("Microsoft", "Microsoft");
        cache.put("IBM", "IBM");
        cache.put("Facebook", "Facebook");

        System.out.println("6 Cache Object Added.. cache.size(): " + cache.size());
        cache.remove("IBM");
        System.out.println("One object removed.. cache.size(): " + cache.size());

        cache.put("Twitter", "Twitter");
        cache.put("SAP", "SAP");
        System.out.println("Two objects Added but reached maxItems.. cache.size(): " + cache.size());
        cache.cleanup();

        /**
         * *
         * Testing cleanup time of cache Test with timeToLiveInSeconds = 100
         * seconds timerIntervalInSeconds = 100 seconds maxItems = 500000
         */
        int size = 500000;
        cache = new inmemoryCache<String, String>(100, 100, size);

        for (int i = 0; i < size; i++) {
            String value = Integer.toString(i);
            cache.put(value, value);
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long start = System.currentTimeMillis();
        cache.cleanup();
        double finish = (double) (System.currentTimeMillis() - start) / 1000.0;

        System.out.println("Cleanup times for " + size + " objects are " + finish + " s");

    }
}