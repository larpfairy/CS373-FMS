package cs373.facilities.dal;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import cs373.facilities.model.InspectionRequest;
import cs373.facilities.model.IInspectionRequest;

public class InspectionRequestHibernateDAO {
	
	// Create
	public void insertInspectionRequest(IInspectionRequest inspectionRequest){
		System.out.println("*************** Adding InspectionRequest to DB with ID ...  " + inspectionRequest.getID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(inspectionRequest);
		session.getTransaction().commit();
	}
	
	// Delete
	public void deleteInspectionRequest(IInspectionRequest inspectionRequest) {
		System.out.println("*************** Deleteing inspectionRequest from DB with ID..." + inspectionRequest.getID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(inspectionRequest);
		session.getTransaction().commit();
	}

	public InspectionRequest getInspectionRequestByID(int id) {
		System.out.println("*************** Retrieving inspectionRequest with ID..." + id);
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Query getInspectionRequestQuery = session.createQuery("From InspectionRequest id=:id");
		getInspectionRequestQuery.setInt("id", id);

		List<?> inspectionRequestes = getInspectionRequestQuery.list();

		session.getTransaction().commit();
		return (InspectionRequest) inspectionRequestes.get(0);
	}
	
	// Retrieve
	public IInspectionRequest getInspectionRequestByID(int id){
		System.out.println("*************** Retrieving inspectionRequest with ID..." + id);
		session.beginTransaction();
		
		IInspectionRequest retInspectionRequest = (IInspectionRequest) session.get(InspectionRequest.class, id);
		retApt.getDetail();
		retApt.getFeatures().size();
		retApt.getFutureReservations().size();
		retApt.getLeases().size();
		
		session.getTransaction().commit();
		return retApt;
	}
	
	// Update
	public void updateInspectionRequest(IInspectionRequest inspectionRequest){
		System.out.println("********** Updating inspectionRequest with ID..." + inspectionRequest.getID());
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(inspectionRequest);
		session.getTransaction().commit();
	}
	
	// Delete All inspectionRequestes
	public void deleteAllInspectionRequests(){
				
		System.out.println("************* Deleting ALL inspectionRequestes from DB ");
		Session session = HibernateMySQLHelper.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String deleteAllUnits = "DELETE FROM InspectionRequest";
		Query deleteQuery = session.createQuery(deleteAllUnits);
		
		System.out.println("************* Delete Query is ....>>\n" + deleteQuery.toString());
		int result = deleteQuery.executeUpdate();
	
		System.out.println("\nRows affected: " + result);
		
		session.getTransaction().commit();
	}
}
