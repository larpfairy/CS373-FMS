package cs373.facilities.model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Facility {

    private String name;
    private Address address;
    private Boolean isVacant;
    private int capacity;
    private LocalDateTime beginningOfTime = LocalDateTime.now();
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

    public LocalDateTime getBeginningOfTime() {
        return beginningOfTime;
    }

    public int requestAvailableCapacity(LocalDateTime start, LocalDateTime stop) {
        return capacity;
    }

    public Boolean isInUseDuringInterval(LocalDateTime start, LocalDateTime stop) {
        return facilitySchedule.checkVacancyDuringInterval(start, stop);
    }

    public void assignFacilityToUse(Event event){
        if (facilitySchedule.checkVacancyDuringInterval(event.getStart(), event.getStop())) {
            facilitySchedule.addEvent(event);
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
        LocalDateTime startofMaintCycle = beginningOfTime.plusDays(10);
        for (int i = 0; i < maintRequests.size(); i++) {

            // Maintenance events occur every 7 days, and take 24 hours to complete
            LocalDateTime maintEventStart = startofMaintCycle.plusDays(i * 7);
            LocalDateTime maintEventStop  = startofMaintCycle.plusDays(i * 7 + 1);
            facilitySchedule.removeEvents(maintEventStart, maintEventStop);

            // Construct a maintenance event:
            Event maint = new Event(maintRequests.get(i).getRequest(),
                                    maintEventStart,
                                    maintEventStop,
                                    true,
                                    maintRequests.get(i).getCost());

            facilitySchedule.addEvent(maint);
            maintenanceLog.addEvent(maint);
        }
    }

    public double calcMaintCostForFacility() {
        double cost = 0;
        for (MaintenanceRequest request : maintRequests)
            cost += request.getCost();
        return cost;
    }

    public int calcProblemRateForFacility() {
        return maintenanceLog.getNumEvents() + maintRequests.size();
    }

    public String listMaintRequests() {
        String output = "";
        for (MaintenanceRequest request : maintRequests)
            output += "Maintenance Request: " + request.getRequest() + " | " + "$ " + request.getCost() + "\n";
        return output;
    }

    public Schedule getMaintenanceLog() {
        return maintenanceLog;
    }

    public Schedule getSchedule() {
        return facilitySchedule;
    }
}
