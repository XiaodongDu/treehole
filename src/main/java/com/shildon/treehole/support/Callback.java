package com.shildon.treehole.support;

/**
 * 回调接口。
 * @author shildon<shildondu@gmail.com>
 * @date May 2, 2016
 */
public interface Callback<T> {
	
	public boolean callback(ResultMap<T> resultMap);
		
}
