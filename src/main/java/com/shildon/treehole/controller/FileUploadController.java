package com.shildon.treehole.controller;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shildon.treehole.model.User;
import com.shildon.treehole.service.UserService;
import com.shildon.treehole.support.Callback;
import com.shildon.treehole.support.ResultMap;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date May 4, 2016
 */
@Controller
public class FileUploadController extends BaseController {
	
	@Resource
	private ServletContext servletContext;
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	@ResponseBody
	public ResultMap<User> handleFormUpload(final String id, final String name,
			final MultipartFile file, final HttpSession httpSession) {
		return execute(new Callback<User>() {
			@Override
			public boolean callback(ResultMap<User> resultMap) {
				User user = userService.get(id);
				String rootPath = servletContext.getRealPath("/avatar");
				String fullPath = rootPath + "/" + name;
				String relativePath = "avatar/" + name;
				File localFile = new File(fullPath);
				try (RandomAccessFile randomAccessFile = new RandomAccessFile(localFile, "rw")) {
					byte[] fileData = file.getBytes();
					randomAccessFile.write(fileData);
					user.setAvatarPath(relativePath);
					
					if (userService.update(user)) {
						httpSession.setAttribute("user", user);
						resultMap.addResult(user);
						return true;
					} else {
						return false;
					}
					
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
			}
		});
	}
	
}
