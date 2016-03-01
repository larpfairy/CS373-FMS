package cs373.facilities.model.facility;

import cs373.facilities.model.InspectionRequest;
import cs373.facilities.model.MaintenanceRequest;
import cs373.facilities.model.Schedule;

public class Unit {

    private String id;
    private int floor;
    private int capacity;
    private boolean isVacant;
    private Schedule unitSchedule = new Schedule();
    private Schedule maintenanceLog = new Schedule();
    private List<MaintenanceRequest> maintRequests  = new ArrayList<>();
    private List<InspectionRequest> inspectRequests = new ArrayList<>();

    public String getUnitID() {
        return id;
    }
    public void setUnitID(String id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }
    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean getVacancy() {
        return isVacant;
    }
    public void setVacancy(boolean vacancy) {
        this.isVacant = vacancy;
    }

    public Schedule getSchedule() {
        return unitSchedule;
    }

    /**
     * Runs through inspectRequests and schedules each inspection request in the
     * main schedule.
     */
    public void inspectUnit() {
        for (InspectionRequest request : inspectRequests) {
            // Construct a MaintenanceEvent from each one, rather than a MaintenanceRequest
            // -- there shouldn't be additional requests to go through once the unit has
            // been inspected. 
        }
    }
}
