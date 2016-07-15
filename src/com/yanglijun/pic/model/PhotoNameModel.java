package com.yanglijun.pic.model;

import java.util.List;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.yanglijun.pic.app.PictureApplication;
import com.yanglijun.pic.entity.Classify;
import com.yanglijun.pic.entity.PhotoName;
import com.yanglijun.pic.utils.UrlFactory;

import android.util.Log;

public class PhotoNameModel implements IPhotoNameModel{
	private RequestQueue queue;
	private List<PhotoName>photoNames;
	

	@Override
	public void loadPhotoName(final AsycnCallBack back) {
		String url=UrlFactory.getPhotoNameUrl();
		queue=PictureApplication.getQueue();
		StringRequest request=new StringRequest(url,new Listener<String>() {

			@Override
			public void onResponse(String response) {
				Gson gson=new Gson();
				Classify classify=gson.fromJson(response, Classify.class);
				photoNames=classify.getTngou();
				Log.i("yanglijun", "------------>>>>>>>>>>>>>>>>>>>>>>" + photoNames);
				back.onSuccess(photoNames);
				
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				Log.i("yanglijun ", "------------>>>>>>>>>>>>>>>>>>>>>>"+error.getMessage());
				back.onError("error---->>>>>>"+error.getMessage());
			
			}
		});
		queue.add(request);
	}

}
