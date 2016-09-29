package com.zhou.zhoulib.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.provider.MediaStore;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.util.TypedValue;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {
	// public final static String WEBSERVICE_URL =
	// "http://client.live0311.com:8080";

	private static final String FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss";
	private static final String FORMAT_YMD = "yyyy-MM-dd";
	private static final String FORMAT_HM = "HH:mm";
	private static final String FORMAT_HMS = "HH:mm:ss";
	private static final String FORMAT_YMDHM = "yyMMdd-HHmm";
	private static SimpleDateFormat sdf = new SimpleDateFormat();
	public static String cookie = "";
	private static Context context;

	private static Calendar cal = Calendar.getInstance();

	// public final static int PAGE_SIZE = 20;

	// public static final File PHOTO_DIR = new
	// File(Environment.getExternalStorageDirectory() + "/live0311_data");
	// public final static String APK_PATH = PHOTO_DIR.getAbsolutePath() +
	// "/live0311.apk";

	// public static Dictionary dictionary;

	// public static int getPageOffSet(int pageNo) {
	// return PAGE_SIZE * (pageNo - 1);
	// }

	public static String md5(String string) {
		byte[] hash;
		try {
			hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Huh, MD5 should be supported?", e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Huh, UTF-8 should be supported?", e);
		}

		StringBuilder hex = new StringBuilder(hash.length * 2);
		for (byte b : hash) {
			if ((b & 0xFF) < 0x10) hex.append("0");
			hex.append(Integer.toHexString(b & 0xFF));
		}
		return hex.toString();
	}
	/**
	 * 手机号正则判断
	 * 
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNO(String mobiles) {
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[^5,\\D])|(17[0,\\D]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		System.out.println(m.matches() + "---");
		return m.matches();
	}

	public static boolean isCardId(String str) {
		if (str != null && !"".equals(str.trim()) && str.matches("^[A-Za-z0-9]+$") && str.length() == 20)
			return true;
		return false;
	}

	public static boolean isCardPwd(String str) {
		if (str != null && !"".equals(str.trim()) && str.matches("^\\d{18}$"))
			return true;
		return false;
	}

	private static boolean externalMemoryAvailable() {
		return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
	}

	public static long getAvailableExternalMemorySize() {
		if (externalMemoryAvailable()) {
			File path = Environment.getExternalStorageDirectory();
			StatFs stat = new StatFs(path.getPath());
			long blockSize = stat.getBlockSize();
			long availableBlocks = stat.getAvailableBlocks();
			return availableBlocks * blockSize;
		} else {
			return -1;
		}
	}

	public static boolean isPersonName(String str) {
		if (str != null && !"".equals(str.trim()) && str.matches("^\\w+$") && str.length() <= 16)
			return true;
		return false;
	}

	public static boolean isMatcher(String regulation, String inputStr) {
		// 1、编译正则表达式
		Pattern pattern = Pattern.compile(regulation);
		// 2、输入字符匹配正则表达式
		Matcher matcher = pattern.matcher(inputStr);
		// 3、返回结果
		if (matcher.find()) {
			Log.i("MyInfo", "======================匹配===========================");
			return true;
		}
		Log.i("MyInfo", "======================不匹配===========================");
		return false;
	}

	public static boolean isSDCardExists() {
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			return true;
		}
		return false;
	}

	public static String convertStreamToString(InputStream is) {
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	public static String dateToYMDHMS(Date date) {
		return dateToString(date.getTime(), FORMAT_YMDHMS);
	}

	public static String dateToYMDHMS(long millis) {
		return dateToString(millis, FORMAT_YMDHMS);
	}

	public static String dateToYMD(long millis) {
		return dateToString(millis, FORMAT_YMD);
	}

	public static Date YMDHMSToDate(String date) {
		return stringToDate(date, FORMAT_YMDHMS);
	}

	public static Date YMDToDate(String date) {
		return stringToDate(date, FORMAT_YMD);
	}

	public static String dateToHM(long millis) {
		return dateToString(millis, FORMAT_HM);
	}

	public static Date HMToDate(String date) {
		return stringToDate(date, FORMAT_HM);
	}

	public static Date HMSToDate(String date) {
		return stringToDate(date, FORMAT_HMS);
	}

	public static String dateToYMDHM(long millis) {
		return dateToString(millis, FORMAT_YMDHM);
	}

	private static Date stringToDate(String date, String pattern) {
		sdf.applyPattern(pattern);
		Date tmp;
		try {
			tmp = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			tmp = new Date();
		}
		return tmp;
	}

	private static String dateToString(long millis, String pattern) {
		sdf.applyPattern(pattern);
		return sdf.format(new Date(millis));
	}

	// public static String dateToMD(String date) {
	// if (date.length() == FORMAT_YMDHMS.length()) {
	// return dateToString(stringToDate(date, FORMAT_YMDHMS).getTime(),
	// FORMAT_MD);
	// } else if (date.length() == FORMAT_YMD.length()) {
	// return dateToString(stringToDate(date, FORMAT_YMD).getTime(), FORMAT_MD);
	// }
	// return dateToString(System.currentTimeMillis(), FORMAT_MD);
	// }

	public static String format(Context context, int stringId, Object... args) {
		return String.format(context.getString(stringId), args);
	}

	public static void showToast(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}

	public static void showToast(Context context, int stringId) {
		Toast.makeText(context, context.getResources().getString(stringId), Toast.LENGTH_SHORT).show();
	}

	public static void showToast(Context context, String msg, boolean isShow) {
		if (isShow)
			showToast(context, msg);
	}

	public static void showToast(Context context, int stringId, boolean isShow) {
		if (isShow)
			showToast(context, stringId);
	}

	public static String getFileSuffix(String path) {
		if (path != null && !"".equals(path)) {
			return path.substring(path.lastIndexOf(".") + 1).trim().toLowerCase();
		}
		return "";
	}

	public static String getFileName(String path) {
		if (path != null && !"".equals(path)) {
			return path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf(".")).trim();
		}
		return "";
	}

	/**
	 * 将图片转换成字节数组
	 * 
	 * @param bitmap
	 * @return
	 */
	// public static byte[] convertBitmap(Bitmap bitmap) {
	// return convertBitmap(bitmap, Const.JPEG_QUALITY);
	// }

	/**
	 * 将图片转换成字节数组
	 * 
	 * @param bitmap
	 * @return
	 */
	public static byte[] convertBitmap(Bitmap bitmap, int quality) {
		if (bitmap == null)
			return null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.JPEG, 70, baos);
		return baos.toByteArray();
	}

	public static Intent getTakePickIntent(File f) {
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE, null);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
		return intent;
	}

	public static Intent getPhotoPickIntent() {
		return getPhotoPickIntent(false);
	}

	public static Intent getPhotoPickIntent(boolean crop) {
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT, null);
		intent.setType("image/*");
		if (crop) {
			intent.putExtra("crop", "true");
			intent.putExtra("aspectX", 1);
			intent.putExtra("aspectY", 1);
			intent.putExtra("outputX", 100);
			intent.putExtra("outputY", 100);
		}
		// intent.putExtra("return-data", true);
		return intent;
	}

	public static Intent getCropImageIntent(Uri photoUri) {
		return getCropImageIntent(photoUri, false);
	}

	public static Intent getCropImageIntent(Uri photoUri, boolean crop) {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(photoUri, "image/*");
		if (crop) {
			intent.putExtra("crop", "true");
			intent.putExtra("aspectX", 1);
			intent.putExtra("aspectY", 1);
			intent.putExtra("outputX", 100);
			intent.putExtra("outputY", 100);
		}
		// intent.putExtra("return-data", true);
		return intent;
	}

	public static String getPhotoFileName() {
		return "live0311_" + System.currentTimeMillis() + ".jpg";
	}

	public static Bitmap resizeBitmap(Bitmap bitmap, int newWidth) {
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		float temp = ((float) height) / ((float) width);
		int newHeight = (int) ((newWidth) * temp);
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		Matrix matrix = new Matrix();
		// resize the bit map
		matrix.postScale(scaleWidth, scaleHeight);
		// matrix.postRotate(45);
		Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
		bitmap.recycle();
		return resizedBitmap;
	}

	public static void showDateChooser(Context context, final TextView target) {
		showDateChooser(context, target, null);
	}

	public static void showDateChooser(Context context, final TextView target,
			DialogInterface.OnDismissListener listener) {
		if (!"".equals(target.getText()))
			cal.setTime(YMDToDate(target.getText().toString()));
		else
			cal.setTimeInMillis(System.currentTimeMillis());
		DatePickerDialog dialog = new DatePickerDialog(context, new OnDateSetListener() {

			@Override
			public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
				monthOfYear = monthOfYear + 1;
				target.setText(year + "-" + (monthOfYear < 10 ? "0" + monthOfYear : monthOfYear) + "-"
						+ (dayOfMonth < 10 ? "0" + dayOfMonth : dayOfMonth));

			}
		}, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
		if (listener != null)
			dialog.setOnDismissListener(listener);
		dialog.show();
	}

	public static void showTimeChooser(Context context, final TextView target) {
		showTimeChooser(context, target, null);
	}

	public static void showTimeChooser(Context context, final TextView target,
			DialogInterface.OnDismissListener listener) {
		if (!"".equals(target.getText()))
			cal.setTime(HMToDate(target.getText().toString()));
		else
			cal.setTimeInMillis(System.currentTimeMillis());
		TimePickerDialog dialog = new TimePickerDialog(context, new OnTimeSetListener() {

			@Override
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				target.setText((hourOfDay < 10 ? "0" + hourOfDay : hourOfDay) + ":"
						+ (minute < 10 ? "0" + minute : minute));
			}
		}, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true);
		if (listener != null)
			dialog.setOnDismissListener(listener);
		dialog.show();
	}

	public static boolean isBlank(String str) {
		if (str != null && !"".equals(str.trim()))
			return false;
		return true;
	}

	public static boolean isContainsCharNumLine(String str) {
		if (str != null && !"".equals(str.trim()) && str.matches("[0-9A-Za-z_]*"))
			return true;
		return false;
	}

	public static boolean isImeiNum(String str) {
		if (str != null && !"".equals(str.trim()) && str.matches("^\\d{15}$"))
			return true;
		return false;
	}

	public static boolean isKey(String str) {
		if (str != null && !"".equals(str.trim()) && str.matches("^[A-Za-z0-9]+$") && str.length() == 6)
			return true;
		return false;
	}

	public static SpannableStringBuilder getSpannableString(String str, String[] values, int[] colors) {
		SpannableStringBuilder ssb = new SpannableStringBuilder(str);
		int index = 0;
		int start = 0;
		String tmp = "";
		int _color = 0;
		if (values != null && colors != null) {
			for (int i = 0; i < values.length; i++) {
				if (colors.length > i)
					_color = colors[i];
				CharacterStyle style = new ForegroundColorSpan(_color);
				tmp = values[i];
				index = str.indexOf(tmp, start);
				if (index != -1) {
					ssb.setSpan(style, index, index + tmp.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
					start = index + tmp.length();
				}
			}
		}
		return ssb;
	}

	// public static Item findItemById(List<Item> list, int id) {
	// Item item = null;
	// for (int i = 0; i < list.size(); i++) {
	// item = list.get(i);
	// if (item.id == id) {
	// return item;
	// }
	// }
	// return null;
	// }

	// public static String getItemNameById(List<Item> list, int id) {
	// Item item = findItemById(list, id);
	// if (item == null) {
	// return "";
	// }
	// return item.name;
	//
	// }

	// public static Province findProvinceById(List<Province> list, int id) {
	// Province item = null;
	// for (int i = 0; i < list.size(); i++) {
	// item = list.get(i);
	// if (item.id == id) {
	// break;
	// }
	// }
	// return item;
	// }
	//
	// public static City findCityById(List<City> list, int id) {
	// City item = null;
	// for (int i = 0; i < list.size(); i++) {
	// item = list.get(i);
	// if (item.id == id) {
	// break;
	// }
	// }
	// return item;
	// }
	//
	// public static County findCountyById(List<County> list, int id) {
	// County item = null;
	// for (int i = 0; i < list.size(); i++) {
	// item = list.get(i);
	// if (item.id == id) {
	// break;
	// }
	// }
	// return item;
	// }

	public static void writeFile(Context context, String fileName, String content) {
		FileOutputStream fos = null;
		try {
			fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
			fos.write(content.getBytes("UTF-8"));
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public static String readFile(Context context, String fileName) {
		FileInputStream fis = null;
		String content = "";
		try {
			fis = context.openFileInput(fileName);
			content = convertStreamToString(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return content;
	}

	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static boolean isServiceRunning(Context context, String name) {
		ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
			if (name.equals(service.service.getClassName())) {
				CommonUtil.log("util", "service name is " + name + "  true");
				return true;
			}
		}
		CommonUtil.log("util", "service name is " + name + "  false");
		return false;
	}

	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 */
	public static float dip2px(Context context, float dipValue) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, context.getResources()
				.getDisplayMetrics());
	}

	/**
	 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
	 */
	public static float px2dip(Context context, float pxValue) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, pxValue, context.getResources()
				.getDisplayMetrics());
	}

	private static final boolean ISLOG = true;

	public static void log(String tag, String msg) {
		if (ISLOG) {
			Log.v(tag, msg);
		}
	}

	public static void log(Object obj, String msg) {
		log(obj.getClass().getSimpleName(), msg);
	}

