package com.ducttape.donow;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ducttape.donow.util.Constants;

public class TagFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		
		Log.i(Constants.TAG, "TagFragment : onCreateView");
		
		View rootView = inflater.inflate(
				R.layout.layout_tag, container, false);
		
		Bundle args = getArguments();
		if(args != null) {
			// use args
		}
		
		((TextView) rootView.findViewById(R.id.tag_text)).setText("Todo by tags");
		
		return rootView;
	}
	
	@Override
	public void onResume() {
	    super.onResume();
	    Log.i(Constants.TAG, "TagFragment : onResume");
	    // Set title
	    getActivity().getActionBar().setTitle(R.string.title_tag);
	}
}
