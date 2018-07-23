package com.ozarko.classes;

public class DateAndQuestionArticle implements Article {
	private DateArticle dateArticle;
	private QuestionArticle questionArticle;
	
	public DateAndQuestionArticle(DateArticle dateArticle, QuestionArticle questionArticle) {
		this.dateArticle = dateArticle;
		this.questionArticle = questionArticle;
	}
	
	@Override
	public void setTitle(String title) {
		this.questionArticle.setTitle(title);
	}
	
	@Override
	public void setDescription(String description) {
		this.questionArticle.setDescription(description);
	}
	
	public void setDate(String date) {
		this.dateArticle.setDate(date);
	}
	
	
	public void setQuestion(String question) {
		this.questionArticle.setQuestion(question);
	}
	
	@Override
	public String getArticle() {
		return this.questionArticle.getArticle() + "\n\n" + this.dateArticle.getDate();
	}
	
	@Override
	public String getTitle() {
		return this.questionArticle.getTitle();
	}
	
	@Override
	public String getDescription() {
		return this.questionArticle.getDescription();
	}
	
	public String getDate() {
		return this.dateArticle.getDate();
	}
	
	public String getQuestion() {
		return this.questionArticle.getQuestion();
	}
}
