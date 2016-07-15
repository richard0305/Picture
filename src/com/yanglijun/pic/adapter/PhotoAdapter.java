package com.yanglijun.pic.adapter;

import java.util.List;
import java.util.zip.Inflater;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.yanglijun.pic.R;
import com.yanglijun.pic.entity.Photo;
import com.yanglijun.pic.utils.UrlFactory;

import android.R.integer;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PhotoAdapter extends BaseAdapter{
	private List<Photo>photos;
	private Context context;
	private LayoutInflater Inflater;
	
	
	
	public PhotoAdapter(List<Photo> photos, Context context) {
		super();
		this.photos = photos;
		this.context = context;
		this.Inflater=LayoutInflater.from(context);
		
	}

	@Override
	public int getCount() {
		
		return photos.size();
	}

	@Override
	public Photo getItem(int position) {
		return photos.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=null;
		if(convertView==null){
			convertView=Inflater.inflate(R.layout.item_photo,null);
			holder=new ViewHolder();
			holder.ivShowPhoto=(ImageView) convertView.findViewById(R.id.iv_showPhoto);
			holder.tvContent=(TextView) convertView.findViewById(R.id.tv_content);
			holder.tvCount=(TextView) convertView.findViewById(R.id.tv_count);
			
			convertView.setTag(holder);
			
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		Photo photo=getItem(position);
		
		/**
		 * 显示的图片的各种格式DisplayImageOptions 的设置：
		 */

		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.cacheInMemory(true).cacheOnDisc(true).build();
		
		String url=UrlFactory.getPhotoUrl(photo.getImg());
		ImageLoader.getInstance().displayImage(url,holder.ivShowPhoto,options);
		
		holder.tvContent.setText(photo.getTitle());
		holder.tvCount.setText(photo.getSize()+"张");
		
		return convertView;
	}
	class ViewHolder{
		TextView tvCount;
		TextView tvContent;
		ImageView ivShowPhoto;
	}

}
