package com.yanglijun.pic.entity;

import java.util.List;

public class PictureShow {
	private int count;
	private int fcount;
	private int galleryclass;
	private int id;
	private String img;
	private List<Picture>list;
	private int rcount;
	private int size;
	private boolean status;
	private long time;
	private String title;
	private String url;
	
	
	public PictureShow() {
		super();
	}


	public PictureShow(int count, int fcount, int galleryclass, int id, String img, List<Picture> list, int rcount,
			int size, boolean status, long time, String title, String url) {
		super();
		this.count = count;
		this.fcount = fcount;
		this.galleryclass = galleryclass;
		this.id = id;
		this.img = img;
		this.list = list;
		this.rcount = rcount;
		this.size = size;
		this.status = status;
		this.time = time;
		this.title = title;
		this.url = url;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getFcount() {
		return fcount;
	}


	public void setFcount(int fcount) {
		this.fcount = fcount;
	}


	public int getGalleryclass() {
		return galleryclass;
	}


	public void setGalleryclass(int galleryclass) {
		this.galleryclass = galleryclass;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public List<Picture> getList() {
		return list;
	}


	public void setList(List<Picture> list) {
		this.list = list;
	}


	public int getRcount() {
		return rcount;
	}


	public void setRcount(int rcount) {
		this.rcount = rcount;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public long getTime() {
		return time;
	}


	public void setTime(long time) {
		this.time = time;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	@Override
	public String toString() {
		return "PictureShow [count=" + count + ", fcount=" + fcount + ", galleryclass=" + galleryclass + ", id=" + id
				+ ", img=" + img + ", rcount=" + rcount + ", size=" + size + ", status=" + status + ", time=" + time
				+ ", title=" + title + ", url=" + url + "]";
	}
	
	
	
	
	
}
