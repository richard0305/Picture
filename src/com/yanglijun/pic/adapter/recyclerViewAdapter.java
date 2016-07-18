package com.yanglijun.pic.adapter;

import java.util.List;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.yanglijun.pic.R;
import com.yanglijun.pic.adapter.recyclerViewAdapter.MyViewHolder;
import com.yanglijun.pic.entity.Photo;
import com.yanglijun.pic.utils.UrlFactory;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class recyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder>{

	private List<Photo>photos;
	private Context context;
	private LayoutInflater Inflater;
	
	
	
	public recyclerViewAdapter(List<Photo> photos, Context context) {
		super();
		this.photos = photos;
		this.context = context;
		this.Inflater=LayoutInflater.from(context);
		
	}
	
	
	

	@Override
	public int getItemCount() {
		return photos.size();
	}

	@Override
	public void onBindViewHolder(MyViewHolder holder, int pos) {
//		holder.tv
		Photo photo=photos.get(pos);
		/**
		 * 显示的图片的各种格式DisplayImageOptions 的设置：
		 */

		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.cacheInMemory(true).cacheOnDisc(true).build();
		
		String url=UrlFactory.getPhotoUrl(photo.getImg());
		ImageLoader.getInstance().displayImage(url,holder.ivShowPhoto,options);
		
		holder.tvContent.setText(photo.getTitle());
		holder.tvCount.setText(photo.getSize()+"张");
		
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		View view=Inflater.inflate(R.layout.item_photo,null);
		MyViewHolder holder=new MyViewHolder(arg0);
		return null;
	}

	
	class MyViewHolder extends ViewHolder{
		TextView tvCount;
		TextView tvContent;
		ImageView ivShowPhoto;
		
		
		public MyViewHolder(View itemView) {
			super(itemView);
			tvContent=(TextView) itemView.findViewById(R.id.tv_content);
			tvCount=(TextView) itemView.findViewById(R.id.tv_count);
			ivShowPhoto=(ImageView) itemView.findViewById(R.id.iv_showPhoto);
		}
	
		
	}


}
