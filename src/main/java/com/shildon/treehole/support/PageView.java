package com.shildon.treehole.support;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date Jun 24, 2016
 */
@Service
public class PageView {
	
	private final String key = "pageviews";
	@Resource
	private RedisTemplate<String, Long> redisTemplate;
	
	public Long getPageViews() {
		return redisTemplate.opsForValue().increment(key, 1);
	}

}
