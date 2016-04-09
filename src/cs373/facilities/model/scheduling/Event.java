package cs373.facilities.model.scheduling;

import java.time.LocalDateTime;

public class Event implements IEvent {

    private String eventID;
    private String description;
    private LocalDateTime start;
    private LocalDateTime stop;
    private boolean isMaintenance;
    private String technician;
    private double cost;

    public Event() {}

    // Constructor for regular events
    public Event(String eventID,
                 String description,
                 LocalDateTime start,
                 LocalDateTime stop) {
        this.eventID = eventID;
        this.description = description;
        this.start = start;
        this.stop = stop;
        this.isMaintenance = false;
        this.technician = "N/A";
        this.cost = 0;
    }

    // Constructor for Maintenance events
    public Event(String eventID, String description,
                 LocalDateTime start, LocalDateTime stop,
                 Boolean isMaintenance, String technician,
                 double cost) {
        this.eventID = eventID;
        this.description = description;
        this.start = start;
        this.stop = stop;
        this.isMaintenance = true;
        this.technician = technician;
        this.cost = cost;
    }

    public String getEventID() { 
        return eventID;
    }
    public void setEventID(String eventid) {
        this.eventID = eventid; 
    }

    public String getDescription() { 
        return description; 
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStart() {
        return start;
    }
    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getStop() { 
        return stop;
    }
    public void setStop(LocalDateTime stop) {
        this.stop = stop;
    }

    public Boolean getIsMaintenance() {
        return isMaintenance;
    }
    public void setIsMaintenance(Boolean set) {
        this.isMaintenance = set;
    }

    public String getTechnician() {
        return technician;
    }
    public void setTechnician(String technician) {
        this.technician = technician;
    }

    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getFullDescription() {
        return "Event: \t" + getDescription() + "\t\t" + getStart() +
               " - " + getStop() + " Cost: $" + getCost();
    }
}
