package com.masivian.roulette.redisConfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.masivian.roulette.model.Roulette;

@Configuration
public class JedisConfiguration {
	@Value("${redis.serve}")
	String serve;
	@Value("${redis.port}")
	String port;
	@Bean
    LettuceConnectionFactory jedisConnectionFactory() {
		return new LettuceConnectionFactory(serve, Integer.parseInt(port));
    }
	@Bean
	RedisTemplate<String, Roulette> redisRouletteTemplate() {
		RedisTemplate<String, Roulette> redisTemplate= new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
 
}
