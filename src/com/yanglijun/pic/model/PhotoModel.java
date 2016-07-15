package com.yanglijun.pic.model;

import java.util.List;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.yanglijun.pic.app.PictureApplication;
import com.yanglijun.pic.entity.Photo;
import com.yanglijun.pic.entity.PhotoAPI;
import com.yanglijun.pic.model.IModel.AsycnCallBack;
import com.yanglijun.pic.utils.UrlFactory;

import android.util.Log;

public class PhotoModel implements IPhotoModel{
	private RequestQueue queue;
	private List<Photo> photos;
	public PhotoModel() {
		super();
		queue=PictureApplication.getQueue();
	}
	@Override
	public void loadPhoto(int id, int page, final AsycnCallBack back) {
		String url=UrlFactory.getFirstImageUrl(id, page);
		StringRequest request=new StringRequest(url,new  Listener<String>() {

			@Override
			public void onResponse(String response) {
				Gson gson=new Gson();
				PhotoAPI photoApi=gson.fromJson(response, PhotoAPI.class);
				photos=photoApi.getTngou();
				Log.i("yanglijun", "------------>>>>>>>>>>>>>>>>>>>>>>" + photos);
				back.onSuccess(photos);
				
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				back.onError("error---->>>>>>"+error.getMessage());
				
			}
		});
		queue.add(request);
	}
	
	
	
	
	
	
}
