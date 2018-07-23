package com.ozarko.classes;

public class BaseArticle implements Article {
	
	private String title;
	private String description;
	
	public BaseArticle() {
		this.title = null;
		this.description = null;
	}
	
	public BaseArticle(String title, String description) {
		this.title = title;
		this.description = description;
	}
	
	@Override
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String getArticle() {
		return (this.title + "\n\n" + this.description);
	}
	
	@Override
	public String getTitle() {
		return this.title;
	}
	
	@Override
	public String getDescription() {
		return this.title;
	}
}
