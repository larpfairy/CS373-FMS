package cs373.facilities.model;

import java.time.LocalDateTime;

public class Event {

    private String description;
    private LocalDateTime start;
    private LocalDateTime stop;

    // Constructor for regular events
    public Event(String description, LocalDateTime start, LocalDateTime stop) {
        this.description = description;
        this.start = start;
        this.stop = stop;
    }

    // Constructor for Maintenance events
    public Event(String description, LocalDateTime start, LocalDateTime stop,
                 double cost) {
        this.description = description;
        this.start = start;
        this.stop = stop;
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

    public String getFullDescription() {
        return "Event: \t" + getDescription() + "\t\t" + getStart() +
               " - " + getStop();
    }
}
