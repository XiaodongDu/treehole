package com.shildon.treehole.vo;

import java.util.LinkedList;
import java.util.List;

import com.shildon.treehole.model.Secret;
import com.shildon.treehole.support.DateUtil;

/**
 * 
 * @author shildon<shildondu@gmail.com>
 * @date May 8, 2016
 */
public class SecretVo {

	private Long id;
	private String title;
	private String content;
	private String pubdate;
	private UserVo user;
	
	public SecretVo build(Secret secret) {
		if (null != secret) {
			this.setId(secret.getId())
				.setTitle(secret.getTitle())
				.setContent(secret.getContent())
				.setPubdate(DateUtil.date2String(secret.getPubdate()))
				.setUser(new UserVo().build(secret.getUser()));
		}
		return this;
	}
	
	public List<SecretVo> build(List<Secret> secrets) {
		List<SecretVo> secretVos = new LinkedList<>();
		if (null != secrets) {
			for (Secret secret : secrets) {
				secretVos.add(new SecretVo().build(secret));
			}
		}
		return secretVos;
	}
	
	public Long getId() {
		return id;
	}
	public SecretVo setId(Long id) {
		this.id = id;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public SecretVo setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getContent() {
		return content;
	}
	public SecretVo setContent(String content) {
		this.content = content;
		return this;
	}
	public String getPubdate() {
		return pubdate;
	}
	public SecretVo setPubdate(String pubdate) {
		this.pubdate = pubdate;
		return this;
	}
	public UserVo getUser() {
		return user;
	}
	public SecretVo setUser(UserVo user) {
		this.user = user;
		return this;
	}
	
}
