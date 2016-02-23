package cs373.facilities.model;

import java.time.LocalDateTime;

public class Event {
    private String description;
    private LocalDateTime start;
    private LocalDateTime stop;
    private Boolean isMaintenance;
    private double cost;

    // Constructor for regular events
    public Event(String description, LocalDateTime start, LocalDateTime stop) {
        this.description = description;
        this.start = start;
        this.stop = stop;
        this.isMaintenance = false;
        this.cost = 0;
    }

    // Constructor for Maintenance events
    public Event(String description, LocalDateTime start, LocalDateTime stop,
                 boolean isMaint, double cost) {
        this.description = description;
        this.start = start;
        this.stop = stop;
        this.isMaintenance = isMaint;
        this.cost = cost;
    }

    public void setMaintenance(boolean isMaint) {
        this.isMaintenance = isMaint;
    }
    public boolean isMaintenanceEvent() {
        return isMaintenance;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }
    public LocalDateTime getStart() {
        return start;
    }

    public void setStop(LocalDateTime stop) {
        this.stop = stop;
    }
    public LocalDateTime getStop() {
        return stop;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    public double getCost() {
        return cost;
    }

    public String getFullDescription() {
        return "Event: \t" + getDescription() + "\t\t" + getStart() +
               " - " + getStop() + " Cost: $" + getCost() + "\n";
    }
}
