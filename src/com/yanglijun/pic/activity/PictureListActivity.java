package com.yanglijun.pic.activity;

import java.util.List;

import com.yanglijun.pic.R;
import com.yanglijun.pic.adapter.PictureListAdapter;
import com.yanglijun.pic.entity.Picture;
import com.yanglijun.pic.presenter.IPicturePresenter;
import com.yanglijun.pic.presenter.PicturePresenter;
import com.yanglijun.pic.view.IPictureView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PictureListActivity extends Activity implements IPictureView {
	IPicturePresenter presenter;
	private List<Picture>pictures;
	private PictureListAdapter adapter;
	private GridView gvPicture;
	private TextView tvTitle;
	private int Id;
	private ImageView ivShare,ivReturn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_picture_list);
		presenter=new PicturePresenter(this);
		int id=getIntent().getIntExtra("ID", -1);
		this.Id =id;
		presenter.LoadPicture(id);
		String title=getIntent().getStringExtra("title");
		initView();
		setListener();
		tvTitle.setText(title);
		Toast.makeText(this, "传来的ID是："+id+"传来的title是："+title, Toast.LENGTH_LONG).show();
		
	}


	private void setListener() {
		ivReturn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				PictureListActivity.this.finish();
				
			}
		});
		
		//分享
		ivShare.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				shareText("http://www.tngou.net/tnfs/show/"+Id);
				
			}
		});
		
		
		gvPicture.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent=new Intent(PictureListActivity.this,GalleryActivity.class);
				intent.putExtra("ID", Id);
				startActivity(intent);
				
			}
		});
		
	}


	protected void shareText(String string) {
		Intent intent=new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_TEXT, string);
		startActivity(Intent.createChooser(intent, "分享到："));
		
		
	}


	private void initView() {
		gvPicture=(GridView) findViewById(R.id.gv_showPic);
		tvTitle=(TextView) findViewById(R.id.tv_title);
		ivReturn=(ImageView) findViewById(R.id.iv_return);
		ivShare=(ImageView) findViewById(R.id.iv_share);
	}


	@Override
	public void showPicture(List<Picture> pictures) {
		this.pictures=pictures;
		adapter=new PictureListAdapter(PictureListActivity.this, pictures);
		gvPicture.setAdapter(adapter);
	}

}
