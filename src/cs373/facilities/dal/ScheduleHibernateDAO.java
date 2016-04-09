package cs373.facilities.dal;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import cs373.facilities.model.Schedule;
import cs373.facilities.model.ISchedule;

public class ScheduleHibernateDAO {
	
	// Create
	public void insertSchedule(ISchedule schedule){
		System.out.println("*************** Adding Schedule to DB with ID ...  " + schedule.getID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(schedule);
		session.getTransaction().commit();
	}
	
	// Delete
	public void deleteSchedule(ISchedule schedule) {
		System.out.println("*************** Deleteing schedule from DB with ID..." + schedule.getID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(schedule);
		session.getTransaction().commit();
	}

	public Schedule getScheduleByID(int id) {
		System.out.println("*************** Retrieving schedule with ID..." + id);
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Query getScheduleQuery = session.createQuery("From Schedule id=:id");
		getScheduleQuery.setInt("id", id);

		List<?> schedulees = getScheduleQuery.list();

		session.getTransaction().commit();
		return (Schedule) schedulees.get(0);
	}
	
	// Retrieve
	public ISchedule getScheduleByID(int id){
		System.out.println("*************** Retrieving schedule with ID..." + id);
		session.beginTransaction();
		
		ISchedule retSchedule = (ISchedule) session.get(Schedule.class, id);
		retApt.getDetail();
		retApt.getFeatures().size();
		retApt.getFutureReservations().size();
		retApt.getLeases().size();
		
		session.getTransaction().commit();
		return retApt;
	}
	
	// Update
	public void updateSchedule(ISchedule schedule){
		System.out.println("********** Updating schedule with ID..." + schedule.getID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(schedule);
		session.getTransaction().commit();
	}
	
	// Delete All schedulees
	public void deleteAllSchedules(){
				
		System.out.println("************* Deleting ALL schedulees from DB ");
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String deleteAllUnits = "DELETE FROM Schedule";
		Query deleteQuery = session.createQuery(deleteAllUnits);
		
		System.out.println("************* Delete Query is ....>>\n" + deleteQuery.toString());
		int result = deleteQuery.executeUpdate();
	
		System.out.println("\nRows affected: " + result);
		
		session.getTransaction().commit();
	}
}
