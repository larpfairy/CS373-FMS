package cs373.facilities;

import cs373.facilities.dal.*;
import cs373.facilities.model.*;
import java.time.LocalDateTime;

public class MainClass {

	public static void main(String[] args) {
		
		System.out.println("Hello world!");

		Facility cudahyScience = new Facility("Cudahy Science");

		Address cudahyAddress = new Address();
		cudahyAddress.setStreet("123 Sheridan Avenue");
		cudahyAddress.setState("IL");
		cudahyAddress.setZip("60660");
		cudahyAddress.setCity("Chicago");

		cudahyScience.setAddress(cudahyAddress);

        LocalDateTime event1Start = cudahyScience.getBeginningOfTime();
        LocalDateTime event1End = event1Start.plusDays(2);
		Event event1 = new Event("Accelerate protons", event1Start, event1End);
		cudahyScience.assignFacilityToUse(event1);
		
        LocalDateTime event2Start = cudahyScience.getBeginningOfTime().plusDays(5);
        LocalDateTime event2End = event2Start.plusDays(4);
        Event event2 = new Event("Conference", event2Start, event2End);
        cudahyScience.assignFacilityToUse(event2);
        System.out.println("Printing schedule: ");
        System.out.println(cudahyScience.getSchedule().getEvents());
        		
	}
}
