package org.george.config;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.boot.r2dbc.ConnectionFactoryBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
public class CacheConfig {


    public CacheManager cacheManager() {
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory();
        lettuceConnectionFactory.afterPropertiesSet();
        RedisCacheManager cacheManager = RedisCacheManager.builder()
                .cacheWriter(RedisCacheWriter.lockingRedisCacheWriter(lettuceConnectionFactory))
                .build();
        return cacheManager;
    }

}
