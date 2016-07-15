package com.yanglijun.pic.presenter;

import java.util.List;

import com.yanglijun.pic.entity.Picture;
import com.yanglijun.pic.model.IModel.AsycnCallBack;
import com.yanglijun.pic.model.IPictureModel;
import com.yanglijun.pic.model.PictureModel;
import com.yanglijun.pic.view.IPictureView;

public class PicturePresenter implements IPicturePresenter{
	private IPictureView view;
	private IPictureModel model;
	public PicturePresenter(IPictureView view) {
		super();
		this.view = view;
		model=new PictureModel();
	}
	@Override
	public void LoadPicture(int id) {
		model.LoadPicture(id, new AsycnCallBack() {
			
			@Override
			public void onSuccess(Object success) {
				List<Picture>pictures=(List<Picture>) success;
				view.showPicture(pictures);
				
			}
			
			@Override
			public void onError(Object error) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	
	
}
