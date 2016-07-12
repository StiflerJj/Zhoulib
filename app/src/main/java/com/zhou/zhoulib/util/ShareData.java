package com.zhou.zhoulib.util;

import android.content.Context;
import android.content.SharedPreferences;

public class ShareData {
	private static final String SP_NAME = "pda_sharedata";
	private static Context context;
	private static SharedPreferences sp;

	public static void init(Context initContext) {
		if (sp == null) {
			context = initContext;
			sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
		}
	}

	public static int getShareIntData(String key) {
		if (sp == null)
			return 0;
		return sp.getInt(key, 0);
	}

	public static int getShareIntData(String key, int defValue) {
		if (sp == null)
			return 0;
		return sp.getInt(key, defValue);
	}

	public static void setShareIntData(String key, int value) {
		if (sp == null)
			return;
		sp.edit().putInt(key, value).commit();
	}

	public static String getShareStringData(String key) {
		if (sp == null)
			return "";
		return sp.getString(key, "");
	}

	public static String getShareStringData(String key, String value) {
		if (sp == null)
			return "";
		return sp.getString(key, value);
	}

	public static void setShareStringData(String key, String value) {
		if (sp == null)
			return;
		sp.edit().putString(key, value).commit();
	}

	public static boolean getShareBooleanData(String key) {
		if (sp == null)
			return false;
		return sp.getBoolean(key, false);
	}

	public static void setShareBooleanData(String key, boolean value) {
		if (sp == null)
			return;
		sp.edit().putBoolean(key, value).commit();
	}

	public static float getShareFloatData(String key) {
		if (sp == null)
			return 0f;
		return sp.getFloat(key, 0f);
	}

	public static void setShareFloatData(String key, float value) {
		if (sp == null)
			return;
		sp.edit().putFloat(key, value).commit();
	}

	public static long getShareLongData(String key) {
		if (sp == null)
			return 0l;
		return sp.getLong(key, 0l);
	}

	public static void setShareLongData(String key, long value) {
		if (sp == null)
			return;
		sp.edit().putLong(key, value).commit();
	}

	public static void remove(String key) {
		if (sp == null)
			return;
		sp.edit().remove(key).commit();
	}

	public static boolean contains(String key) {
		if (sp == null)
			return false;
		return sp.contains(key);
	}

	 public static void clear() {
	 sp.edit().clear().commit();
	 }

}
