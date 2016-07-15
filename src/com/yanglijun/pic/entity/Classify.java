package com.yanglijun.pic.entity;

import java.util.List;

public class Classify {
	private boolean status;
	private List<PhotoName>tngou;
	public Classify() {
		super();
	}
	public Classify(boolean status, List<PhotoName> tngou) {
		super();
		this.status = status;
		this.tngou = tngou;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public List<PhotoName> getTngou() {
		return tngou;
	}
	public void setTngou(List<PhotoName> tngou) {
		this.tngou = tngou;
	}
	@Override
	public String toString() {
		return "Classify [status=" + status + ", tngou=" + tngou + "]";
	}
	
}
