package com.shildon.treehole.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shildon.treehole.model.ResultMap;
import com.shildon.treehole.model.User;
import com.shildon.treehole.service.SecretService;
import com.shildon.treehole.service.UserService;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date Apr 23, 2016
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	@Resource
	private UserService userService;
	@Resource
	private SecretService secretService;
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	@RequestMapping(value = "/signin.do", method = RequestMethod.POST)
	@ResponseBody
	public ResultMap<User> login(String id, String password, HttpSession httpSession) {
		User user = userService.get(id);
		ResultMap<User> resultMap = new ResultMap<>();
		
		if (null != user && null != password && password.equals(user.getPassword())) {
			httpSession.setAttribute("user", user);
			resultMap.setSuccess(true).addResult(user);
		} else {
			resultMap.setSuccess(false);
		}
		return resultMap;
	}
	
	@RequestMapping("/isLogin.do")
	@ResponseBody
	public ResultMap<User> isLogin(HttpSession httpSession) {
		User user = (User) httpSession.getAttribute("user");
		ResultMap<User> resultMap = new ResultMap<>();
		
		if (null != user) {
			resultMap.setSuccess(true).addResult(user);
		} else {
			resultMap.setSuccess(false);
		}
		return resultMap;
	}
	
	@RequestMapping("/test.do")
	@ResponseBody
	public String test() {
		User user = new User();
		user.setId("6065");
		user.setUsername("shildon");
		user.setPassword("123");
		redisTemplate.opsForValue().set("name", user);
		return "ok";
	}

}
