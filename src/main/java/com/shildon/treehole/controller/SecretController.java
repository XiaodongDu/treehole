package com.shildon.treehole.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shildon.treehole.model.ResultMap;
import com.shildon.treehole.model.Secret;
import com.shildon.treehole.service.SecretService;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date Apr 29, 2016
 */
@Controller
@RequestMapping("/secret")
public class SecretController {
	
	@Resource
	private SecretService secretService;
	
	@RequestMapping("/insert.do")
	@ResponseBody
	public ResultMap<Secret> insert(Secret secret) {
		ResultMap<Secret> resultMap = new ResultMap<>();
		if (secretService.insert(secret)) {
			resultMap.setSuccess(true);
		} else {
			resultMap.setSuccess(false);
		}
		return resultMap;
	}
	
	@RequestMapping("/queryBy.do")
	@ResponseBody
	public ResultMap<Secret> queryBy(int begin, int sum) {
		ResultMap<Secret> resultMap = new ResultMap<>();
		Map<String, Object> map = new HashMap<>();
		map.put("begin", begin);
		map.put("sum", sum);
		List<Secret> secrets = secretService.queryBy(map);
		if (null != secrets) {
			resultMap.setSuccess(true).setResult(secrets);
		} else {
			resultMap.setSuccess(false);
		}
		return resultMap;
	}
	
}
