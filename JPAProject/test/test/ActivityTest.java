package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Activity;

public class ActivityTest {
	
	private EntityManagerFactory emf;
	private EntityManager em;

	@Before
	public void setUp() throws Exception {
		emf = Persistence.createEntityManagerFactory("ActiveTrackerPU");
		em = emf.createEntityManager();
	}
	
	@After
	public void tearDown() throws Exception {
		em.close();
		emf.close();
	}
	
	@Test
	public void get_data_from_ActivityTable() {
		Activity act = em.find(Activity.class, 1);
		assertEquals("strenuous", act.getLevel());
		assertEquals(8.5, act.getDuration(), 0.1); //0.1 is degree of error allowed?
	}
}
