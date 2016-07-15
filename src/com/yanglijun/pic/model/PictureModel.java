package com.yanglijun.pic.model;

import java.util.List;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.yanglijun.pic.app.PictureApplication;
import com.yanglijun.pic.entity.Picture;
import com.yanglijun.pic.entity.PictureShow;
import com.yanglijun.pic.model.IModel.AsycnCallBack;
import com.yanglijun.pic.utils.UrlFactory;

public class PictureModel implements IPictureModel{
	private RequestQueue queue;
	private List<Picture>pictures;
	
	
	public PictureModel() {
		super();
		queue=PictureApplication.getQueue();
	}


	@Override
	public void LoadPicture(int id, final AsycnCallBack back) {
		String url=UrlFactory.getImageUrl(id);
		StringRequest request=new StringRequest(url,new Listener<String>() {

			@Override
			public void onResponse(String response) {
				Gson gson=new Gson();
				PictureShow pictureShow=gson.fromJson(response, PictureShow.class);
				pictures=pictureShow.getList();
				back.onSuccess(pictures);
				
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				back.onError(error.getMessage());
				
			}
		});
		queue.add(request);
	}

}
