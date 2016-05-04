package com.kachade.framework.app;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

@SuppressLint("SimpleDateFormat")
public class ToolUtils {
	public static int String2Int(String str) {
		if (str != null) {
			try {
				int num = Integer.valueOf(str);
				return num;
			} catch (Exception e) {
				return -1;
			}
		}
		return -1;
	}

	public static boolean isTimetoTTS(String tts_time, String curTime) {
		try {
			if (tts_time.equals(curTime)) {
				return true;
			}
			String[] tts = tts_time.split(":");
			String[] cur = curTime.split(":");
			if (ToolUtils.String2Int(tts[0]) > ToolUtils.String2Int(cur[0])) {
				return false;
			} else if (ToolUtils.String2Int(tts[0]) == ToolUtils
					.String2Int(cur[0])) {
				if (ToolUtils.String2Int(tts[1]) >= ToolUtils
						.String2Int(cur[1])) {
					int tts_min = ToolUtils.String2Int(tts[1]);
					int cur_min = ToolUtils.String2Int(cur[1]);
					if (tts_min - cur_min <= 3)
						return true;
				} else if (ToolUtils.String2Int(tts[1]) < ToolUtils
						.String2Int(cur[1])) {
					int tts_min = ToolUtils.String2Int(tts[1]);
					int cur_min = ToolUtils.String2Int(cur[1]);
					if (cur_min - tts_min <= 3)
						return true;
				}
			}

		} catch (Exception e) {
		}
		return false;
	}

