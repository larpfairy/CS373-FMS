package cs373.facilities;

import cs373.facilities.dal.*;
import cs373.facilities.model.*;
import cs373.facilities.view.*;
import java.time.LocalDateTime;

public class MainClass {

	public static void main(String[] args) {
//		System.out.println("Hello world!");
//		
//		Schedule schedule = new Schedule();
//		System.out.println("Successfully instantiated: Schedule()");
//		
//		MaintenanceRequest maintreq = new MaintenanceRequest("thisisadescription", 3.0);
//		System.out.println(maintreq.getRequest());
//		System.out.println(maintreq.getCost());
//		System.out.println("Successfully instantiated: MaintenanceRequest!");
//		
//		Facility cudahyScience = new Facility("Cudahy Science");
//		System.out.println(cudahyScience.getFacilityName());
		
		Facility cudahyScience = new Facility("Cudahy Science");
		
		Address cudahyAddress = new Address();
		cudahyAddress.setStreet("123 Sheridan Avenue");
		cudahyAddress.setState("IL");
		cudahyAddress.setZip("60660");
		cudahyAddress.setCity("Chicago");
		
		cudahyScience.setAddress(cudahyAddress);
		
		System.out.println(cudahyScience.getAddress().getFullAddress());
		
		
	}
}
