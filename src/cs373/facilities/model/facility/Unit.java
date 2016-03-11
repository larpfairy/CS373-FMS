package cs373.facilities.model.facility;

import cs373.facilities.model.InspectionRequest;
import cs373.facilities.model.MaintenanceRequest;
import cs373.facilities.model.Schedule;

public class Unit {

    private String ID;
    private int capacity;

    private Schedule schedule;
    private Schedule maintenanceSchedule;
    private List<InspectionRequest> inspectionRequests;
    private List<InspectionRequest> pastInspectionsLog;

    Unit() {
        this.schedule = new Schedule();
        this.maintenanceSchedule = new Schedule();
        this.inspectionLog = new List<>();
        this.inspectionRequests = new List<>();
    }

    public void setID(String id) { this.ID = id; }
    public String getID() { return ID; }

    public void setCapacity(int capacity) { this.capacity = capacity; }
    public int getCapacity() { return capacity; }

    public void setSchedule(Schedule schedule) { this.schedule = schedule; }
    public String getSchedule() {
        string output = "";
        for (Event e : schedule) {
            output += e.getFullDescription();
        }
        return output;
    }

    public void scheduleUse(Event e) {
        if (schedule.checkVacancyDuringInterval(e.getStart(), e.getStop())) {
            System.out.println("Unit " + ID + " | Adding:\n" + event.getFullDescription());
            schedule.add(event);
        } else {
            System.out.println("Could not add event: " + e.getDescription() + " to Unit " + ID + ".");
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
        for (Event e : maintenanceSchedule) {
            output += e.getFullDescription(); // TODO: Incorporate cost stuff
        }
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
        String output = ""
        for (InspectionRequest r : pastInspectionsLog)
            output += r.getFullDescription() + "\n";
        return output;
    }

    public void scheduleMaintenance() {
        for (InspectionRequest r : inspectionRequests)
            schedule.addEvent()
    }
}
