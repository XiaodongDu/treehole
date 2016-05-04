package com.shildon.treehole.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date Apr 24, 2016
 */
public class Secret {

	private Integer id;
	private String title;
	private String content;
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date pubdate;
	private User user;
	private Treehole treehole;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Treehole getTreehole() {
		return treehole;
	}
	public void setTreehole(Treehole treehole) {
		this.treehole = treehole;
	}

}
