package com.makehaste.objectcache.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;

@Configuration
public class RedisTopicListener {
	
	//@Autowired
	//private RedisConnectionFactory connectionFactory;
	
	//private MyKeyListener listener;
		
    @Bean
    RedisMessageListenerContainer listenerContainer(RedisConnectionFactory redisConnection) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnection);

        Topic topic = new PatternTopic("__keyevent@0__:expired");

        container.addMessageListener(new RedisMessageListener(), topic);
        return container;
    }
	
}
