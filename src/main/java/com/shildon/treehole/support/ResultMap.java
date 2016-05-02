package com.shildon.treehole.support;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date Apr 28, 2016
 */
public class ResultMap<T> {
	private boolean success;
	private List<T> result = new LinkedList<>();
	
	public ResultMap<T> addResult(T t) {
		result.add(t);
		return this;
	}

	public boolean getSuccess() {
		return success;
	}
	public ResultMap<T> setSuccess(boolean success) {
		this.success = success;
		return this;
	}
	public List<T> getResult() {
		return result;
	}
	public ResultMap<T> setResult(List<T> result) {
		this.result = result;
		return this;
	}
}
