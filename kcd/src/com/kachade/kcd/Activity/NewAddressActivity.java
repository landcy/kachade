package com.kachade.kcd.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.kachade.framework.app.BaseActivity;
import com.kachade.kcd.R;
import com.kachade.view.PageTiltleView;

public class NewAddressActivity extends BaseActivity {
	private PageTiltleView mTilte;

	private EditText mName;
	private EditText mNum;
	private EditText mDetailAddress;
	private Spinner mSpinnerProvince;
	private Spinner mSpinnerCity;

	private static final String[] colors = { "红色", "黄色", "蓝色", "绿色" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_address);
		mTilte = (PageTiltleView) this.findViewById(R.id.title);

		mName = (EditText) this.findViewById(R.id.name_ed);
		mNum = (EditText) this.findViewById(R.id.num_ed);
		mDetailAddress = (EditText) this.findViewById(R.id.detail_address_ed);

		mSpinnerProvince = (Spinner) findViewById(R.id.spinnerProvince);
		mSpinnerCity = (Spinner) findViewById(R.id.spinnerCity);
		// 将可选内容与ArrayAdapter连接起来
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, colors);
		// 将adapter 添加到spinner中
		mSpinnerProvince.setAdapter(adapter);
		// 添加Spinner事件监听器
		mSpinnerProvince.setOnItemSelectedListener(new ColorListener());

		// 获取spinnerSeason对象
		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
				this, R.array.season, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// 设置下拉列表的风格
		mSpinnerCity.setAdapter(adapter2);
		mSpinnerCity.setOnItemSelectedListener(new SeasonListener());

		setLis();
	}

	private void setLis() {
		OnClickListener onClickLis = new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				int id = arg0.getId();
				switch (id) {

				case R.id.back_iv:
					finish();
					break;
				}
			}
		};
		mTilte.setBackListener(onClickLis);
	}

	private class ColorListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			// tv.setText("您选择的颜色是:"+arg2);
		}

		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub

		}
	}

	private class SeasonListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			// Toast用于向用户显示一些帮助/提示。
			// Toast.makeText(MainActivity.this,
			// "Spinner2的位置:"+arg2,Toast.LENGTH_LONG).show();
		}

		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub

		}
	}
}
