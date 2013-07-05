package com.ducttape.donow;

import com.ducttape.donow.util.Constants;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LocationFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		
		Log.i(Constants.TAG, "LocationFragment : onCreateView");
		
		View rootView = inflater.inflate(
				R.layout.layout_location, container, false);
		
		Bundle args = getArguments();
		if(args != null) {
			// use args
		}
		
		((TextView) rootView.findViewById(R.id.location_text)).setText("Todo by location");
		
		return rootView;
	}
	
	@Override
	public void onResume() {
	    super.onResume();
	    Log.i(Constants.TAG, "LocationFragment : onResume");
	    // Set title
	    getActivity().getActionBar().setTitle(R.string.title_location);
	}
}
