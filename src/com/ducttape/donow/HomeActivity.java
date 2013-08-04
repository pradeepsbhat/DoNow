package com.ducttape.donow;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class HomeActivity extends FragmentActivity {

	HomePagerAdapter mHomePagerAdapter;
	ViewPager mViewPager;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_home);
			    
		// ViewPager and its adapters use support library
		// fragments, so use getSupportFragmentManager.
		mHomePagerAdapter = new HomePagerAdapter(getSupportFragmentManager());
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mHomePagerAdapter);
	}

	public class HomePagerAdapter extends FragmentPagerAdapter {

		public static final int TAB_LOCATION = 0;
		public static final int TAB_TAG = 1;
		public static final int NUM_TABS = 2;

		public HomePagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int index) {
			Fragment fragment = null;

			// choose screen based on index
			if(index == TAB_TAG) {
				fragment = new TagFragment();
			} else {
				fragment = new LocationFragment();
			}
			return fragment;
		}

		@Override
		public int getCount() {
			return NUM_TABS;
		}
	}
}

