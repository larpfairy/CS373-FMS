package cs373.facilities.model;

import java.time.LocalDateTime;

public class Event {
    private String description;
    private LocalDateTime start;
    private LocalDateTime stop;
    private Boolean isMaintenance;

    public Event(String description, LocalDateTime start, LocalDateTime stop) {
        this.description = description;
        this.start = start;
        this.stop = stop;
    }

    // TODO: getters & setters below
}
