package com.yanglijun.pic.adapter;

import java.util.List;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.yanglijun.pic.R;
import com.yanglijun.pic.app.PictureApplication;
import com.yanglijun.pic.entity.Classify;
import com.yanglijun.pic.entity.PhotoName;
import com.yanglijun.pic.utils.UrlFactory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PhotoNameAdapter extends BaseAdapter{
	
	private Context context;
	private List<PhotoName>photoNames;
	private LayoutInflater inflater;
	
	
	
	
	
	public PhotoNameAdapter(Context context, List<PhotoName> photoNames) {
		super();
		this.context = context;
		this.photoNames = photoNames;
		this.inflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return photoNames.size();
	}

	@Override
	public PhotoName getItem(int position) {
		return photoNames.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=null;
		if(convertView==null){
			convertView=inflater.inflate(R.layout.item_title, null);
			holder=new ViewHolder();
			holder.tvTitle=(TextView) convertView.findViewById(R.id.tvTitle);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		
		PhotoName photoName=getItem(position);
		holder.tvTitle.setText(photoName.getDescription());
		
		return convertView;
	}
	class ViewHolder{
		TextView tvTitle;
	}
}
