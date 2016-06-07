package com.shildon.treehole.support;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date Jun 7, 2016
 */
@Service
public class IPLimit {
	
	private final int limit = 3;
	
	@Resource
	private RedisTemplate<String, Long> redisTemplate;
	
	public boolean isLimit(String ip) {
		Long time = redisTemplate.opsForValue().increment(ip, 1);
		if (time > limit) {
			return true;
		} else {
			return false;
		}
	}

}
