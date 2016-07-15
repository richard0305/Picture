package com.yanglijun.pic.adapter;

import java.util.List;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.yanglijun.pic.R;
import com.yanglijun.pic.entity.Picture;
import com.yanglijun.pic.utils.UrlFactory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class HorizontalScrollViewAdapter extends BaseAdapter{
	private Context context;
	private List<Picture>pictures;
	private LayoutInflater Inflater;
	
	 
	public HorizontalScrollViewAdapter(Context context, List<Picture> pictures) {
		super();
		this.context = context;
		this.pictures = pictures;
		this.Inflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return pictures.size();
	}

	@Override
	public Picture getItem(int position) {
		return pictures.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = Inflater.inflate(R.layout.item_gralley_picture,null);
			viewHolder.mImg = (ImageView) convertView.findViewById(R.id.id_index_gallery_item_image);
			viewHolder.mText = (TextView) convertView.findViewById(R.id.id_index_gallery_item_text);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		Picture picture=pictures.get(position);
		
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.cacheInMemory(true).cacheOnDisc(true).build();
		
		String url=UrlFactory.getPhotoUrl(picture.getSrc());
		ImageLoader.getInstance().displayImage(url,viewHolder.mImg,options);
		viewHolder.mText.setText(picture.getId()+"");
		return convertView;
	}

	private class ViewHolder {
		ImageView mImg;
		TextView mText;
	}
	
	

}
