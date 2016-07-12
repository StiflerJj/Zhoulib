package com.zhou.zhoulib.util;

import java.util.ArrayList;

/**
 * 异或运算
 * 
 * @author cetczhoucong
 * 
 */
public class YHUtils {
	public static String TAG = "YHUtils";

	/**
	 * 字符串异或
	 * @param arr
	 * @return
	 */
	public static String testYH(ArrayList<String> arr) {
		byte start = 0;

		if (arr != null && arr.size() > 0) {

			for (int i = 0; i < arr.size(); i++) {
				String str = arr.get(i);
				byte[] strBytes = str.getBytes();

				for (int j = 0; j < strBytes.length; j++) {
					start = (byte) (start ^ strBytes[j]);
				}
			}
		}

		return Integer.toHexString(start).toUpperCase();

	}

	/**
	 * 字节数组异或
	 * @param byteArr
	 * @return
	 */
	public static byte byteArrYH(byte[] byteArr){
		byte b = 0;
		if(byteArr!=null && byteArr.length>0){
			for (int i = 0; i <byteArr.length ; i++) {
				b = (byte) (b ^ byteArr[i]);
			}
		}
		return b;
	}

	public static String testYHstr(String str) {
		byte start = 0;
		byte[] strBytes = str.getBytes();

		for (int j = 0; j < strBytes.length; j++) {
			start = (byte) (start ^ strBytes[j]);
		}
		return Integer.toHexString(start).toUpperCase();
	}

	public static boolean ifYHEquals(String str) {
		String csNow = null;
		String cs = null;
		try {
			csNow = str.substring(str.length() - 3, str.length() - 1);
			cs = testYHstr(str.substring(1, str.length() - 4));
			if (cs.length() == 1)
				cs = "0" + cs;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return csNow.equals(cs);
	}

	public static String getTimeStr(String bdtxr) {
		String[] bodies = bdtxr.split(",");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bodies.length; i++) {
			if (bodies[i] == null || bodies[i].length() == 0) {
				sb.append(DateUtil.getStringDate() + ",");
			} else if (bodies[i] != null && i == bodies.length - 1) {
				sb.append(bodies[i]);
			} else {
				sb.append(bodies[i] + ",");
			}
		}

		String newStr = sb.toString();
		return newStr;
	}

	public static String setTimeStr(String bdwaa) {
		String[] bodies = bdwaa.split(",");
		StringBuffer sb = new StringBuffer();
		if (bdwaa == null || bdwaa.length() <= 0) {
			return null;
		}
		bodies[4] = DateUtil.getYYMMDD() + " " + bodies[4].substring(0, 2)
				+ ":" + bodies[4].substring(2, 4) + ":"
				+ bodies[4].substring(4, 6);
		for (int i = 0; i < bodies.length; i++) {
			if (bodies[i] != null && i == bodies.length - 1) {
				sb.append(bodies[i]);
			} else {
				sb.append(bodies[i] + ",");
			}
		}
		String newStr = sb.toString();
		return newStr;
	}

	public static String setCurTimeStr(String bdwaa) {
		String[] bodies = bdwaa.split(",");
		StringBuffer sb = new StringBuffer();
		if (bdwaa == null || bdwaa.length() <= 0) {
			return null;
		}
		bodies[4] = DateUtil.getStringDate();
		bodies[3] = Integer.parseInt(bodies[3]) + "";
		for (int i = 0; i < bodies.length; i++) {
			if (bodies[i] != null && i == bodies.length - 1) {
				sb.append(bodies[i]);
			} else {
				sb.append(bodies[i] + ",");
			}
		}
		String newStr = sb.toString();
		return newStr;
	}

	public static String setGsmTimeStr(String bdwaa) {
		String[] bodies = bdwaa.split(",");
		StringBuffer sb = new StringBuffer();
		if (bdwaa == null || bdwaa.length() <= 0) {
			return null;
		}
		bodies[4] = DateUtil.getYYMMDD() + " " + bodies[4];
		for (int i = 0; i < bodies.length; i++) {
			if (bodies[i] != null && i == bodies.length - 1) {
				sb.append(bodies[i]);
			} else {
				sb.append(bodies[i] + ",");
			}
		}
		String newStr = sb.toString();
		return newStr;
	}

}