	public static String ToDBC(String input) {
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 12288) {
				c[i] = (char) 32;
				continue;
			}
			if (c[i] > 65280 && c[i] < 65375)
				c[i] = (char) (c[i] - 65248);
		}
		return new String(c);
	}

	public static String getCurrentTimeByFormatter(String formatterStr) {
		Calendar calendar = Calendar.getInstance();
		DateFormat formatter = new SimpleDateFormat(formatterStr);
		return formatter.format(calendar.getTime());
	}

	public static String getTimeByFormatter(long time, String formatterStr) {
		DateFormat formatter = new SimpleDateFormat(formatterStr);
		return formatter.format(time);
	}

	public static boolean isTimeToday(String date, String formatterStr) {
		if (date == null || formatterStr == null) {
			return false;
		}
		Calendar calendar = Calendar.getInstance();
		DateFormat formatter = new SimpleDateFormat(formatterStr);
		String currentDate = formatter.format(calendar.getTime());
		if (currentDate.equals(date)) {
			return true;
		}
		return false;

	}

	public static int getIndexfromArray(String value, String[] values) {
		int len = values.length;
		for (int i = 0; i < len; i++) {
			if (value.equals(values[i])) {
				return i;
			}
		}
		return 0;
	}

	public static boolean isUpdateDatatime(String begin, String end) {
		String[] btime = begin.split(":");
		String[] etime = end.split(":");
		String curtime = new SimpleDateFormat("HH:mm").format(new Date());
		String[] ctime = curtime.split(":");
		boolean bbegin = false;
		boolean bend = false;
		if (ToolUtils.String2Int(ctime[0]) > ToolUtils.String2Int(btime[0])) {
			bbegin = true;
		} else if (ToolUtils.String2Int(ctime[0]) == ToolUtils
				.String2Int(btime[0])) {
			if (ToolUtils.String2Int(ctime[1]) >= ToolUtils
					.String2Int(btime[1])) {
				bbegin = true;
			}
		}
		if (ToolUtils.String2Int(ctime[0]) < ToolUtils.String2Int(etime[0])) {
			bend = true;
		} else if (ToolUtils.String2Int(ctime[0]) == ToolUtils
				.String2Int(etime[0])) {
			if (ToolUtils.String2Int(ctime[1]) <= ToolUtils
					.String2Int(etime[1])) {
				bend = true;
			}
		}
		if (bbegin && bend) {
			return true;
		}
		return false;
	}

	public static boolean isTimeBigger(String begin, String end) {
		if (begin.equals(end) && begin.equals("00:00")) {
			return false;
		}
		String[] btime = begin.split(":");
		String[] etime = end.split(":");
		if (ToolUtils.String2Int(btime[0]) > ToolUtils.String2Int(etime[0])) {
			return true;
		} else if (ToolUtils.String2Int(btime[0]) == ToolUtils
				.String2Int(etime[0])) {
			if (ToolUtils.String2Int(btime[1]) >= ToolUtils
					.String2Int(etime[1])) {
				return true;
			}
		}
		return false;

	}

	public static String getInterval(long time) {
		long value = (time / 60000 < 60) ? (time / 60000) : (time / 60000 / 60);
		if (value == 30) {
			return "半小时";
		} else {
			return value + "小时";
		}
	}

	public static long getInterval(String time) {
		if (time.endsWith("半小时")) {
			return 30 * 60 * 1000;

		} else if (time.endsWith("1小时(推荐)")) {
			return 1 * 60 * 60 * 1000;

		} else if (time.endsWith("2小时")) {
			return 2 * 60 * 60 * 1000;

		} else if (time.endsWith("4小时")) {
			return 4 * 60 * 60 * 1000;

		} else if (time.endsWith("6小时")) {
			return 6 * 60 * 60 * 1000;
		}
		return 2 * 60 * 60 * 1000;
	}

	public static int dip2px(Context context, float dipValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}

	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	public static ArrayList<Integer> getindexfromString(String str,
			String substr) {
		ArrayList<Integer> indexs = new ArrayList<Integer>();
		char[] cs = str.toCharArray();
		int size = cs.length;
		for (int i = 0; i < size; i++) {
			int index = str.indexOf(substr, i);
			if (index != -1) {
				indexs.add(index);
				i = index;
			}
		}
		return indexs;
	}

	/**
	 * 
	 * @return 今天是星期几
	 */
	public static String getDayOfWeek() {
		Calendar calendar = Calendar.getInstance();
		int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
		switch (dayofweek) {
		case 1:
			return "周日";
		case 2:
			return "周一";
		case 3:
			return "周二";
		case 4:
			return "周三";
		case 5:
			return "周四";
		case 6:
			return "周五";
		case 7:
			return "周六";
		default:
			break;
		}
		return "";
	}

	/**
	 * 
	 * @return 返回保存皮肤apk的路径
	 */
	public static String getSaveapkPath(Context context) {
		String sdcardPath = getDiskCacheDir(context, "systemapk")
				.getAbsolutePath();
		// String sdcardPath =
		// Environment.getExternalStorageDirectory().getPath();
		File file = new File(sdcardPath);
		if (!file.exists()) {
			file.mkdir();
		}
		return file.getAbsolutePath();
	}

	public static void deleteapkPath(String path) {
		// String sdcardPath =
		// Environment.getExternalStorageDirectory().getPath()+"/systemapk";
		// String sdcardPath = getSaveapkPath(context);
		if (path == null)
			return;
		Log.i("DeleteFile", path);
		File file = new File(path);

		if (file.exists()) {
			if (file.isDirectory()) {
				String[] childrenList = file.list();
				for (String childName : childrenList) {
					new File(file, childName).delete();
				}
			}
			file.delete();
		}

	}

	/**
	 * 
	 * @return 得到已下载的PluginId
	 */
	public static ArrayList<String> getAllDownLoadSkinApkName(Context context) {
		ArrayList<String> names = new ArrayList<String>();
		File file = getDiskCacheDir(context, "systemapk");
		// String path =
		// Environment.getExternalStorageDirectory().getPath()+"/systemapk";
		// File file = new File(path);
		if (file.exists()) {
			String[] listnames = file.list();
			if (null != listnames) {
				int len = listnames.length;
				for (int i = 0; i < len; i++) {
					names.add(listnames[i]);
				}
			}
		}
		return names;
	}

	/**
	 * 
	 * @return 得到已安装的皮肤apk的名字
	 */
	public static ArrayList<String> getinstallSkinApk(Context context) {
		ArrayList<String> packagenames = new ArrayList<String>();
		PackageManager pm = context.getPackageManager();
		List<PackageInfo> packages = pm.getInstalledPackages(0);
		int size = packages.size();
		for (int i = 0; i < size; i++) {
			PackageInfo packageInfo = packages.get(i);
			if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
				packagenames.add(packageInfo.packageName);
			}
		}
		return packagenames;
	}

	/**
	 * 
	 * @param context
	 *            上下文
	 * @param packageName
	 *            包名
	 * @return 判断一个应用是否安装（是否能得到上下文，能表示安装，不能表示没有安装）
	 */
	public static boolean isInstallAPK(Context context, String packageName) {
		Context contexttemp = null;
		try {
			contexttemp = context.createPackageContext(packageName,
					Context.CONTEXT_INCLUDE_CODE
							| Context.CONTEXT_IGNORE_SECURITY);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return null != contexttemp ? true : false;
	}

	/**
	 * 
	 * @param time
	 *            /Date(1431360000000+0800)/
	 * @return 2014年03月05日
	 */
	public static String getDate(String time) {
		String regEx = "[^0-9]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(time);
		String mmzone = m.replaceAll("").trim();
		String mm = (String) mmzone.subSequence(0, mmzone.length() - 4);
		try {
			Date d = new Date(Long.valueOf(mm));
			return new SimpleDateFormat("yyyy年MM月dd日").format(d);
		} catch (Exception e) {

		}
		return "";
	}

	/**
	 * 根据当前时间得出当前是哪个季节，白天还是黑夜
	 * 
	 * @return 0x10 春白 0x00 春黑 0x11 夏白 0x01 夏黑 0春 1 夏 2秋 3冬 0 黑 1白
	 */
	public static int getSeasonADayNight() {
		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		if (month <= 2) {
			if (hour >= 6 ? (hour <= 18 ? true : false) : false) {
				return 0x10;
			} else {
				return 0x00;
			}

		} else if (month <= 5) {
			// 3 4 5
			if (hour >= 6 ? (hour <= 18 ? true : false) : false) {
				return 0x11;
			} else {
				return 0x01;
			}
		} else if (month <= 8) {
			// 6 7 8
			if (hour >= 6 ? (hour <= 18 ? true : false) : false) {
				return 0x12;
			} else {
				return 0x02;
			}
		} else {
			// 9 10 11
			if (hour >= 6 ? (hour <= 18 ? true : false) : false) {
				return 0x13;
			} else {
				return 0x03;
			}
		}
	}

	/**
	 * 得到缓存的路径
	 * 
	 * @param context
	 * @param uniqueName
	 * @return
	 */
	public static File getDiskCacheDir(Context context, String uniqueName) {
		final String cachePath = Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState()) ? Environment
				.getExternalStorageDirectory().getPath() : context
				.getCacheDir().getPath();
		File file = new File(cachePath + File.separator + "uair");
		if (!file.exists()) {
			file.mkdir();
		}
		return new File(file, uniqueName);
	}

}
