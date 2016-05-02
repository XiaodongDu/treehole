package com.shildon.treehole.controller;

import com.shildon.treehole.support.Callback;
import com.shildon.treehole.support.ResultMap;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date May 2, 2016
 */
public class BaseController {
	
	public <T> ResultMap<T> execute(Callback<T> callback) {
		ResultMap<T> resultMap = new ResultMap<>();
		boolean result = callback.callback(resultMap);
		if (result) {
			resultMap.setSuccess(true);
		} else {
			resultMap.setSuccess(false);
		}
		return resultMap;
	}
	
}
