package com.yanglijun.pic.presenter;

import java.util.List;

import com.yanglijun.pic.entity.PhotoName;
import com.yanglijun.pic.model.IModel.AsycnCallBack;
import com.yanglijun.pic.model.IPhotoNameModel;
import com.yanglijun.pic.model.PhotoNameModel;
import com.yanglijun.pic.view.IPhotoNameView;

public class PhotoNamePresenter implements IPhotoNamePresenter{

	
	private IPhotoNameModel model;
	private IPhotoNameView view;
	
	
	public PhotoNamePresenter(IPhotoNameView view) {
		super();
		this.view = view;
		model=new PhotoNameModel();
	}


	@Override
	public void loadPhotoName() {
		model.loadPhotoName(new AsycnCallBack() {
			
			@Override
			public void onSuccess(Object success) {
				List<PhotoName>photoNames=(List<PhotoName>) success;
				
				view.showPhotoName(photoNames);
				
			}
			
			@Override
			public void onError(Object error) {
				
			}
		});
		
	}

}
