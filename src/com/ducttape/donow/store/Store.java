package com.ducttape.donow.store;

import com.ducttape.donow.entity.Location;
import com.ducttape.donow.entity.Task;

public interface Store {

	// GET
	public String getTag(int tagId);

	public Location getLocation(int locationId);

	public Task getTask(int taskId);

	// ADD
	public boolean addTag(String tag);

	public boolean addLocation(Location location);

	public boolean addTask(Task task);

	// UPDATE
	public boolean updateTag(int tagId, String tag);
	
	public boolean updateLocation(int locationId, Location location);
	
	public boolean updateTask(int taskId, Task task);
	
	// DELETE
	public boolean deleteTag(int tagId);
	
	public boolean deleteLocation(int locationId);
	
	public boolean deleteTask(int taskId);
}
