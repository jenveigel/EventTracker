package controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.ActivityDAO;
import entities.Activity;

@RestController
public class ActivityController {
	
	@Autowired
	private ActivityDAO activityDAO;

	@RequestMapping(path="activity", method=RequestMethod.GET)
	public List<Activity> index(HttpServletResponse res){
		List<Activity> activities = activityDAO.getAllActivities();
		return activities; 
	}
	
	@RequestMapping(path="activity/{id}", method=RequestMethod.GET)
	public Activity show(@PathVariable int id, HttpServletResponse res) {
		Activity a = activityDAO.getActivityById(id);
		return a; 
	}
	
	@RequestMapping(path="activity", method=RequestMethod.POST)
	public Activity create(@RequestBody String ActivityJSON, HttpServletResponse res) {
		Activity a = activityDAO.addNewActivity(ActivityJSON);
		if (a == null) {
			res.setStatus(400);
		}
		else {
			res.setStatus(201);
		}
		return a;
	}
	
	@RequestMapping(path="activity/{id}", method=RequestMethod.PUT)
	public Activity update(@PathVariable int id, @RequestBody String activityJSON, HttpServletResponse res) {
		Activity a = activityDAO.updateActivity(id, activityJSON);
		return a;
	}
	
	@RequestMapping(path="activity/{id}", method=RequestMethod.DELETE)
	public boolean destroy(@PathVariable int id, HttpServletResponse res) {
		try {
			activityDAO.destroyActivity(id);
			return true;
		}
		catch (Exception e){
			return false;
		}
	}
}










