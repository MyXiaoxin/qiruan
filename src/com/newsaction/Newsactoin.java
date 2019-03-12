package com.newsaction;

import java.nio.file.attribute.UserPrincipalLookupService;

import com.opensymphony.xwork2.ActionSupport;

public class Newsactoin extends ActionSupport{

	private String title;
	private String time;
	private String content;
	
	public String News() {
		
		System.out.println("title------------->"+title);
		System.out.println("time-------------->"+time);
		System.out.println("content-------------->"+content);
		
		
		
		return null;
	}
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
