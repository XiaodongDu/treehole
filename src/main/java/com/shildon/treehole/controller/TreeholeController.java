package com.shildon.treehole.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shildon.treehole.model.ResultMap;
import com.shildon.treehole.model.Treehole;
import com.shildon.treehole.service.TreeholeService;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date Apr 29, 2016
 */
@Controller
public class TreeholeController {
	
	@Resource
	private TreeholeService treeholeService;
	
	@RequestMapping("/insert.do")
	@ResponseBody
	public ResultMap<Treehole> insert(Treehole treehole) {
		ResultMap<Treehole> resultMap = new ResultMap<>();
		if (treeholeService.insert(treehole)) {
			resultMap.setSuccess(true);
		} else {
			resultMap.setSuccess(false);
		}
		return resultMap;
	}

}
