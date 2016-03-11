package cs373.facilities.model;

import java.time.LocalDateTime;

public class Event {

    private String description;
    private LocalDateTime start;
    private LocalDateTime stop;
    private boolean isMaintenance;
    private String technician;
    private double cost;

    // Constructor for regular events
    public Event(String description, LocalDateTime start, LocalDateTime stop) {
        this.description = description;
        this.start = start;
        this.stop = stop;
        this.isMaintenance = false;
        this.technician = "N/A";
        this.cost = 0;
    }

    // Constructor for Maintenance events
    public Event(String description, LocalDateTime start, LocalDateTime stop,
                 Boolean isMaintenance, String technician, double cost) {
        this.description = description;
        this.start = start;
        this.stop = stop;
        this.isMaintenance = true;
        this.technician = technician;
        this.cost = cost;
    }

    public void setDescription(String description) { this.description = description; }
    public String getDescription() { return description; }

    public void setStart(LocalDateTime start) { this.start = start; }
    public LocalDateTime getStart() { return start; }

    public void setStop(LocalDateTime stop) { this.stop = stop; }
    public LocalDateTime getStop() { return stop; }

    public void setIsMaintenance(Boolean set) { this.isMaintenance = set; }
    public Boolean getIsMaintenance() { return isMaintenance; }

    public void setTechnician(String technician) { this.technician = technician; }
    public String getTechnician() { return technician; }

    public void setCost(double cost) { this.cost = cost; }
    public double getCost() { return cost; }
    
    public String getFullDescription() {
        return "Event: \t" + getDescription() + "\t\t" + getStart() +
               " - " + getStop() + " Cost: $" + getCost();
    }
}
