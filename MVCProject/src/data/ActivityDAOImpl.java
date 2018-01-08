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
		Activity a = null;
		Activity ogActivity = null;
		try {
			a = mapper.readValue(json, Activity.class);
			ogActivity = em.find(Activity.class, id);
			ogActivity.setName(a.getName());
			ogActivity.setLevel(a.getLevel());
			ogActivity.setDuration(a.getDuration());
			ogActivity.setDay(a.getDay());
//			em.persist(ogActivity);
//			return ogActivity;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ogActivity;
	}

	@Override
	public Boolean destroyActivity(int id) {
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









