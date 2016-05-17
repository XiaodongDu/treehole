package com.shildon.treehole.vo;

import java.util.LinkedList;
import java.util.List;

import com.shildon.treehole.model.User;
import com.shildon.treehole.support.DateUtil;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date May 8, 2016
 */
public class UserVo {

	private String id;
	private String username;
	private String password;
	private String avatarPath;
	private String aboutMe;
	private String location;
	private String birthdate;
	
	public UserVo build(User user) {
		if (null != user) {
			this.setId(user.getId())
				.setUsername(user.getUsername())
				.setPassword(user.getPassword())
				.setAvatarPath(user.getAvatarPath())
				.setAboutMe(user.getAboutMe())
				.setLocation(user.getLocation())
				.setBirthdate(DateUtil.date2String(user.getBirthdate()));
		}
		return this;
	}
	
	public List<UserVo> build(List<User> users) {
		List<UserVo> userVos = new LinkedList<>();
		if (null != users) {
			for (User user : users) {
				userVos.add(new UserVo().build(user));
			}
		}
		return userVos;
	}
	
	public String getId() {
		return id;
	}
	public UserVo setId(String id) {
		this.id = id;
		return this;
	}
	public String getUsername() {
		return username;
	}
	public UserVo setUsername(String username) {
		this.username = username;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public UserVo setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getAvatarPath() {
		return avatarPath;
	}
	public UserVo setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
		return this;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public UserVo setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
		return this;
	}
	public String getLocation() {
		return location;
	}
	public UserVo setLocation(String location) {
		this.location = location;
		return this;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public UserVo setBirthdate(String birthdate) {
		this.birthdate = birthdate;
		return this;
	}
	
}
