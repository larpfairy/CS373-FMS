package cs373.facilities.model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Facility {

    private String name;
    private Address address;
    private Boolean isVacant;
    private int capacity;
    private Schedule facilitySchedule = new Schedule();
    private Schedule maintenanceLog = new Schedule();
    private ArrayList<MaintenanceRequest> maintRequests = new ArrayList<>();

    public Facility(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacilityName() {
        return name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public int requestAvailableCapacity(LocalDateTime start, LocalDateTime stop) {
    	return capacity;
    }

    public Boolean isInUseDuringInterval(LocalDateTime start, LocalDateTime stop) {
        return facilitySchedule.checkVacancyDuringInterval(start, stop);
    }

    public void assignFacilityToUse(Event event){
        if (checkVacancyDuringInterval(event.getStart(), event.getStop())) {
            facilitySchedule.addEvent(start, stop);
        } else {
            System.out.println("Could not schedule event due to conflict!");
        }
    }

    public String listActualUsage() {
        return facilitySchedule.getEvents();
    }

    public void makeFacilityMaintRequest(String msg, double cost) {
        maintRequests.add(new MaintenanceRequest(msg, cost));
    }

    public void scheduleMaintenance() {
        // Clear events that coincide with maintenance times using removeEvents(),
        // then schedule maintenance times through addEvent(). However, need to figure
        // out way of determining where to place maintenance and how much time it'll
        // take.
    }

    public double calcMaintCostForFacility() {
        double cost = 0;
        for (MaintenanceRequest request : maintRequests)
            cost += request.getCost();
        return cost;
    }

    public String calcProblemRateForFacility() { // TODO
        return "To be implemented...";
    }

    public String listMaintRequests() {
        String output;
        for (MaintenanceRequest request : maintRequests)
            output += request.getRequest() + " | " + "$ " + request.getCost();
        return output;
    }

    public String getMaintenanceLog() { // TODO: These will likely have dates and costs, too
        String output;
        for (MaintenanceRequest request : maintRequests)
            output += request.getRequest() + " | " + "$ " + request.getCost();
        return output;
    }
}
