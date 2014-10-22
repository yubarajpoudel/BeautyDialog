package com.yuvi.toastsample;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Utils {

	public static final int LENGTH_LONG = 3000;
	public static final int LENGTH_MEDIUM= 2000;
	public static final int LENGTH_SHORT = 1000;
	public static final int BLACK = 0;
	public static final int BLUE = 1;
	public static final int GREEN = 2;
	public static final int RED = 3;
	public static final int YELLOW = 4;
	
	public static final String TAG = "Animatebox";
	public static boolean isNetworkConnected

	(Context ctx) {
		ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getActiveNetworkInfo();
		if (ni == null) {
			return false; // There are no active networks.
		} else
			return true;
	}
}
