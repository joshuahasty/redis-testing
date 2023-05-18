package com.makehaste.objectcache.services;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyspaceEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

public class MyKeyListener extends KeyspaceEventMessageListener {

	public MyKeyListener(RedisMessageListenerContainer listenerContainer) {
		super(listenerContainer);
	}

	@Override
	protected void doHandleMessage(Message message) {
		System.out.println(message.toString());
	}

}
