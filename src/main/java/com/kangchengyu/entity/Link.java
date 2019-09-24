package com.kangchengyu.entity;
/**
*@author 康成玉
*@version 
*类功能说明
*/
public class Link {
	
	Integer id;
	String url;
	String text;
	
	public Link(String url, String text) {
		super();
		this.url = url;
		this.text = text;
	}
	
	public Link() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	

}

