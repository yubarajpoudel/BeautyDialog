package com.yuvi.toastsample.animatelayout;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yuvi.toastsample.R;
import com.yuvi.toastsample.Utils;

public class Animatebox {
	Activity activity;
	String mNotifymesg;
	int mNotifyicon;
	int timeLong;

	ViewGroup mNotifygrp;

	LayoutInflater mInflator;

	public Animatebox(Activity activity) {
		this.activity = activity;
		if (activity == null) {
			throw new IllegalArgumentException(Utils.TAG + "No Activity Found");
		}
		mNotifygrp = (LinearLayout) activity
				.findViewById(R.id.dialog_container);

		mNotifygrp.setVisibility(View.GONE);

		mNotifygrp.removeAllViews();

	}

	public void setTextmesg(String mesg) {
		this.mNotifymesg = mesg;
		TextView tv_Mesg;
		tv_Mesg = new TextView(activity.getApplicationContext());
		tv_Mesg.setVisibility(View.VISIBLE);
		tv_Mesg.setTextColor(Color.WHITE);
		tv_Mesg.setTypeface(tv_Mesg.getTypeface(), Typeface.BOLD);
		tv_Mesg.setGravity(Gravity.CENTER);
		tv_Mesg.setTextSize(16);
		tv_Mesg.setText(mNotifymesg);
		mNotifygrp.addView(tv_Mesg);
	}

	public void setImage(int icon_id) {
		this.mNotifyicon = icon_id;
		ImageView iv_Icon;
		iv_Icon = new ImageView(activity.getApplicationContext());
		iv_Icon.setPadding(5, 5, 5, 5);
		iv_Icon.setImageResource(mNotifyicon);
		mNotifygrp.addView(iv_Icon);
	}

	public void setColor(int color) {
		switch (color) {
		case 0:
			mNotifygrp.setBackgroundColor(Color.BLACK);
			break;
		case 1:
			mNotifygrp.setBackgroundColor(Color.BLUE);
			break;
		case 2:
			mNotifygrp.setBackgroundColor(Color.GREEN);
			break;
		case 3:
			mNotifygrp.setBackgroundColor(Color.RED);
			break;
		case 4:
			mNotifygrp.setBackgroundColor(Color.YELLOW);
			break;
		default:
			throw new IllegalArgumentException(Utils.TAG + "Undefined color");
		}
	}

	public void setAnimation(int timelong) {
		final Animation animation = this.getShowAnimation(timelong);
		mNotifygrp.startAnimation(animation);

		animation.setAnimationListener(new Animation.AnimationListener() {

			@Override
			public void onAnimationEnd(Animation arg0) {

				mNotifygrp.setVisibility(View.GONE);

			}

			@Override
			public void onAnimationRepeat(Animation arg0) {

			}

			@Override
			public void onAnimationStart(Animation arg0) {

				mNotifygrp.setVisibility(View.VISIBLE);

			}

		});

	}

	/**
	 * Box Animation For Notification, Developed by :- Yubaraj Poudel 
	 * date :- 22/10/2014
	 **/

	private Animation getShowAnimation(int time_animate) {

		/*
		 * Animation fadeIn = new AlphaAnimation(0, 1);
		 * fadeIn.setInterpolator(new DecelerateInterpolator());
		 * fadeIn.setDuration(time_animate);
		 */final float growTo = 1f;
		ScaleAnimation scaleAnimation = new ScaleAnimation(1, growTo, 1,
				growTo, Animation.RELATIVE_TO_SELF, 0.5f,
				Animation.RELATIVE_TO_SELF, 0.5f);
		scaleAnimation.setInterpolator(new DecelerateInterpolator());
		scaleAnimation.setDuration(time_animate);
		Animation fadeOut = new AlphaAnimation(1, 0);
		fadeOut.setInterpolator(new AccelerateInterpolator());
		fadeOut.setStartOffset(1000);
		fadeOut.setDuration(time_animate);

		AnimationSet animation = new AnimationSet(false);
		animation.addAnimation(scaleAnimation);
		animation.addAnimation(fadeOut);

		return animation;

	}

	public static void Create(Activity activity, String charSequence,
			int icon_id, int duration) {
		Animatebox ab = new Animatebox(activity);
		ab.setImage(icon_id);
		ab.setTextmesg(charSequence);
		ab.setAnimation(duration);
	}

	public static void Create(Activity activity, String chharSequence,
			int duration) {
		Animatebox ab = new Animatebox(activity);
		ab.setTextmesg(chharSequence);
		ab.setAnimation(duration);
	}

}