//	public static String getTraffic() {
//		int uid = Process.myUid();
//		long rx, tx;
//		double total;
//		rx = ShareData.getShareLongData(Const.TRAFFIC_RX_SNAPSHOT);
//		tx = ShareData.getShareLongData(Const.TRAFFIC_TX_SNAPSHOT);
//		total = (TrafficStats.getUidRxBytes(uid) - rx) + (TrafficStats.getUidTxBytes(uid) - tx);
//		CommonUtil.log("total", total + "bytes");
//		return byte2Str(total);
//	}

	public static String byte2Str(double total) {
		StringBuilder sb = new StringBuilder();
		if (total < 1000) {
			sb.append(total);
			sb.append("bytes");
		} else if (total < 1000000d) {
			total = total / 1000.0;
			sb.append(String.format("%.2f", total));
			sb.append("KB");
		} else if (total < 1000000000d) {
			total = total / 1000000.0;
			sb.append(String.format("%.2f", total));
			sb.append("MB");
		} else if (total < 1000000000000d) {
			total = total / 1000000000.0;
			sb.append(String.format("%.2f", total));
			sb.append("GB");
		}
		return sb.toString();
	}

	// public static String md5Encode(String str) {
	// MessageDigest md5;
	// try {
	// md5 = MessageDigest.getInstance("MD5");
	// md5.update(str.getBytes());
	// byte[] m = md5.digest();
	// StringBuffer sb = new StringBuffer();
	// for (int i = 0; i < m.length; i++) {
	// sb.append(m[i]);
	// }
	// return sb.toString();
	// } catch (NoSuchAlgorithmException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// return "";
	// }

	// private static byte[] createChecksum(String filename) throws Exception {
	// InputStream fis = new FileInputStream(filename);
	//
	// byte[] buffer = new byte[1024];
	// MessageDigest complete = MessageDigest.getInstance("MD5");
	// int numRead;
	//
	// do {
	// numRead = fis.read(buffer);
	// if (numRead > 0) {
	// complete.update(buffer, 0, numRead);
	// }
	// } while (numRead != -1);
	//
	// fis.close();
	// return complete.digest();
	// }
	//
	// // see this How-to for a faster way to convert
	// // a byte array to a HEX string
	// public static String getMD5Checksum(String filename) {
	// byte[] b = null;
	// String result = "";
	// try {
	// b = createChecksum(filename);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// if (b != null) {
	// for (int i = 0; i < b.length; i++) {
	// result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
	// }
	// }
	// return result;
	// }

	public static void initContext(Context context1) {
		context = context1;
	}

