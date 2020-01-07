package com.sc.redis;

import redis.clients.jedis.Jedis;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: cloud
 * @Date: 2020/1/7 17:18
 * @Version 1.0
 */
public class RedisTest {


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Jedis jedis = RedisUtil.getJedis();
        Set<String> keys = jedis.keys("*");
        Set<String> removeKeys = new HashSet<>();
        int removeKeySize = 32;
        System.out.println("key总数量:" + keys.size());
        for (String key : keys) {
            int length = key.length();
            if (length > 6 ) {
                if (!":".equals(key.substring(6,7)) && length == removeKeySize) {
                    removeKeys.add(key);
                }
            }
        }
        System.out.println("需要被移除长度的key:" + removeKeys.size());
        for (String key : removeKeys) {
            System.out.println(key + ",被移除");
            jedis.del(key);
        }
        System.out.println("移除key耗时:" + (System.currentTimeMillis() - startTime) + "ms");
        RedisUtil.returnResource();
    }

}
