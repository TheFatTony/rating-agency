package com.chieftain.agency.transfer;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class NewsDto  {

	private Long id;

	private String language;

	private String imageUrl;

	private String title;

	private String shortContent;

	private String content;


	@JsonFormat(pattern = "dd/MM/yyyy")
	private Timestamp effectiveDate;


	@JsonFormat(pattern = "dd/MM/yyyy")
	private Timestamp publishDate;


	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Timestamp displayDate;

	private boolean published;

	private String author;

	protected NewsDto() {
		displayDate = publishDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getShortContent() {
		return shortContent;
	}

	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Timestamp effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Timestamp getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Timestamp publishDate) {
		this.publishDate = publishDate;
	}

	public boolean getPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Timestamp getDisplayDate() {
		return publishDate;
	}
}
