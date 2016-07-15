package com.yanglijun.pic.model;

import com.yanglijun.pic.model.IModel.AsycnCallBack;

public interface IPictureModel {
	void LoadPicture(int id,AsycnCallBack back);
}
