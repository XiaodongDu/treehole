package com.shildon.treehole.service;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.shildon.treehole.dao.SecretMapper;
import com.shildon.treehole.model.Secret;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date Apr 28, 2016
 */
@Service
public class SecretService extends BaseService<Secret, SecretMapper> {
	
	@Resource
	private RedisTemplate<Serializable, Long> redisTemplate;
	
	public Long likePlus(Serializable id) {
		return redisTemplate.opsForValue().increment(id.toString(), 1);
	}

}
