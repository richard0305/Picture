package com.yanglijun.pic.utils;

import java.util.HashMap;
import java.util.Map;

import com.yanglijun.pic.adapter.HorizontalScrollViewAdapter;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class MyHorizontalScrollView extends HorizontalScrollView implements
		OnClickListener
{

	/**
	 * 鍥剧墖婊氬姩鏃剁殑鍥炶皟鎺ュ彛
	 * 
	 * @author zhy
	 * 
	 */
	public interface CurrentImageChangeListener
	{
		void onCurrentImgChanged(int position, View viewIndicator);
	}

	/**
	 * 鏉＄洰鐐瑰嚮鏃剁殑鍥炶皟
	 * 
	 * @author zhy
	 * 
	 */
	public interface OnItemClickListener
	{
		void onClick(View view, int pos);
	}

	private CurrentImageChangeListener mListener;

	private OnItemClickListener mOnClickListener;

	private static final String TAG = "MyHorizontalScrollView";

	/**
	 * HorizontalListView涓殑LinearLayout
	 */
	private LinearLayout mContainer;

	/**
	 * 瀛愬厓绱犵殑瀹藉害
	 */
	private int mChildWidth;
	/**
	 * 瀛愬厓绱犵殑楂樺害
	 */
	private int mChildHeight;
	/**
	 * 褰撳墠鏈�鍚庝竴寮犲浘鐗囩殑index
	 */
	private int mCurrentIndex;
	/**
	 * 褰撳墠绗竴寮犲浘鐗囩殑涓嬫爣
	 */
	private int mFristIndex;
	/**
	 * 褰撳墠绗竴涓猇iew
	 */
	private View mFirstView;
	/**
	 * 鏁版嵁閫傞厤鍣�
	 */
	private HorizontalScrollViewAdapter mAdapter;
	/**
	 * 姣忓睆骞曟渶澶氭樉绀虹殑涓暟
	 */
	private int mCountOneScreen;
	/**
	 * 灞忓箷鐨勫搴�
	 */
	private int mScreenWitdh;


	/**
	 * 淇濆瓨View涓庝綅缃殑閿�煎
	 */
	private Map<View, Integer> mViewPos = new HashMap<View, Integer>();

	public MyHorizontalScrollView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		// 鑾峰緱灞忓箷瀹藉害
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		mScreenWitdh = outMetrics.widthPixels;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		mContainer = (LinearLayout) getChildAt(0);
	}

	/**
	 * 鍔犺浇涓嬩竴寮犲浘鐗�
	 */
	protected void loadNextImg()
	{
		// 鏁扮粍杈圭晫鍊艰绠�
		if (mCurrentIndex == mAdapter.getCount() - 1)
		{
			return;
		}
		//绉婚櫎绗竴寮犲浘鐗囷紝涓斿皢姘村钩婊氬姩浣嶇疆缃�0
		scrollTo(0, 0);
		mViewPos.remove(mContainer.getChildAt(0));
		mContainer.removeViewAt(0);
		
		//鑾峰彇涓嬩竴寮犲浘鐗囷紝骞朵笖璁剧疆onclick浜嬩欢锛屼笖鍔犲叆瀹瑰櫒涓�
		View view = mAdapter.getView(++mCurrentIndex, null, mContainer);
		view.setOnClickListener(this);
		mContainer.addView(view);
		mViewPos.put(view, mCurrentIndex);
		
		//褰撳墠绗竴寮犲浘鐗囧皬鏍�
		mFristIndex++;
		//濡傛灉璁剧疆浜嗘粴鍔ㄧ洃鍚垯瑙﹀彂
		if (mListener != null)
		{
			notifyCurrentImgChanged();
		}

	}
	/**
	 * 鍔犺浇鍓嶄竴寮犲浘鐗�
	 */
	protected void loadPreImg()
	{
		//濡傛灉褰撳墠宸茬粡鏄涓�寮狅紝鍒欒繑鍥�
		if (mFristIndex == 0)
			return;
		//鑾峰緱褰撳墠搴旇鏄剧ず涓虹涓�寮犲浘鐗囩殑涓嬫爣
		int index = mCurrentIndex - mCountOneScreen;
		if (index >= 0)
		{
//			mContainer = (LinearLayout) getChildAt(0);
			//绉婚櫎鏈�鍚庝竴寮�
			int oldViewPos = mContainer.getChildCount() - 1;
			mViewPos.remove(mContainer.getChildAt(oldViewPos));
			mContainer.removeViewAt(oldViewPos);
			
			//灏嗘View鏀惧叆绗竴涓綅缃�
			View view = mAdapter.getView(index, null, mContainer);
			mViewPos.put(view, index);
			mContainer.addView(view, 0);
			view.setOnClickListener(this);
			//姘村钩婊氬姩浣嶇疆鍚戝乏绉诲姩view鐨勫搴︿釜鍍忕礌
			scrollTo(mChildWidth, 0);
			//褰撳墠浣嶇疆--锛屽綋鍓嶇涓�涓樉绀虹殑涓嬫爣--
			mCurrentIndex--;
			mFristIndex--;
			//鍥炶皟
			if (mListener != null)
			{
				notifyCurrentImgChanged();

			}
		}
	}

	/**
	 * 婊戝姩鏃剁殑鍥炶皟
	 */
	public void notifyCurrentImgChanged()
	{
		//鍏堟竻闄ゆ墍鏈夌殑鑳屾櫙鑹诧紝鐐瑰嚮鏃朵細璁剧疆涓鸿摑鑹�
		for (int i = 0; i < mContainer.getChildCount(); i++)
		{
			mContainer.getChildAt(i).setBackgroundColor(Color.WHITE);
		}
		
		mListener.onCurrentImgChanged(mFristIndex, mContainer.getChildAt(0));

	}

	/**
	 * 鍒濆鍖栨暟鎹紝璁剧疆鏁版嵁閫傞厤鍣�
	 * 
	 * @param mAdapter
	 */
	public void initDatas(HorizontalScrollViewAdapter mAdapter)
	{
		this.mAdapter = mAdapter;
		mContainer = (LinearLayout) getChildAt(0);
		// 鑾峰緱閫傞厤鍣ㄤ腑绗竴涓猇iew
		final View view = mAdapter.getView(0, null, mContainer);
		mContainer.addView(view);

		// 寮哄埗璁＄畻褰撳墠View鐨勫鍜岄珮
		if (mChildWidth == 0 && mChildHeight == 0)
		{
			int w = View.MeasureSpec.makeMeasureSpec(0,
					View.MeasureSpec.UNSPECIFIED);
			int h = View.MeasureSpec.makeMeasureSpec(0,
					View.MeasureSpec.UNSPECIFIED);
			view.measure(w, h);
			mChildHeight = view.getMeasuredHeight();
			mChildWidth = view.getMeasuredWidth();
			Log.e(TAG, view.getMeasuredWidth() + "," + view.getMeasuredHeight());
			mChildHeight = view.getMeasuredHeight();
			// 璁＄畻姣忔鍔犺浇澶氬皯涓猇iew
			mCountOneScreen = (mScreenWitdh / mChildWidth == 0)?mScreenWitdh / mChildWidth+1:mScreenWitdh / mChildWidth+2;

			Log.e(TAG, "mCountOneScreen = " + mCountOneScreen
					+ " ,mChildWidth = " + mChildWidth);
			

		}
		//鍒濆鍖栫涓�灞忓箷鐨勫厓绱�
		initFirstScreenChildren(mCountOneScreen);
	}

	/**
	 * 鍔犺浇绗竴灞忕殑View
	 * 
	 * @param mCountOneScreen
	 */
	public void initFirstScreenChildren(int mCountOneScreen)
	{
		mContainer = (LinearLayout) getChildAt(0);
		mContainer.removeAllViews();
		mViewPos.clear();

		for (int i = 0; i < mCountOneScreen; i++)
		{
			View view = mAdapter.getView(i, null, mContainer);
			view.setOnClickListener(this);
			mContainer.addView(view);
			mViewPos.put(view, i);
			mCurrentIndex = i;
		}

		if (mListener != null)
		{
			notifyCurrentImgChanged();
		}

	}

	@Override
	public boolean onTouchEvent(MotionEvent ev)
	{
		switch (ev.getAction())
		{
		case MotionEvent.ACTION_MOVE:
//			Log.e(TAG, getScrollX() + "");

			int scrollX = getScrollX();
			// 濡傛灉褰撳墠scrollX涓簐iew鐨勫搴︼紝鍔犺浇涓嬩竴寮狅紝绉婚櫎绗竴寮�
			if (scrollX >= mChildWidth)
			{
				loadNextImg();
			}
			// 濡傛灉褰撳墠scrollX = 0锛� 寰�鍓嶈缃竴寮狅紝绉婚櫎鏈�鍚庝竴寮�
			if (scrollX == 0)
			{
				loadPreImg();
			}
			break;
		}
		return super.onTouchEvent(ev);
	}

	@Override
	public void onClick(View v)
	{
		if (mOnClickListener != null)
		{
			for (int i = 0; i < mContainer.getChildCount(); i++)
			{
				mContainer.getChildAt(i).setBackgroundColor(Color.WHITE);
			}
			mOnClickListener.onClick(v, mViewPos.get(v));
		}
	}

	public void setOnItemClickListener(OnItemClickListener mOnClickListener)
	{
		this.mOnClickListener = mOnClickListener;
	}

	public void setCurrentImageChangeListener(
			CurrentImageChangeListener mListener)
	{
		this.mListener = mListener;
	}

}
