package com.kachade.framework.util;



import com.kachade.framework.app.KachadeApplication;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * ����Ӧ�ó����˳�
 *
 */
public class ExitHandler {
	
	public static final String ACTION_EXIT = KachadeApplication.getContext().getPackageName()+".action_exit_app";
	
	private Activity mActivity = null;

	/**
	 * �㲥�������������˳�����Ϣ��finish��activity
	 */
	private BroadcastReceiver receiver = new BroadcastReceiver()
	{
		@Override
		public void onReceive(Context context, Intent intent) {
			
			String action = intent.getAction();
			if (ACTION_EXIT.equals(action))
			{
				if (null != mActivity)
				{
					mActivity.finish();
				}
				
			}
		}
	};
	
	public ExitHandler(Activity activity)
	{
		mActivity = activity;
	}
	
	/**
	 * ע��㲥
	 */
	public void register()
	{
		if (null != mActivity)
		{
			IntentFilter filter = new IntentFilter();
			filter.addAction(ACTION_EXIT);
			mActivity.registerReceiver(receiver, filter);
		}
	}
	
	/**
	 * ���ע��㲥
	 */
	public void unregister()
	{
		if (null != mActivity)
		{
			mActivity.unregisterReceiver(receiver);
		}
	}


}
