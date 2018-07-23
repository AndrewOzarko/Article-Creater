package com.ozarko.classes;

public class DateArticle implements Article {
	
	private BaseArticle article;
	private String date;
	
	
	public DateArticle() {
		this.article = null;
		this.date = null;
	}
	 	
	public DateArticle(BaseArticle article, String date) {
		this.article = article;
		this.date = date;
	}
	
	@Override
	public void setTitle(String title) {
		this.article.setTitle(title);
	}
	
	@Override
	public void setDescription(String description) {
		this.article.setDescription(description);
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String getArticle() {
		return this.article.getArticle()  + "\n\n" + this.date;
	}
	
	@Override
	public String getTitle() {
		return this.article.getTitle();
	}
	
	@Override
	public String getDescription() {
		return this.article.getDescription();
	}
	
	public String getDate() {
		return this.date;
	}
}
