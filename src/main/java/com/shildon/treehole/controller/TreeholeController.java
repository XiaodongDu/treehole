package com.shildon.treehole.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shildon.treehole.model.Treehole;
import com.shildon.treehole.service.TreeholeService;
import com.shildon.treehole.support.Callback;
import com.shildon.treehole.support.ResultMap;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date Apr 29, 2016
 */
@Controller
public class TreeholeController extends BaseController {
	
	@Resource
	private TreeholeService treeholeService;
	
	@RequestMapping("/insert.do")
	@ResponseBody
	public ResultMap<Treehole> insert(final Treehole treehole) {
		return execute(new Callback<Treehole>() {
			@Override
			public boolean callback(ResultMap<Treehole> resultMap) {
				if (treeholeService.insert(treehole)) {
					return true;
				} else {
					return false;
				}
			}
		});
	}

}
