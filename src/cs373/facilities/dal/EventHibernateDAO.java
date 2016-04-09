package cs373.facilities.dal;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import cs373.facilities.model.Event;
import cs373.facilities.model.IEvent;

public class EventHibernateDAO {
	
	// Create
	public void insertEvent(IEvent event){
		System.out.println("*************** Adding Event to DB with ID ...  " + event.getID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(event);
		session.getTransaction().commit();
	}
	
	// Delete
	public void deleteEvent(IEvent event) {
		System.out.println("*************** Deleteing event from DB with ID..." + event.getID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(event);
		session.getTransaction().commit();
	}

	public Event getEventByID(int id) {
		System.out.println("*************** Retrieving event with ID..." + id);
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Query getEventQuery = session.createQuery("From Event id=:id");
		getEventQuery.setInt("id", id);

		List<?> eventes = getEventQuery.list();

		session.getTransaction().commit();
		return (Event) eventes.get(0);
	}
	
	// Retrieve
	public IEvent getEventByID(int id){
		System.out.println("*************** Retrieving event with ID..." + id);
		session.beginTransaction();
		
		IEvent retEvent = (IEvent) session.get(Event.class, id);
		retApt.getDetail();
		retApt.getFeatures().size();
		retApt.getFutureReservations().size();
		retApt.getLeases().size();
		
		session.getTransaction().commit();
		return retApt;
	}
	
	// Update
	public void updateEvent(IEvent event){
		System.out.println("********** Updating event with ID..." + event.getID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(event);
		session.getTransaction().commit();
	}
	
	// Delete All eventes
	public void deleteAllEvents(){
				
		System.out.println("************* Deleting ALL eventes from DB ");
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String deleteAllUnits = "DELETE FROM Event";
		Query deleteQuery = session.createQuery(deleteAllUnits);
		
		System.out.println("************* Delete Query is ....>>\n" + deleteQuery.toString());
		int result = deleteQuery.executeUpdate();
	
		System.out.println("\nRows affected: " + result);
		
		session.getTransaction().commit();
	}
}
