package com.zmax.allsamples.utils;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class CustomTextView  extends TextView {

	public CustomTextView(Context context, AttributeSet attrs, int defStyle) {

		super(context, attrs, defStyle);
		init();
	}

	public CustomTextView(Context context, AttributeSet attrs) {

		super(context, attrs);
		init();

	}

	public CustomTextView(Context context) {
		super(context);
		init();
	}

	private void init() {

		if (!isInEditMode()) {
			Typeface tf = Typeface.createFromAsset(getContext().getAssets(),"fonts/Roboto-Light_1.ttf");
			setTypeface(tf);
		}
	}

	@Override
	public Object getTag() {
		// TODO Auto-generated method stub
		return super.getTag();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see android.view.View#setTag(java.lang.Object)
	 */
	@Override
	public void setTag(Object tag) {
		// TODO Auto-generated method stub
		super.setTag(tag);
	}

/*	public Typeface getTypeFaceLight(){
		Typeface typeface_roboto_lt = Typeface.createFromAsset(getContext().getAssets(),"fonts/Roboto-Light_1.ttf");
		return typeface_roboto_lt;
	}

	public Typeface getTypefaceRegular(){

		Typeface typeface_roboto_regular = Typeface.createFromAsset(getContext().getAssets(),"fonts/Roboto-Regular_1.ttf");
		return typeface_roboto_regular;
	}

	public Typeface getTypefaceSMS(){

		Typeface typeface_sms = Typeface.createFromAsset(getContext().getAssets(),"fonts/RAINSLIESANSNORMREGULAR.otf");
		return typeface_sms;
	}
	*/



}
