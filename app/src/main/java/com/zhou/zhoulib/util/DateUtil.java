package com.zhou.zhoulib.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
	public static String getStringDate() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static String getStringDateTestMsg() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	public static String getStrTime(String str, String format) {
		String time = str;
		SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat formatter2 = new SimpleDateFormat(format);
		try {
			time = formatter1.format(formatter2.parse(time));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
	}

	public static String getYYMMDD() {
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 注意utcPattern和local pattern HH mm ss必须一致 不然会有问题
	 * 
	 * @param utcTime
	 * @param utcTimePatten
	 * @return
	 */
	public static String utc2Local(String utcTime, String utcTimePatten) {
		SimpleDateFormat utcFormater = new SimpleDateFormat(utcTimePatten);
		utcFormater.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date gpsUTCDate = null;
		try {
			gpsUTCDate = utcFormater.parse(utcTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat localFormater = new SimpleDateFormat("HH:mm:ss");
		localFormater.setTimeZone(TimeZone.getDefault());
		String localTime = null;
		if (gpsUTCDate != null)
			localTime = localFormater.format(gpsUTCDate.getTime());
		else
			localTime = localFormater.format(System.currentTimeMillis());
		return localTime;
	}
}
