package com.shildon.treehole.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date Apr 22, 2016
 */
public class User {
	
	private String id;
	private String username;
	private String password;
	private String avatarPath = "static/brand.png";
	private String aboutMe;
	private String location;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthdate;
	private Treehole treehole;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public Treehole getTreehole() {
		return treehole;
	}
	public void setTreehole(Treehole treehole) {
		this.treehole = treehole;
	}
	public String getAvatarPath() {
		return avatarPath;
	}
	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}
}
