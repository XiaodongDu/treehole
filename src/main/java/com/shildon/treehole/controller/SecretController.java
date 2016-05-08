package com.shildon.treehole.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shildon.treehole.model.Secret;
import com.shildon.treehole.service.SecretService;
import com.shildon.treehole.support.Callback;
import com.shildon.treehole.support.IdGenerator;
import com.shildon.treehole.support.PageHashMap;
import com.shildon.treehole.support.ResultMap;
import com.shildon.treehole.vo.SecretVo;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date Apr 29, 2016
 */
@Controller
@RequestMapping("/secret")
public class SecretController extends BaseController {
	
	@Resource
	private SecretService secretService;
	@Resource
	private IdGenerator idGenerator;
	
	@RequestMapping("/insert.do")
	@ResponseBody
	public ResultMap<Secret> insert(final Secret secret) {
		return execute(new Callback<Secret>() {
			@Override
			public boolean callback(ResultMap<Secret> resultMap) {
				secret.setId(idGenerator.getId(Secret.class));
				secret.setPubdate(new Date());
				return secretService.insert(secret);
			}
		});
	}
	
	@RequestMapping("/queryBy.do")
	@ResponseBody
	public ResultMap<SecretVo> queryBy(final int begin, final int sum) {
		return execute(new Callback<SecretVo>() {
			@Override
			public boolean callback(ResultMap<SecretVo> resultMap) {
				Map<String, Object> map = new PageHashMap().
						setBegin(begin).setSum(sum);
				List<Secret> secrets = secretService.queryBy(map);
				if (null != secrets) {
					resultMap.setResult(new SecretVo().build(secrets));
					return true;
				} else {
					return false;
				}
			}
		});
	}
	
	@RequestMapping("/likePlus.do")
	@ResponseBody
	public ResultMap<Long> likePlus(final Integer id) {
		return execute(new Callback<Long>() {
			@Override
			public boolean callback(ResultMap<Long> resultMap) {
				Long num = secretService.likePlus(id);
				if (null != num) {
					resultMap.addResult(num);
					return true;
				} else {
					return false;
				}
			}
		});
	}
	
}
