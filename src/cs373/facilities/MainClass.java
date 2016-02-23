package cs373.facilities;

import cs373.facilities.dal.*;
import cs373.facilities.model.*;
import java.time.LocalDateTime;

public class MainClass {

	public static void main(String[] args) {

		Facility argonneLab = new Facility("Argonne National Laboratory");

		Address cudahyAddress = new Address();
		cudahyAddress.setStreet("123 Sheridan Avenue");
		cudahyAddress.setState("IL");
		cudahyAddress.setZip("60660");
		cudahyAddress.setCity("Chicago");

		argonneLab.setAddress(cudahyAddress);

        LocalDateTime event1Start = argonneLab.getBeginningOfTime();
        LocalDateTime event1End = event1Start.plusDays(2);
		Event event1 = new Event("Accelerate protons           ", event1Start, event1End);
		argonneLab.assignFacilityToUse(event1);

        LocalDateTime event2Start = event1End.plusDays(7);
        LocalDateTime event2End = event2Start.plusDays(4);
        Event event2 = new Event("National Computing Conference", event2Start, event2End);
        argonneLab.assignFacilityToUse(event2);

        LocalDateTime event3Start = event2End.plusDays(4);
        LocalDateTime event3End = event3Start.plusDays(2);
        Event event3 = new Event("Rip apart nuclei             ", event3Start, event3End);
        argonneLab.assignFacilityToUse(event3);

        LocalDateTime event4Start = event3End.plusDays(3);
        LocalDateTime event4End = event4Start.plusDays(1);
        Event event4 = new Event("Fire up SLAC                 ", event4Start, event4End);
        argonneLab.assignFacilityToUse(event4);

        LocalDateTime event5Start = event4End.plusDays(1);
        LocalDateTime event5End = event5Start.plusDays(5);
        Event event5 = new Event("Run weather simulations      ", event5Start, event5End);
        argonneLab.assignFacilityToUse(event5);

        LocalDateTime event6Start = event5End.plusDays(4);
        LocalDateTime event6End = event6Start.plusDays(2);
        Event event6 = new Event("Collapse the wave function   ", event6Start, event6End);
        argonneLab.assignFacilityToUse(event6);

        LocalDateTime event7Start = event6End.plusDays(2);
        LocalDateTime event7End = event7Start.plusDays(2);
        Event event7 = new Event("Observe photoelectric effect ", event7Start, event7End);
        argonneLab.assignFacilityToUse(event7);

        argonneLab.makeFacilityMaintRequest("SLAC is in need of new magnets.", 100000);
        argonneLab.makeFacilityMaintRequest("Helium tanks have ruptured",  5000);
        argonneLab.makeFacilityMaintRequest("Supercomputer GPUs have melted!",  10000);

        System.out.println("Printing schedule: ");
        System.out.println(argonneLab.getSchedule().getEvents());

        System.out.println("Printing maintenance requests: ");
        System.out.println(argonneLab.listMaintRequests());

        System.out.println("Scheduling maintenance...");
        argonneLab.scheduleMaintenance();

        System.out.println("\nPrinting schedule again: ");
        System.out.println(argonneLab.getSchedule().getEvents());
        
        System.out.println("Printing maintenance log: ");
        System.out.println(argonneLab.getMaintenanceLog().getEvents());
	}
}
