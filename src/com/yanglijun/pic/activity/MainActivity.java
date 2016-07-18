package com.yanglijun.pic.activity;

import java.util.List;

import com.nineoldandroids.view.ViewHelper;
import com.yanglijun.pic.R;
import com.yanglijun.pic.adapter.PhotoAdapter;
import com.yanglijun.pic.adapter.PhotoNameAdapter;
import com.yanglijun.pic.adapter.recyclerViewAdapter;
import com.yanglijun.pic.entity.Photo;
import com.yanglijun.pic.entity.PhotoName;
import com.yanglijun.pic.presenter.IPhotoNamePresenter;
import com.yanglijun.pic.presenter.IPhotoPresenter;
import com.yanglijun.pic.presenter.PhotoNamePresenter;
import com.yanglijun.pic.presenter.PhotoPresenter;
import com.yanglijun.pic.utils.DragLayout;
import com.yanglijun.pic.utils.DragLayout.DragListener;
import com.yanglijun.pic.view.IPhotoNameView;
import com.yanglijun.pic.view.IPhotoView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements IPhotoView,IPhotoNameView{
	DragLayout dl;
	private RecyclerView recyclerview;
	private GridView gvPic;
	private ListView lvContent;
	private ImageView ivbottom,icon;
	private  int position;
	private List<Photo>photos;
	private int page=1;
	private List<PhotoName>photoNames;
	IPhotoPresenter presenter;
	IPhotoNamePresenter photoNamePresenter;
	private PhotoAdapter adapter;
	private PhotoNameAdapter photoNameAdapter;
	private TextView tvPhotoTitle;
	private PhotoName photoName;
	private recyclerViewAdapter recyclerviewAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		presenter=new PhotoPresenter(this);
		photoNamePresenter=new PhotoNamePresenter(this);
		photoNamePresenter.loadPhotoName();
		tvPhotoTitle.setText("性感美女");
	
		presenter.loadData(position+1, page);
		
		setListener();
		
	}


	private void setListener() {
		
		dl.setDragListener(new DragListener() {
			
			@Override
			public void onOpen() {
			}
			//主界面缩小
			@Override
			public void onDrag(float percent) {
				ViewHelper.setAlpha(icon, 1 - percent);
			}
			@Override
			public void onClose() {
			}
		});
		icon.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dl.open();
			}
		});
		
		lvContent.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				MainActivity.this.position=position;
				photoName=photoNames.get(position);
				tvPhotoTitle.setText(photoName.getTitle());
				Log.i("yanglijun", "photoname----------->>>>>>>>>>>>>>>>>>>>>>>>>>"+photoName);
				presenter.loadData(position+1, page);
				
			}
		});
		
		
		
		
		gvPic.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Photo photo=photos.get(position);
				int ID=photo.getId();
				String title=photo.getTitle();
				Intent intent=new Intent(MainActivity.this, PictureListActivity.class);
				intent.putExtra("ID", ID);
				intent.putExtra("title", title);
				startActivity(intent);
				
				
			}
		});
		
		gvPic.setOnScrollListener(new OnScrollListener() {
			
			private boolean isBottom=false;

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				switch (scrollState) {
				case SCROLL_STATE_FLING:

					break;
				case SCROLL_STATE_IDLE:
					if (isBottom) {
					
						

					}
					break;
				case SCROLL_STATE_TOUCH_SCROLL:
					break;
				}

			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {

				if (firstVisibleItem + visibleItemCount == totalItemCount) {
					isBottom = true;
				} else {
					isBottom = false;
				}
			}
		});
		
	}

	

	private void initView() {
		dl=(DragLayout) findViewById(R.id.dl);
//		gvPic=(GridView) findViewById(R.id.gv_img);
		recyclerview=(RecyclerView) findViewById(R.id.recyclerview);
		lvContent=(ListView) findViewById(R.id.lv);
		icon=(ImageView) findViewById(R.id.iv_icon);
		ivbottom=(ImageView) findViewById(R.id.iv_bottom);
		tvPhotoTitle=(TextView) findViewById(R.id.tvPhotoTitle);
	}

	//图片列表
	@Override
	public void showPhoto(List<Photo> photos) {
		this.photos=photos;
		
//		adapter=new PhotoAdapter(photos, MainActivity.this);
//		recyclerview.setAdapter(adapter);
		recyclerviewAdapter=new recyclerViewAdapter(photos, this);
		recyclerview.setAdapter(recyclerviewAdapter);
		LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
		recyclerview.setLayoutManager(linearLayoutManager);
		
		
	}

	//图片类别
	@Override
	public void showPhotoName(List<PhotoName> photoNames) {
		
		this.photoNames=photoNames;
		photoNameAdapter=new PhotoNameAdapter(MainActivity.this, photoNames);
		lvContent.setAdapter(photoNameAdapter);
		
	}

}
