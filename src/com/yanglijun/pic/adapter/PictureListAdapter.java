package com.yanglijun.pic.adapter;

import java.util.List;
import java.util.zip.Inflater;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.yanglijun.pic.R;
import com.yanglijun.pic.entity.Picture;
import com.yanglijun.pic.utils.UrlFactory;

import android.R.integer;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class PictureListAdapter extends BaseAdapter {

		private Context context;
		private List<Picture>pictures;
		private LayoutInflater Inflater;
		
	public PictureListAdapter(Context context, List<Picture> pictures) {
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
		ViewHolder holder=null;
		if(convertView==null){
			convertView=Inflater.inflate(R.layout.item_photo_list, null);
			holder=new ViewHolder();
			holder.ivPicture=(ImageView) convertView.findViewById(R.id.imageView1);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		Picture picture=getItem(position);
		
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.cacheInMemory(true).cacheOnDisc(true).build();
		
		String url=UrlFactory.getPhotoUrl(picture.getSrc());
		ImageLoader.getInstance().displayImage(url,holder.ivPicture,options);
		
		
		return convertView;
	}
	class ViewHolder{
		ImageView ivPicture;
	}

}
