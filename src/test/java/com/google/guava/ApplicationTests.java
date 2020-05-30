package com.google.guava;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class ApplicationTests {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    /*@Autowired
    KafkaProducer KafkaProducer;*/

    @Test
    public void testRedisLettuce() {
        String str = "";
        //redisTemplate.opsForValue().set("redis:lettuce", "test-redis5");
        str += "|";
        str += redisTemplate.opsForValue().get("lettuce:info");
        System.out.printf(str);
    }


}
