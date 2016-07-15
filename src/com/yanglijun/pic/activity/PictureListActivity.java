package com.yanglijun.pic.activity;

import java.util.List;

import com.yanglijun.pic.R;
import com.yanglijun.pic.adapter.PictureListAdapter;
import com.yanglijun.pic.entity.Picture;
import com.yanglijun.pic.presenter.IPicturePresenter;
import com.yanglijun.pic.presenter.PicturePresenter;
import com.yanglijun.pic.view.IPictureView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ResourceAsColor")
public class PictureListActivity extends Activity implements IPictureView {
	IPicturePresenter presenter;
	private List<Picture>pictures;
	private PictureListAdapter adapter;
//	private ListView lvPicture;
	private Gallery gallery;
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
//		Toast.makeText(this, "传来的ID是："+id+"传来的title是："+title, Toast.LENGTH_LONG).show();
		
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
		
		
		
		
		//长按显示菜单，保存图片
		gallery.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				Picture picture=pictures.get(position);
//				Toast.makeText(PictureListActivity.this, "我点击了"+position, Toast.LENGTH_LONG).show();
				AlertDialog.Builder builder=new AlertDialog.Builder(PictureListActivity.this);
				builder.setItems(new String[]{getResources().getString(R.string.save_picture)},new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						gallery.setDrawingCacheEnabled(true);
						Toast.makeText(PictureListActivity.this, "你想的真美~",Toast.LENGTH_SHORT ).show();
					}
				}) ;
				builder.show();
				return true;
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
//		lvPicture=(ListView) findViewById(R.id.iv_showPic);
		gallery=(Gallery) findViewById(R.id.iv_showPic);
		tvTitle=(TextView) findViewById(R.id.tv_title);
		ivReturn=(ImageView) findViewById(R.id.iv_return);
		ivShare=(ImageView) findViewById(R.id.iv_share);
	}


	@Override
	public void showPicture(List<Picture> pictures) {
		this.pictures=pictures;
		adapter=new PictureListAdapter(PictureListActivity.this, pictures);
//		lvPicture.setAdapter(adapter);
		gallery.setAdapter(adapter);
	}

}
