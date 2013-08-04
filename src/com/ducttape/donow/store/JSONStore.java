package com.ducttape.donow.store;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.anim;
import android.content.Context;
import android.util.Log;

import com.ducttape.donow.entity.Location;
import com.ducttape.donow.entity.Task;
import com.ducttape.donow.util.Constants;
import com.ducttape.donow.util.JSONFileUtils;

public class JSONStore implements Store {
	
	private static JSONStore store = null;
	private JSONObject object = null;
	
	private JSONStore(Context appContext) {
		JSONFileUtils jsonUtils = new JSONFileUtils();
		object = jsonUtils.loadAppJSONFile(appContext, Constants.BASENAME);		
		
		if(object == null) {
			object = new JSONObject();
			try {
				object.put(Constants.KEY_TAG, new JSONArray());
				object.put(Constants.KEY_LOCATION, new JSONArray());
				object.put(Constants.KEY_TASK, new JSONArray());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			jsonUtils.saveAppJSONFile(appContext, Constants.BASENAME, object);
		}
	}
	
	public static JSONStore getInstance(Context appContext) {
		// TODO: handle sync
		if(store == null) {
			store = new JSONStore(appContext);
		}
		return store;
	}

	@Override
	public String getTag(int tagId) {
		
		try {
			JSONArray tags = object.getJSONArray(Constants.TAG);
			return (String) tags.get(tagId);
		} catch (JSONException e) {
			Log.e(Constants.TAG, "JSONStore : getTag, error: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Location getLocation(int locationId) {
		try {
			JSONArray locArray = object.getJSONArray(Constants.TAG);
			JSONObject loc =  locArray.getJSONObject(locationId);
			return new Location(loc);
		} catch (JSONException e) {
			Log.e(Constants.TAG, "JSONStore : getLocation, error: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Task getTask(int taskId) {
		try {
			JSONArray taskArray = object.getJSONArray(Constants.TAG);
			JSONObject taskObject =  taskArray.getJSONObject(taskId);
			Task task = new Task();
			task.task = taskObject.getString(Constants.KEY_TASK_NAME);
			int id = taskObject.getInt(Constants.KEY_TASK_TAG);
			task.tag = getTag(id);
			task.status = taskObject.getInt(Constants.KEY_TASK_STATUS);
			id = taskObject.getInt(Constants.KEY_TASK_LOCATION);
			task.location = getLocation(id);
			return task;
		} catch (JSONException e) {
			Log.e(Constants.TAG, "JSONStore : getTask, error: " + e.getMessage());
			return null;
		}
	}

	@Override
	public boolean addTag(String tag) {
		try {
			JSONArray tags = object.getJSONArray(Constants.KEY_TAG);
			tags.put(tag);
			return true;
		} catch (JSONException e) {
			Log.e(Constants.TAG, "JSONStore : addTag, error: " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean addLocation(Location location) {
		
		try {
			JSONArray locations = object.getJSONArray(Constants.KEY_LOCATION);
			locations.put(location.getJson());
			return true;
		} catch (JSONException e) {
			Log.e(Constants.TAG, "JSONStore : addLocation, error: " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean addTask(Task task) {
		try {
			JSONArray tasks = object.getJSONArray(Constants.KEY_TASK);
			tasks.put(task.getJson());
			return true;
		} catch (JSONException e) {
			Log.e(Constants.TAG, "JSONStore : addTask, error: " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateTag(int tagId, String tag) {
		try {
			JSONArray tags = object.getJSONArray(Constants.KEY_TAG);
			tags.put(tagId, tag);
			return true;
		} catch (JSONException e) {
			Log.e(Constants.TAG, "JSONStore : addTask, error: " + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateLocation(int locationId, Location location) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTask(int taskId, Task task) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTag(int tagId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLocation(int locationId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTask(int taskId) {
		// TODO Auto-generated method stub
		return false;
	}
}
