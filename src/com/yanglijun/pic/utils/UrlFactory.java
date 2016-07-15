package com.yanglijun.pic.utils;

public class UrlFactory {
	public static String getFirstImageUrl(int id,int page){
		String path="http://www.tngou.net/tnfs/api/list?id="+id+"&page="+page;
		return path;
		
	}
	public static String getPhotoUrl(String url){
		String path="http://tnfs.tngou.net/image"+url;
		return path;
	}
	
	public static String getPhotoNameUrl(){
		String path="http://www.tngou.net/tnfs/api/classify";
		return path;
		
	}
	
	public static String getImageUrl(int id){
		String path="http://www.tngou.net/tnfs/api/show?id="+id;
		return path;
	}
	
}
