package cs373.facilities.model;

import java.util.ArrayList;
import java.util.List;

public class Facility {

    private String name;
    private Address address;
    private Boolean isVacant;
    private int capacity;
    private Schedule facilitySchedule = new Schedule();
    private Schedule inspectionSchedule = new Schedule();
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

    public int requestAvailableCapacity(){
    	return capacity;
    }
    public Boolean isInUseDuringInterval(){
    	return true;
    }
    public void assignFacilityToUse(String start, String stop){
    	facilitySchecule.addEvent(start, stop);
    }
    public String listActualUsage(){
    	String usage;
    	for(int i = 0; i < facilitySchedule.getSize(); i++){

    	}
    }
    public void makeFacilityMaintRequest(String msg, double cost) {
        maintRequests.add(msg)
    }
    public void scheduleMaintenance() {
        // TODO
    }
    public double calcMaintCostForFacility() {
        double cost = 0;
        for (MaintenanceRequest request : maintRequests) {
            cost += request.getCost();
        }
        return cost;
    }
    public String calcProblemRateForFacility() {
        return "To be implemented...";
    }
    public String listMaintRequests() {

    }
    public String listMaintenance() { // past maint that has been done

    }
}
