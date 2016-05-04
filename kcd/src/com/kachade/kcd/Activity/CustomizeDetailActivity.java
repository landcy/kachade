package com.kachade.kcd.Activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;

import com.kachade.framework.app.BaseActivity;
import com.kachade.kcd.R;
import com.kachade.view.PageTiltleView;

public class CustomizeDetailActivity extends BaseActivity {
	private PageTiltleView mTilte;

	// private TabLayout tabLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_customize_detail);
		mTilte = (PageTiltleView) this.findViewById(R.id.title);
		// ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
		// if (viewPager != null) {
		// setupViewPager(viewPager);
		// }
		// setupTabLayout();
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

	//
	// //设置tablayout，
	// private void setupTabLayout() {
	// tabLayout = (TabLayout) view.findViewById(R.id.tabs);
	// tabLayout.setupWithViewPager(viewPager);
	// //一下几个重要属性都可以自己选择性进行设置。
	// //tabLayout.setSelectedTabIndicatorColor();
	// //tabLayout.setSelectedTabIndicatorHeight();
	// //tabLayout.setOnTabSelectedListener();
	// //tabLayout.setTabGravity();
	// //tabLayout.setTabTextColors(int normalColor,int selectColor);
	// //将tablayout与viewpager进行绑定，下面会有讲解。
	// tabLayout.setupWithViewPager(viewPager);
	// }
	// //设置viewpager
	// private void setupViewPager(ViewPager viewPager) {
	// Adapter adapter = new Adapter(getActivity().getSupportFragmentManager());
	// adapter.addFragment(new CheeseListFragment(), "Category 1");
	// adapter.addFragment(new CheeseListFragment(), "Category 2");
	// adapter.addFragment(new CheeseListFragment(), "Category 3");
	// viewPager.setAdapter(adapter);
	// }
	// //设置viewpager的adapter
	// static class Adapter extends FragmentPagerAdapter {
	// private final List<Fragment> mFragments = new ArrayList<>();
	// private final List<String> mFragmentTitles = new ArrayList<>();
	// public Adapter(FragmentManager fm) {
	// super(fm);
	// }
	// public void addFragment(Fragment fragment, String title) {
	// mFragments.add(fragment);
	// mFragmentTitles.add(title);
	// }
	// @Override
	// public Fragment getItem(int position) {
	// return mFragments.get(position);
	// }
	// @Override
	// public int getCount() {
	// return mFragments.size();
	// }
	// @Override
	// public CharSequence getPageTitle(int position) {
	// return mFragmentTitles.get(position);
	// }
	// }

}