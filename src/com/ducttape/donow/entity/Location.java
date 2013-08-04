package com.ducttape.donow.entity;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.ducttape.donow.util.Constants;

public class Location {

	public String name;
	public double latitude;
	public double longitude;
	public double radius;
	public JSONObject json;

	public Location() {

	}
	public Location(JSONObject loc) throws JSONException {
		json = loc;
		name = loc.getString(Constants.KEY_LOCATION_NAME);
		latitude = loc.getDouble(Constants.KEY_LATITUDE);
		longitude = loc.getDouble(Constants.KEY_LONGITUDE);
		radius = loc.getDouble(Constants.KEY_RADIUS);

	}
	public JSONObject getJson() throws JSONException {
		if(json == null) {
			json = new JSONObject();
			json.put(Constants.KEY_LOCATION_NAME, name);
			json.put(Constants.KEY_LATITUDE, latitude);
			json.put(Constants.KEY_LONGITUDE, longitude);
			json.put(Constants.KEY_RADIUS, radius);
		}
		return json;
	}
}
