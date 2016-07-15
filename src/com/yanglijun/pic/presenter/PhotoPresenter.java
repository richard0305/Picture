package com.yanglijun.pic.presenter;

import java.util.List;

import com.yanglijun.pic.entity.Photo;
import com.yanglijun.pic.model.IModel.AsycnCallBack;
import com.yanglijun.pic.model.IPhotoModel;
import com.yanglijun.pic.model.PhotoModel;
import com.yanglijun.pic.view.IPhotoView;

public class PhotoPresenter implements IPhotoPresenter {
	
	private IPhotoModel model;
	private IPhotoView view;
	

	public PhotoPresenter(IPhotoView view) {
		super();
		this.view = view;
		model=new PhotoModel();
	}

	@Override
	public void loadData(int id, int page) {
		model.loadPhoto(id, page, new AsycnCallBack() {
			
			@Override
			public void onSuccess(Object success) {
				List<Photo>photos=(List<Photo>) success;
				view.showPhoto(photos);
			}
			
			@Override
			public void onError(Object error) {
				
				
			}
		});
		
	}

}
