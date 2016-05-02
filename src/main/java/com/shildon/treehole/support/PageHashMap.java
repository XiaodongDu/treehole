package com.shildon.treehole.support;

import java.util.HashMap;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date May 2, 2016
 * @param <K>
 * @param <V>
 */
public class PageHashMap extends HashMap<String, Object> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PageHashMap setBegin(int begin) {
		this.put("begin", begin);
		return this;
	}
	
	public PageHashMap setSum(int sum) {
		this.put("sum", sum);
		return this;
	}

}
