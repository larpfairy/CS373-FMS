package cs373.facilities.model.facility;

import cs373.facilities.model.maintenance.InspectionRequest;
import cs373.facilities.model.scheduling.Event;
import cs373.facilities.model.scheduling.Schedule;

import java.util.Random;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Unit implements IUnit {

    private String unitID;
    private int capacity;

    private Schedule schedule;
    private Schedule maintenanceSchedule;
    private List<InspectionRequest> inspectionRequests;
    private List<InspectionRequest> pastInspectionsLog;

    public Unit() {
        this.schedule = new Schedule();
        this.maintenanceSchedule = new Schedule();
        this.pastInspectionsLog = new ArrayList<>();
        this.inspectionRequests = new ArrayList<>();
    }

    public Unit(String unitID, int capacity) {
    	this.unitID = unitID;
    	this.capacity = capacity;
        this.schedule = new Schedule();
        this.maintenanceSchedule = new Schedule();
        this.pastInspectionsLog = new ArrayList<>();
        this.inspectionRequests = new ArrayList<>();
    }

    public void setUnitID(String unitID) { this.unitID = unitID; }
    public String getUnitID() { return unitID; }

    public void setCapacity(int capacity) { this.capacity = capacity; }
    public int getCapacity() { return capacity; }

    public void setSchedule(Schedule schedule) { this.schedule = schedule; }
    public String getSchedule() {
        String output = "";
        for (Event e : schedule.getEventList())
        	output += e.getFullDescription() + "\n";
        return output;
    }
    public Schedule getMaintScheduleObj() {
        return maintenanceSchedule;
    }

    public void scheduleUse(Event e) {
    	if (schedule.checkVacancyDuringInterval(e.getStart(), e.getStop())) {
    		// System.out.println("Unit " + unitID + " | Adding:\n" + e.getFullDescription());
            schedule.addEvent(e);
    	} else {
    		System.out.println("Could not add event: " + e.getDescription() + " to Unit " + unitID + ".");
    	}
    }

    public boolean getUnitVacancy(LocalDateTime start, LocalDateTime stop) {
        return schedule.checkVacancyDuringInterval(start, stop);
    }

    public void setMaintSchedule(Schedule schedule) {
        this.maintenanceSchedule = schedule;
    }
    public String getMaintenanceSchedule() {
        String output = "";
        for (Event e : maintenanceSchedule.getEventList())
            output += e.getFullDescription();
        return output;
    }

    public void addInspectionRequest(InspectionRequest request) {
        inspectionRequests.add(request);
        pastInspectionsLog.add(request);
    }
    public String getInspectionRequests() {
        String output = "";
        for (InspectionRequest r : inspectionRequests)
            output += r.getFullDescription() + "\n";
        return output;
    }

    public String getPastInspectionsLog() {
        String output = "";
        for (InspectionRequest r : pastInspectionsLog)
            output += r.getFullDescription() + "\n";
        return output;
    }

    public static Random r = new Random();

    /**
     * Runs through current inspection requests and schedules each one for
     * maintenance, randomly determining the cost and duration of the event,
     * and scheduling the event such that it does not conflict with other
     * events.
     */
    public void scheduleMaintenance() {
        for (InspectionRequest request : inspectionRequests) {
            int duration = r.nextInt(5) + 1;
            double cost  = r.nextInt(10000) + 500;
            String technician = "Billy Bob";
            LocalDateTime startMaint = schedule.findVacantInterval(duration, schedule.getBeginningOfTime());

            schedule.addEvent(
                new Event("someID",
                          request.getDescription(),
                          startMaint,
                          startMaint.plusHours(duration),
                          true,
                          technician,
                          cost
                )
            );
        }
    }
}
