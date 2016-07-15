package com.yanglijun.pic.entity;

import java.util.List;

public class PhotoAPI {
	private boolean status;
	private int total;
	private List<Photo>tngou;
	public PhotoAPI() {
		super();
	}
	public PhotoAPI(boolean status, int total, List<Photo> tngou) {
		super();
		this.status = status;
		this.total = total;
		this.tngou = tngou;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Photo> getTngou() {
		return tngou;
	}
	public void setTngou(List<Photo> tngou) {
		this.tngou = tngou;
	}
	@Override
	public String toString() {
		return "PhotoAPI [status=" + status + ", total=" + total + ", tngou=" + tngou + "]";
	}
	
	
}
