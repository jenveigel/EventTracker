package data;

import java.util.List;

import entities.Activity;

public interface ActivityDAO {

	public List<Activity> getAllActivities();
	
	public Activity getActivityById(int id);
	
	public Activity addNewActivity(String json);
	
	public Activity updateActivity(int id, String json);
	
	public void destroyActivity(int id);
	
}
