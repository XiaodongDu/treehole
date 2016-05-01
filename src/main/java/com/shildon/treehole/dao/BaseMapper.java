package com.shildon.treehole.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date Apr 23, 2016
 */
public interface BaseMapper<M> {
	
	public void insert(M model);
	
	public void delete(Serializable id);
	
	public void update(M model);
	
	public M get(Serializable id);
	
	public List<M> queryBy(Map<String, Object> map);
	
	public int getTotalCount();
	
}