//	public static void installAPK(Context context) {
//		Intent intent = new Intent(Intent.ACTION_VIEW);
//		intent.setDataAndType(Uri.fromFile(new File(Const.UPDATEFILE)), "application/vnd.android.package-archive");
//		context.startActivity(intent);
//	}

	public static int getVersionCode(Context context) {
		try {
			return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
		} catch (NameNotFoundException e) {
			return 0;
		}
	}

	// public static ArrayList<GeoPoint> splitStr(String str){
	// ArrayList<GeoPoint> ps = new ArrayList<GeoPoint>();
	// GeoPoint gp;
	// String[] arr1;
	// String[] arr2;
	// if(str!=null&&str.length()>0){
	// arr1 = str.split(";");
	// for(int i=0;i<arr1.length;i++){
	// arr2 = arr1[i].split(",");
	// String latstr = arr2[0];
	// String lngstr = arr2[1];
	// double lat = Double.parseDouble(latstr);
	// double lng = Double.parseDouble(lngstr);
	// gp = new GeoPoint((int) (lng*1E6), (int) (lat*1E6));
	// ps.add(gp);
	// }
	// }
	//
	// return ps;
	// }

//	public static ArrayList<LatLng> splitStr(String str) {
//		ArrayList<LatLng> ps = new ArrayList<LatLng>();
//		LatLng gp;
//		String[] arr1;
//		String[] arr2;
//		if (str != null && str.length() > 0) {
//			arr1 = str.split(";");
//			for (int i = 0; i < arr1.length; i++) {
//				arr2 = arr1[i].split(",");
//				String latstr = arr2[0];
//				String lngstr = arr2[1];
//				double lat = Double.parseDouble(latstr);
//				double lng = Double.parseDouble(lngstr);
//				gp = new LatLng(lat, lng);
//				ps.add(gp);
//			}
//		}
//
//		return ps;
//	}

	// public static void removeCookie() {
	// CookieSyncManager.createInstance(context);
	// CookieManager cookieManager = CookieManager.getInstance();
	// cookieManager.removeAllCookie();
	// CookieSyncManager.getInstance().sync();
	// }
	//
	// public static String getCookie() {
	// CookieSyncManager.createInstance(context);
	// CookieManager cookieManager = CookieManager.getInstance();
	// cookieManager.removeSessionCookie();
	// cookieManager.removeExpiredCookie();
	// String cookie = cookieManager.getCookie("61.182.229.102");
	// if (cookie == null)
	// cookie = "";
	// log("cookie", "---" + cookie);
	// CookieSyncManager.getInstance().sync();
	// return cookie;
	// }
	//
	// public static void setCookie(HttpURLConnection con) {
	// CookieSyncManager.createInstance(context);
	// CookieManager cookieManager = CookieManager.getInstance();
	// cookieManager.removeSessionCookie();
	// cookieManager.setAcceptCookie(true);
	// String cookieVal = "";
	// String key = "";
	// for (int i = 1; (key = con.getHeaderFieldKey(i)) != null; i++) {
	// if (key.equalsIgnoreCase("set-cookie")) {
	// cookieVal = con.getHeaderField(i);
	// cookieManager.setCookie("61.182.229.102", cookieVal);
	// log("cookie", cookieVal);
	// CommonUtil.cookie = cookieVal;
	// }
	// }
	// CookieSyncManager.getInstance().sync();
	// }
	private static final int CONTENT_MAX_SIZE = 20;

	public static String splitAddr(String content) {
		StringBuilder sb = new StringBuilder();
		if (content != null) {
			for (int i = 0; i <= content.length() / CONTENT_MAX_SIZE; i++) {
				int start = i * CONTENT_MAX_SIZE;
				int end = (i + 1) * CONTENT_MAX_SIZE;
				end = end > content.length() ? content.length() : end;
				sb.append(content.substring(start, end));
				sb.append("\r\n");
			}
		}
		return sb.toString();
	}
	public static void openFiles(Context c,File file) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setAction(Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.fromFile(file),
				"application/vnd.android.package-archive");
		c.startActivity(intent);
	}
}
