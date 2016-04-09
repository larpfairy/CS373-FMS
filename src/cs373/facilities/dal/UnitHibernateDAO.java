package cs373.facilities.dal;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import cs373.facilities.model.Unit;
import cs373.facilities.model.IUnit;

public class UnitHibernateDAO {
	
	// Create
	public void insertUnit(IUnit unit){
		System.out.println("*************** Adding Unit to DB with ID ...  " + unit.getID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(unit);
		session.getTransaction().commit();
	}
	
	// Delete
	public void deleteUnit(IUnit unit) {
		System.out.println("*************** Deleteing unit from DB with ID..." + unit.getID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(unit);
		session.getTransaction().commit();
	}

	public Unit getUnitByID(int id) {
		System.out.println("*************** Retrieving unit with ID..." + id);
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Query getUnitQuery = session.createQuery("From Unit id=:id");
		getUnitQuery.setInt("id", id);

		List<?> unites = getUnitQuery.list();

		session.getTransaction().commit();
		return (Unit) unites.get(0);
	}
	
	// Retrieve
	public IUnit getUnitByID(int id){
		System.out.println("*************** Retrieving unit with ID..." + id);
		session.beginTransaction();
		
		IUnit retUnit = (IUnit) session.get(Unit.class, id);
		retApt.getDetail();
		retApt.getFeatures().size();
		retApt.getFutureReservations().size();
		retApt.getLeases().size();
		
		session.getTransaction().commit();
		return retApt;
	}
	
	// Update
	public void updateUnit(IUnit unit){
		System.out.println("********** Updating unit with ID..." + unit.getID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(unit);
		session.getTransaction().commit();
	}
	
	// Delete All unites
	public void deleteAllUnits(){
				
		System.out.println("************* Deleting ALL units from DB ");
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String deleteAllUnits = "DELETE FROM Unit";
		Query deleteQuery = session.createQuery(deleteAllUnits);
		
		System.out.println("************* Delete Query is ....>>\n" + deleteQuery.toString());
		int result = deleteQuery.executeUpdate();
	
		System.out.println("\nRows affected: " + result);
		
		session.getTransaction().commit();
	}
}
