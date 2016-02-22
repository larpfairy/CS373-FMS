package cs373.facilities.model;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Schedule {

    private ArrayList<Event> eventList = new ArrayList<Event>();

    public void addEvent(Event event) {
        eventList.add(event);
    }

    public void removeEvents(LocalDateTime start, LocalDateTime stop) {
        for (int i = 0; i < eventList.size(); i++) {
            if (start.isAfter(e.get(i).getStart()) && start.isBefore(e.get(i).getStop())) {
                eventList.remove(i);
            } else if (stop.isAfter(e.get(i).getStart()) && stop.isBefore(e.get(i).getStop())) {
                eventlist.remove(i);
            }
        }
    }

    public boolean checkVacancyDuringInterval(LocalDateTime start, LocalDateTime stop) {
        for (int i = 0; i < eventList.size(); i++) {
            if (start.isAfter(e.get(i).getStart()) && start.isBefore(e.get(i).getStop())) {
                return true;
            } else if (stop.isAfter(e.get(i).getStart()) && stop.isBefore(e.get(i).getStop())) {
                return true;
            }
        }
        return false;
    }

    public String getEvents() {
        String usage;
        for (int i = 0; i < eventList.size(); i++) {
            usage += "Event " + i+1 + ": " + eventList.get(i).getDesc() + "\n"
                  +  eventList.get(i).getStart() + " - " + eventList.get(i).getStop();
        }
        return usage;
    }
}
