package cs373.facilities.model;

//import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
//import java.time.temporal.ChronoUnit;

public class Schedule {

    private ArrayList<Event> eventList = new ArrayList<Event>();

    public void addEvent(Event event) {
        eventList.add(event);
    }

    public void removeEvents(LocalDateTime start, LocalDateTime stop) {
        for (int i = 0; i < eventList.size(); i++) {
            if (start.isAfter(eventList.get(i).getStart()) && start.isBefore(eventList.get(i).getStop())) {
                eventList.remove(i);
            } else if (stop.isAfter(eventList.get(i).getStart()) && stop.isBefore(eventList.get(i).getStop())) {
                eventList.remove(i);
            }
        }
    }

    public boolean checkVacancyDuringInterval(LocalDateTime start, LocalDateTime stop) {
        for (int i = 0; i < eventList.size(); i++) {
            if (start.isAfter(eventList.get(i).getStart()) && start.isBefore(eventList.get(i).getStop())) {
                return false;
            } else if (stop.isAfter(eventList.get(i).getStart()) && stop.isBefore(eventList.get(i).getStop())) {
                return false;
            }
        }
        return true;
    }

    public String getEvents() {
        String usage = null;
        for (int i = 0; i < eventList.size(); i++) {
            usage += "Event " + i+1 + ": " + eventList.get(i).getDescription() + "\n"
                  +  eventList.get(i).getStart() + " - " + eventList.get(i).getStop();
        }
        return usage;
    }

    public int getNumEvents() {
        return eventList.size();
    }
}
