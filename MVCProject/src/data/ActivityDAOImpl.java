package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Activity;

@Transactional
@Repository
public class ActivityDAOImpl implements ActivityDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Activity> getAllActivities() {
		String query = "SELECT a from Activity a";
		List<Activity> activities = em.createQuery(query, Activity.class)
				.getResultList();
		return activities;
	}

//why don't we have to do query with this one?
	@Override 
	public Activity getActivityById(int id) {
		Activity a = em.find(Activity.class, id);
		return a;
	}

	@Override
	public Activity addNewActivity(String json) {
		ObjectMapper mapper = new ObjectMapper();
		Activity newActivity = null;
		try {
			newActivity = mapper.readValue(json, Activity.class);
			em.persist(newActivity);
			em.flush();
			return newActivity;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Activity updateActivity(int id, String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Activity a = mapper.readValue(json, Activity.class);
			Activity updatedActivity = em.find(Activity.class, id);
			updatedActivity.setName(a.getName());
			updatedActivity.setLevel(a.getLevel());
			updatedActivity.setDuration(a.getDuration());
			updatedActivity.setDay(a.getDay());
			em.persist(updatedActivity);
			return updatedActivity;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean destroyActivity(int id) {
		Activity a = em.find(Activity.class, id);
		try {
			em.remove(a);
			return true;
		}
		catch (Exception e) {
			return false;
		}
		
	}

}









