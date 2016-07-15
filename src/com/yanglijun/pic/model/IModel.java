package com.yanglijun.pic.model;

public interface IModel {
	public interface  AsycnCallBack {
		void onSuccess(Object success);
		void onError(Object error);
	}
}
