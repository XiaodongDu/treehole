package com.shildon.treehole.model;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date Apr 24, 2016
 */
public class Treehole {

	private Long id;
	private String about;
	private User user;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
