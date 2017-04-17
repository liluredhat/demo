package com.hnisi.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTest {

	public static void main(String[] args) {
		//
		Jedis jedis = new Jedis("127.0.0.1");
		//JedisPoolConfig
		jedis.set("key", "value");
		System.out.println("end");
	}
}
