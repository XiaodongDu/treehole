package com.shildon.treehole.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shildon.treehole.model.ResultMap;
import com.shildon.treehole.model.User;
import com.shildon.treehole.service.UserService;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date Apr 29, 2016
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/insert.do")
	@ResponseBody
	public ResultMap<User> insert(User user) {
		ResultMap<User> resultMap = new ResultMap<>();
		if (userService.insert(user)) {
			resultMap.setSuccess(true);
		} else {
			resultMap.setSuccess(false);
		}
		return resultMap;
	}
	
}
