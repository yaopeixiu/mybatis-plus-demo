package com.ypx.mybatisplusdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

@Configuration
public class LettuceRedisConfig {
    /**
     * RedisTemplate配置  https://blog.csdn.net/lms1719/article/details/83653298
     * https://baijiahao.baidu.com/s?id=1653885983671118645&wfr=spider&for=pc
     * https://blog.csdn.net/lydms/article/details/105224210
     */
    /**
     * @Bean注解告诉Spring这个方法会返回一个对象，这个对象要注册为Spring应用上下文中的Bean
     */
    @Bean
    public RedisTemplate<String, Serializable> redisTemplate(LettuceConnectionFactory connectionFactory){
        // 配置redisTemplate
        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());//key序列化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());//value序列化
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
