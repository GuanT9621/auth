package com.guan.sso.server.services;

import com.guan.sso.server.entity.RedisDO;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisService {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Bean
    public RedisTemplate redisTemplateInit() {
        //设置序列化Key的实例化对象
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置序列化Value的实例化对象
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }

    public void set(String key, RedisDO value, Long second) {
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        vo.set(key, value, second, TimeUnit.SECONDS);
    }

    public RedisDO get(String key) {
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        return (RedisDO) vo.get(key);
    }

    public boolean has(String key) {
        return redisTemplate.hasKey(key);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }
}
