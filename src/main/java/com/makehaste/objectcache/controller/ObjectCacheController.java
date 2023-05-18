package com.makehaste.objectcache.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.makehaste.objectcache.entity.Unit;

@RestController
public class ObjectCacheController {
	
	@Autowired
	private RedisTemplate<String, Unit> redisTemplate;
	
	@Autowired
	private RedisKeyValueTemplate redisKVTemplate;

	@PutMapping("/put-object")
	boolean putItem(@RequestParam String unitName, @RequestParam String location) {

		Unit unit = new Unit();

		unit.setLocation(location);
		unit.setUnitName(unitName);

		//unitRepository.save(unit);
		redisKVTemplate.insert(unit.getUnitName(), unit);

		return true;
	}

	@GetMapping("/get-object")
	Unit fetchUnitTest(@RequestParam String unitName) {

		return null;
	}
	
	@GetMapping("/expire")
	boolean setExpire(@RequestParam String unitName) {
		
		Unit unit = redisTemplate.opsForValue().get(unitName);
		redisTemplate.opsForValue().set(unitName, unit, 10, TimeUnit.SECONDS);
		
		return true;
	}
}
