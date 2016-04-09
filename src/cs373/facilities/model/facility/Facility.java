package cs373.facilities.model.facility;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import cs373.facilities.model.scheduling.Event;
import cs373.facilities.model.scheduling.Schedule;

public class Facility implements IFacility {

    private int id;
    private String name;
    private Address address;
    private String manager;
    private List<Unit> units;
    private LocalDateTime beginningOfTime;

    public Facility() {
        this.name  = "";
        this.units = new ArrayList<>();
        this.beginningOfTime = LocalDateTime.now(); 
    }

    public Facility(String name) {
    	this.name = name;
        this.units = new ArrayList<>();
        this.beginningOfTime = LocalDateTime.now();
    }

    public int getID() { return id; }
    public void setID(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address.getFullAddress(); }
    public void setAddress(Address address) { this.address = address; }

    public String getManager() { return manager; }
    public void setManager(String manager) { this.manager = manager; }

    public LocalDateTime getBeginningOfTime() { return beginningOfTime; }

    public void addUnit(Unit unit) { this.units.add(unit); }
    public String listUnits() {
        String output = "";
        for (Unit u : units)
            output += "Unit: " + u.getID() + " | Capacity: " + u.getCapacity() + "\n";
        return output;
    }

    public String getSchedules() {
        String output = "";
        for (Unit u : units)
            output += u.getID() + "\n" + u.getSchedule();
        return output;
    }

    public void scheduleMaintenance() {
        for (Unit u : units)
            u.scheduleMaintenance();
    }

    public String listAvailableUnits(LocalDateTime start, LocalDateTime stop) {
        System.out.println("The following are available during " + start.toString()
                            + " - " + stop.toString());
        String output = "";
        for (Unit u : units) {
            if (u.getUnitVacancy(start, stop)) {
                output += "Unit: " + u.getID() + " | Capacity: " + u.getCapacity() + "\n";
            }
        }
        return output;
    }

    public double calcMaintCostForFacility() {
        double cost = 0;
        for (Unit u : units) {
            Schedule maintenanceSchedule = u.getMaintScheduleObj();
            for (Event e : maintenanceSchedule.getEventList()) {
                cost += e.getCost();
            }
        }
        return cost;
    }

    public int calcProblemRateForFacility() {
        return 0;
    }

    public String listInspectionRequests() {
        String output = "Inspection Requests\n";
        for (Unit u : units)
            output += u.getInspectionRequests();
        return output;
    }

    public String listScheduledMaintenance() {
        String output = "Maintenance Events\n";
        for (Unit u : units) {
            Schedule maintSchedule = u.getMaintScheduleObj();
            for (Event e : maintSchedule.getEventList()) {
            	if (e.getIsMaintenance())
            		output += e.getFullDescription();
            }
        }
        return output;
    }
}
// public class Facility {
//
//     public int requestAvailableCapacity(LocalDateTime start, LocalDateTime stop) {
//         return capacity;
//     }
//
//     public void assignFacilityToUse(Event event){
//         if (facilitySchedule.checkVacancyDuringInterval(event.getStart(), event.getStop())) {
//             facilitySchedule.addEvent(event);
//         } else {
//             System.out.println("Could not schedule event due to conflict!");
//         }
//     }
//
//     public String listActualUsage() {
//         return facilitySchedule.getEvents();
//     }
//
//     public void makeFacilityMaintRequest(String msg, double cost) {
//         maintRequests.add(new MaintenanceRequest(msg, cost));
//     }
//
//     public int calcProblemRateForFacility() {
//         return maintenanceLog.getNumEvents() + maintRequests.size();
//     }
//
//
//     public Schedule getMaintenanceLog() {
//         return maintenanceLog;
//     }
// }
