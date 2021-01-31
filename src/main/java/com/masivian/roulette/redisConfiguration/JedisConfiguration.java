package com.masivian.roulette.redisConfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class JedisConfiguration {
	@Value("${redis.serve}")
	String serve;
	@Value("${redis.port}")
	Integer port;
	@Bean
    LettuceConnectionFactory jedisConnectionFactory() {
		return new LettuceConnectionFactory(serve, port);
    }
	@SuppressWarnings("rawtypes")
	@Bean
	RedisTemplate redisRouletteTemplate() {
		RedisTemplate redisTemplate= new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
 
}
