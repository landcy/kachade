//package com.kachade.view.spinner;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import android.content.Context;
//import android.graphics.drawable.BitmapDrawable;
//import android.util.AttributeSet;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup.LayoutParams;
//import android.view.inputmethod.InputMethodManager;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.PopupWindow;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import com.kachade.kcd.R;
//
//public class DefineSpinnerView extends View {
//
//	/**
//	 * 用于弹出的下拉框
//	 */
//	private PopupWindow pWindow = null;
//
//	// **************************************************************************
//	// 这些是用来当点击一个时，根据他们之间的关系来显示下拉框中的内容
//	// **************************************************************************
//	/**
//	 * 祖父
//	 */
//	private DefineSpinnerView gradeParent = null;
//	/**
//	 * 父控件
//	 */
//	private DefineSpinnerView parents = null;
//	/**
//	 * 子控件
//	 */
//	private DefineSpinnerView child1 = null;
//	/**
//	 * 孙子控件
//	 */
//	private DefineSpinnerView child2 = null;
//
//	private Context context = null;
//	private OptionsAdapter adapter = null; // 下拉框适配器
//	private List<String> datas = null; // 下拉框数据
//	private RelativeLayout layout = null; // 父控件
//	private TextView text = null; // 文本显示
//	private ImageView image = null; // 下拉箭头
//	private int p_width = -1; // 下拉框宽度
//	private ListView list = null; // 下拉表
//
//	public DefineSpinnerView(Context context) {
//		super(context);
//		// TODO Auto-generated constructor stub
//		init(context);
//	}
//
//	public DefineSpinnerView(Context context, AttributeSet attrs) {
//		super(context, attrs);
//		// TODO Auto-generated constructor stub
//		init(context);
//	}
//
//	public DefineSpinnerView(Context context, AttributeSet attrs, int defStyle) {
//		super(context, attrs, defStyle);
//		// TODO Auto-generated constructor stub
//		init(context);
//	}
//
//	private void init(Context context) {
//		this.context = context;
//		TextListener lis = new TextListener();
//		text = new TextView(context);
//		text.setBackgroundResource(R.drawable.spinner_edit_normal);
//		text.setTextColor(getResources().getColor(R.color.spinner_text));
//		text.setGravity(Gravity.CENTER);
//		text.setOnClickListener(lis);
//
//		LayoutParams params1 = new LayoutParams(width, hight);
//		params1.leftMargin = left;
//		params1.topMargin = top;
//
//		image = new ImageView(context);
//		image.setBackgroundResource(R.drawable.arrow);
//		image.setOnClickListener(lis);
//		if (LoginAct.MACHINE_PIXELS == IFinalConstant.XHDPI_RESOLUTION) {
//			text.setTextSize(20.0f);
//			LayoutParams params2 = new LayoutParams(19, 17);
//			params2.topMargin = top + 15;
//			params2.leftMargin = left + width - 28;
//			map.put(image, params2);
//		} else {
//			text.setTextSize(15.0f);
//			LayoutParams params2 = new LayoutParams(8, 8);
//			params2.topMargin = top + 13;
//			params2.leftMargin = left + width - 16;
//			map.put(image, params2);
//		}
//
//		map.put(text, params1);
//	}
//
//	class TextListener implements OnClickListener {
//		public void onClick(View v) {
//			hideSoft();
//			if (gradeParent != null && parents != null) {
//				DefineSpinnerView.this.setDatas(DefineSpinnerView.this
//						.getGuxiang3(gradeParent.getText(), parents.getText()));
//			}
//			if (gradeParent == null && parents != null) {
//				DefineSpinnerView.this.setDatas(DefineSpinnerView.this
//						.getGuxiang2(parents.getText()));
//			}
//			cleanText();
//			changPopState(text);
//		}
//	}
//
//	/**
//	 * 显示或者隐藏下拉框
//	 * 
//	 * @param v
//	 */
//	private void changPopState(View v) {
//		if (pWindow == null) {
//			popWindow(v);
//			return;
//		}
//		if (!pWindow.isShowing()) {
//			popWindow(v);
//		} else {
//			if (pWindow != null) {
//				pWindow.dismiss();
//			}
//		}
//	}
//
//	/**
//	 * 初始化下拉框
//	 * 
//	 * @param par
//	 *            父控件
//	 */
//	private void popWindow(final View par) {
//		if (pWindow == null) {
//
//			// 布局文件
//			View v = LayoutInflater.from(context).inflate(R.layout.list, null);
//			list = (ListView) v.findViewById(R.id.list);
//			list.setOnItemClickListener(new OnItemClickListener() {
//				public void onItemClick(AdapterView<?> arg0, View arg1,
//						int arg2, long arg3) {
//					// R.String.butian代表的是“不填”
//					if (datas.get(arg2).toString()
//							.equals(context.getString(R.string.butian))) {
//						text.setText("");
//					} else {
//						text.setText(datas.get(arg2).toString()); // 将当前点击的item中的字符串显示出来
//					}
//					if (pWindow != null) { // 关闭下拉框
//						changPopState(par);
//					}
//				}
//			});
//			adapter = new OptionsAdapter(context, datas); // 根据数据，设置下拉框显示
//			list.setAdapter(adapter);
//			list.setDivider(null); // 屏蔽下拉框每个item之间的线条
//			/**
//			 * 两种不同长度的下拉框，主要是为了适应屏幕的大小
//			 */
//			if (p_width > 0) {
//				pWindow = new PopupWindow(v, par.getWidth(), 150);
//			} else {
//				pWindow = new PopupWindow(v, par.getWidth(), 300);
//			}
//			pWindow.setFocusable(true);
//			pWindow.setBackgroundDrawable(new BitmapDrawable());
//			pWindow.setOutsideTouchable(true);
//			pWindow.update();
//		}
//		pWindow.showAsDropDown(text);
//	}
//
//	public void setText(String str) {
//		if (text != null) {
//			text.setText(str);
//		}
//	}
//
//	public void setDatas(List<String> datas) {
//		this.datas = datas;
//		if (adapter != null) {
//			adapter.setDatas(datas);
//			adapter.notifyDataSetInvalidated();
//		}
//	}
//
//	public String getText() {
//		if (text != null) {
//			return text.getText().toString();
//		}
//		LoginAct.LogW("spinner's textView is null");
//		return "";
//	}
//
//	private void cleanText() {
//		if (child1 != null) {
//			child1.text.setText("");
//		}
//		if (child2 != null) {
//			child2.text.setText("");
//		}
//	}
//
//	public void setChild1(DefineSpinnerView child1) {
//		this.child1 = child1;
//	}
//
//	public void setChild2(DefineSpinnerView child2) {
//		this.child2 = child2;
//	}
//
//	public void setGradeParent(DefineSpinnerView gradeParent) {
//		this.gradeParent = gradeParent;
//	}
//
//	public void setParents(DefineSpinnerView parents) {
//		this.parents = parents;
//	}
//
//	public void setP_width(int p_width) {
//		this.p_width = p_width;
//	}
//
//	/**
//	 * @param s1
//	 *            父控件中的字符串
//	 * @param s2
//	 *            子控件中的字符串
//	 * @return 返回一个List<String>集合
//	 * @功能 通过父控件的字符串来设置子控件中的内容
//	 */
//	private List<String> getGuxiang3(String s1, String s2) {
//		List<String> dd = new ArrayList<String>();
//		dd.add(context.getString(R.string.butian));
//		Map<String, ArrayList<String>> mapTmp1 = MaterialView.cityMap.get(s1);
//		if (mapTmp1 != null) {
//			List<String> list = mapTmp1.get(s2);
//			if (list != null) {
//				for (String str : list) {
//					dd.add(str);
//				}
//			}
//		}
//		return dd;
//	}
//
//	/**
//	 * @param s
//	 *            字符串
//	 * @return
//	 * @author ZYJ
//	 * @功能 设置父亲辈的下拉框中的内容
//	 */
//	private List<String> getGuxiang2(String s) {
//		List<String> dd = new ArrayList<String>();
//		dd.add(context.getString(R.string.butian));
//		Map<String, ArrayList<String>> mapTmp = MaterialView.cityMap.get(s);
//		if (mapTmp != null) {
//			for (String str : mapTmp.keySet()) {
//				dd.add(str);
//			}
//		}
//		return dd;
//	}
//
//	private void hideSoft() {
//		putMethodManager imm = (InputMethodManager) context
//				.getSystemService(Context.INPUT_METHOD_SERVICE);
//		m.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,
//				InputMethodManager.HIDE_NOT_ALWAYS);
//	}
//}
