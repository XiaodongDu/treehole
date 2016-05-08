package com.shildon.treehole.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shildon.treehole.model.User;
import com.shildon.treehole.service.UserService;
import com.shildon.treehole.support.Callback;
import com.shildon.treehole.support.ResultMap;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date Apr 29, 2016
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/insert.do")
	@ResponseBody
	public ResultMap<User> insert(final User user) {
		return execute(new Callback<User>() {
			@Override
			public boolean callback(ResultMap<User> resultMap) {
				if (userService.insert(user)) {
					return true;
				} else {
					return false;
				}
			}
		});
	}
	
	@RequestMapping("/update.do")
	@ResponseBody
	public ResultMap<User> update(final User user) {
		return execute(new Callback<User>() {
			@Override
			public boolean callback(ResultMap<User> resultMap) {
				if (userService.update(user)) {
					return true;
				} else {
					return false;
				}
			}
		});
	}
	
}
