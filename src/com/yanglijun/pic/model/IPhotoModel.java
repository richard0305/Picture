package com.yanglijun.pic.model;

import com.yanglijun.pic.model.IModel.AsycnCallBack;

public interface IPhotoModel {
	void loadPhoto(int id,int page,AsycnCallBack back);
}
