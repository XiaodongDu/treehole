package com.shildon.treehole.controller;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	
	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	@ResponseBody
	public ResultMap<Object> handleFormUpload(final String name, final MultipartFile file) {
		return execute(new Callback<Object>() {
			@Override
			public boolean callback(ResultMap<Object> resultMap) {
				String rootPath = servletContext.getRealPath("/avatar");
				String fullPath = rootPath + "/" + name;
				File localFile = new File(fullPath);
				try (RandomAccessFile randomAccessFile = new RandomAccessFile(localFile, "rw")) {
					byte[] fileData = file.getBytes();
					randomAccessFile.write(fileData);
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}
		});
	}
	
}
