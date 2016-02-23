package cs373.facilities;

import cs373.facilities.dal.*;
import cs373.facilities.model.*;
import cs373.facilities.view.*;
import java.time.LocalDateTime;

public class MainClass {

	public static void main(String[] args) {

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
