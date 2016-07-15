package com.yanglijun.pic.entity;

public class Photo {
    private int count;
    private int fcount;
    private int galleryclass;
    private int id;
    private String img;
    private int rcount;
    private int size;
    private String time;
    private String title;
	public Photo() {
		super();
	}
	public Photo(int count, int fcount, int galleryclass, int id, String img, int rcount, int size, String time,
			String title) {
		super();
		this.count = count;
		this.fcount = fcount;
		this.galleryclass = galleryclass;
		this.id = id;
		this.img = img;
		this.rcount = rcount;
		this.size = size;
		this.time = time;
		this.title = title;
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Photo [count=" + count + ", fcount=" + fcount + ", galleryclass=" + galleryclass + ", id=" + id
				+ ", img=" + img + ", rcount=" + rcount + ", size=" + size + ", time=" + time + ", title=" + title
				+ "]";
	}
    
}
