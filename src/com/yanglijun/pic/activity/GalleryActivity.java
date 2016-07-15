package com.yanglijun.pic.activity;

import java.util.List;

import com.yanglijun.pic.R;
import com.yanglijun.pic.adapter.HorizontalScrollViewAdapter;
import com.yanglijun.pic.entity.Picture;
import com.yanglijun.pic.presenter.IPicturePresenter;
import com.yanglijun.pic.presenter.PicturePresenter;
import com.yanglijun.pic.utils.MyHorizontalScrollView;
import com.yanglijun.pic.view.IPictureView;

import android.app.Activity;
import android.os.Bundle;

public class GalleryActivity extends Activity implements IPictureView {
	private List<Picture>pictures;
	private HorizontalScrollViewAdapter adapter;
	private MyHorizontalScrollView mHorizontalScrollView;
	IPicturePresenter presenter; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gallery);
		presenter=new PicturePresenter(this);
		int id=getIntent().getIntExtra("ID", -1);
		presenter.LoadPicture(id);
		initView();
	}
	private void initView() {
		mHorizontalScrollView=(MyHorizontalScrollView) findViewById(R.id.iv_horizontalScrollView);
	}
	@Override
	public void showPicture(List<Picture> pictures) {
		this.pictures=pictures;
		adapter=new HorizontalScrollViewAdapter(GalleryActivity.this, pictures);
		mHorizontalScrollView.initDatas(adapter);
	}

	
}
