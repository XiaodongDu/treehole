package com.shildon.treehole.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shildon.treehole.model.User;
import com.shildon.treehole.service.UserService;
import com.shildon.treehole.support.Callback;
import com.shildon.treehole.support.IPLimit;
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
	@Resource
	private IPLimit ipLimitService;
	
	@RequestMapping("/insert.do")
	@ResponseBody
	public ResultMap<User> insert(final HttpSession httpSession,
			final HttpServletRequest request, final User user) {
		return execute(new Callback<User>() {
			@Override
			public boolean callback(ResultMap<User> resultMap) {
				String ip = getRemoteRealAddr(request);
				boolean isLimit = ipLimitService.isLimit(ip);
				if (!isLimit) {
					if (userService.insert(user)) {
						httpSession.setAttribute("user", user);
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		});
	}
	
	@RequestMapping("/update.do")
	@ResponseBody
	public ResultMap<User> update(final User user, final HttpSession httpSession) {
		return execute(new Callback<User>() {
			@Override
			public boolean callback(ResultMap<User> resultMap) {
				if (userService.update(user)) {
					httpSession.setAttribute("user", user);
					return true;
				} else {
					return false;
				}
			}
		});
	}
	
	private String getRemoteRealAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarder-for");
		if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
}
