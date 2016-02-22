package cs373.facilities.model;

import java.util.ArrayList;
import java.util.List;

public class Facility {

    private String name;
    private Address address;
    private Boolean isVacant;
    private int capacity;
    private Schedule facilitySchedule = new Schedule();
    private Schedule maintenanceLog = new Schedule(); // keep track of maintenance that has been done on facility
    private ArrayList<MaintenanceRequest> maintRequests = new ArrayList<>();

    public Facility() {
    }
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
        // use checkVacancyDuringInterval()
        return true;
    }
    public void assignFacilityToUse(LocalDateTime start, LocalDateTime stop){
        // TODO: check that there's no conflicts first
        facilitySchecule.addEvent(start, stop);
    }
    public String listActualUsage() {
        return facilitySchedule.getEvents();
    }
    public void makeFacilityMaintRequest(String msg, double cost) {
        maintRequests.add(new MaintenanceRequest(msg, cost));
    }
    public void scheduleMaintenance() { // TODO
        // Clear events that coincide with maintenance times using removeEvents(),
        // then schedule maintenance times through addEvent()
    }
    public double calcMaintCostForFacility() {
        double cost = 0;
        for (MaintenanceRequest request : maintRequests) {
            cost += request.getCost();
        }
        return cost;
    }
    public String calcProblemRateForFacility() { // TODO
        return "To be implemented...";
    }
    public String listMaintRequests() { // TODO
        return "tobeimpl";
    }
    public String listMaintenance() { // past maint that has been done
        // TODO
    }
}
