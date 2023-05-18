package com.makehaste.objectcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.RedisKeyValueAdapter;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

@SpringBootApplication
@EnableRedisRepositories(enableKeyspaceEvents =
	RedisKeyValueAdapter.EnableKeyspaceEvents.ON_STARTUP)
public class ObjectCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObjectCacheApplication.class, args);
	}
	
	@Bean
	RedisConnectionFactory connectionFactory() {
		return new LettuceConnectionFactory();
	}
	
	@Bean
	RedisTemplate<? , ?> redisTemplate(RedisConnectionFactory connectionFactory) {
		
		RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
		
		template.setConnectionFactory(connectionFactory);
		template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
		
		return template;
	}
	
}
