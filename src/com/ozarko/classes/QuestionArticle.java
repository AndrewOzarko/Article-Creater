package com.ozarko.classes;

public class QuestionArticle implements Article {
	private BaseArticle article;
	private String question;
	
	public QuestionArticle() {
		this.article = null;
		this.question = null;
	}
	
	public QuestionArticle(BaseArticle article, String question) {
		this.article = article;
		this.question = question;
	}
	
	@Override
	public void setTitle(String title) {
		this.article.setTitle(title);
	}
	
	@Override
	public void setDescription(String description) {
		this.article.setDescription(description);
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	@Override
	public String getArticle() {
		return this.article.getArticle() + "\n\n" + this.question;
	}
	
	@Override
	public String getTitle() {
		return this.article.getTitle();
	}
	
	@Override
	public String getDescription() {
		return this.article.getDescription();
	}
	
	public String getQuestion() {
		return this.question;
	}
}
