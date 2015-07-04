package com.gugalor.citylist;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

/**
 * 公共参数配置类
 * 
 * @author gugalor
 * 
 */
public class Setting {


	public static String LoadFromSharedPreferences(Context context, String key) {
		SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
		return mPrefs.getString(key, "");
	}

	public static void Save2SharedPreferences(Context context, String key, String value) {
		SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
		SharedPreferences.Editor ed = mPrefs.edit();
		ed.putString(key, value);
		ed.commit();
	}
}
