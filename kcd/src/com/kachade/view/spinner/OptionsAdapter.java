//package com.kachade.view.spinner;
//
//import java.util.List;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//import com.kachade.kcd.R;
//
//public class OptionsAdapter extends BaseAdapter {
//
//	private Context context = null;
//	private List<String> datas = null;
//
//	public OptionsAdapter(Context context, List<String> d) {
//		this.context = context;
//		this.datas = d;
//	}
//
//	public int getCount() {
//		return datas.size();
//	}
//
//	public Object getItem(int arg0) {
//		return datas.get(arg0);
//	}
//
//	public long getItemId(int arg0) {
//		return arg0;
//	}
//
//	/**
//	 * @author ZYJ
//	 * @功能 一个简单TextView显示
//	 */
//	public View getView(int arg0, View arg1, ViewGroup arg2) {
//		View view = LayoutInflater.from(context).inflate(R.layout.childlist,
//				null);
//		TextView textStr = (TextView) view.findViewById(R.id.info);
//		textStr.setText("\t" + getItem(arg0).toString());
//		return view;
//	}
//
//	public void setDatas(List<String> datas) {
//		this.datas = datas;
//	}
//
//}
