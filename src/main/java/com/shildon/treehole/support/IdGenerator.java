package com.shildon.treehole.support;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date May 4, 2016
 */
@Component
public class IdGenerator {
	
	@Resource
	private RedisTemplate<String, Long> redisTemplate;
	
	public Long getId(Class<?> clazz) {
		return redisTemplate.opsForValue().increment(getKey(clazz), 1);
	}
	
	public String getKey(Class<?> clazz) {
		return clazz.getSimpleName();
	}

}
