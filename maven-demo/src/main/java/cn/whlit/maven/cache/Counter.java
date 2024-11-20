package cn.whlit.maven.cache;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author WangHaiLong 2024/11/20 11:07
 */
public class Counter<T> {

    private final Map<T, Count> map = new ConcurrentHashMap<>();
    private static final ScheduledThreadPoolExecutor poolExecutor = new ScheduledThreadPoolExecutor(1);

    public Counter(long expireTime) {
        poolExecutor.scheduleAtFixedRate(() -> map.keySet().forEach(k -> {
            if(System.currentTimeMillis() - map.get(k).time > expireTime) map.remove(k);
        }), 2, 2, TimeUnit.HOURS);
    }

    public int incrementAndGet(T t) {
        return map.computeIfAbsent(t, k -> new Count()).count.incrementAndGet();
    }

    static class Count {
        private final AtomicInteger count = new AtomicInteger();
        private final long time = System.currentTimeMillis();
    }

}
