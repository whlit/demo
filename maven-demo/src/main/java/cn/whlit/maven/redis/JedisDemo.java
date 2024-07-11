package cn.whlit.maven.redis;

import redis.clients.jedis.Jedis;

/**
 * @author WangHaiLong 2024/3/30 15:18
 */
public class JedisDemo {


    public static void main(String[] args) {
        try(Jedis jedis = new Jedis("127.0.0.1", 6379)) {



            jedis.zadd("zset", 1, "a");
            jedis.zadd("zset", 2, "b");
            jedis.zadd("zset", 3, "c");
            double zset = jedis.zscore("zset", "a");
            System.out.println(zset);  // 1
        }

    }

}
