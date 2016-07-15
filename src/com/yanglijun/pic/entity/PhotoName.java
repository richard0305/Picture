package com.yanglijun.pic.entity;

public class PhotoName {
	private String description;
	private int id;
	private String  keywords;
	private String  name;
	private String  seq;
	private String  title;
	
	
	public PhotoName() {
		super();
	}


	public PhotoName(String description, int id, String keywords, String name, String seq, String title) {
		super();
		this.description = description;
		this.id = id;
		this.keywords = keywords;
		this.name = name;
		this.seq = seq;
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getKeywords() {
		return keywords;
	}


	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSeq() {
		return seq;
	}


	public void setSeq(String seq) {
		this.seq = seq;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	@Override
	public String toString() {
		return "PhotoName [description=" + description + ", id=" + id + ", keywords=" + keywords + ", name=" + name
				+ ", seq=" + seq + ", title=" + title + "]";
	}
	
	
	
}
