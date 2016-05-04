package com.kachade.framework.app;

import android.app.ActivityManager;
import android.app.Application;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.kachade.framework.util.ExitHandler;
import com.kachade.framework.util.Loger;

public class KachadeApplication extends Application {
	public static Context context;
	public static KachadeApplication baseApplication;

	public float ScreenWidth;
	public float ScreenHeight;
	public float density;

	private void init() {
		if (inMainProcess()) {
			if (context == null) {
				context = this.getApplicationContext();
			}
			if (baseApplication == null) {
				baseApplication = this;
			}
			WindowManager wmManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
			DisplayMetrics dm = new DisplayMetrics();
			wmManager.getDefaultDisplay().getMetrics(dm);
			ScreenWidth = (float) dm.widthPixels;
			ScreenHeight = (float) dm.heightPixels;
			density = dm.density;
		}
	}

	public static Context getContext() {
		return context;
	}

	public static KachadeApplication getApplication() {
		return baseApplication;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		init();
	}

	public void exitApp() {
		Intent intent = new Intent(ExitHandler.ACTION_EXIT);
		sendBroadcast(intent);
	}

	public boolean inMainProcess() {
		int myPid = android.os.Process.myPid();
		ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
		String mainProcessName = getPackageName();
		for (RunningAppProcessInfo appProcess : activityManager
				.getRunningAppProcesses()) {
			if (appProcess.pid == myPid) {

				if (mainProcessName.equals(appProcess.processName)) {
					Loger.i("process id:" + appProcess.pid);
					Loger.i("MainProcess name:" + appProcess.processName);
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}
}
