package cs373.facilities.model.scheduling;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Schedule implements ISchedule {

    private List<Event> eventList;
    private LocalDateTime beginningOfTime;

    public Schedule() {
        this.beginningOfTime = LocalDateTime.now();
        this.eventList = new ArrayList<>();
    }

    public Schedule(LocalDateTime beginningOfTime) {
        this.beginningOfTime = LocalDateTime.now();
        this.eventList = new ArrayList<Event>();
    }

    public void setBeginningOfTime(LocalDateTime time) {
        this.beginningOfTime = time;
    }
    public LocalDateTime getBeginningOfTime() {
        return beginningOfTime;
    }

    public void addEvent(Event event) {
        eventList.add(event);
    }
    public String getEvents() {
        String usage = "";
        for (int i = 0; i < eventList.size(); i++) {
            usage += eventList.get(i).getFullDescription();
        }
        return usage;
    }
    public List<Event> getEventList() {
        return eventList;
    }
    public int getNumEvents() {
        return eventList.size();
    }

    public void removeEvents(LocalDateTime start, LocalDateTime stop) {
        for (int i = 0; i < eventList.size(); i++) {
            if (start.isAfter(eventList.get(i).getStart()) && start.isBefore(eventList.get(i).getStop())) {
                System.out.println("Removing event due to conflict with maintenance: " + eventList.get(i).getDescription());
                eventList.remove(i);
            } else if (stop.isAfter(eventList.get(i).getStart()) && stop.isBefore(eventList.get(i).getStop())) {
                System.out.println("Removing event due to conflict with maintenance: " + eventList.get(i).getDescription());
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

    public LocalDateTime findVacantInterval(int hours, LocalDateTime beginningOfTime) {
        LocalDateTime head = beginningOfTime;
        for (int i = 0; i < eventList.size(); i++) {
            if (checkVacancyDuringInterval(head, head.plusHours(hours))) {
                return head;
            } else {
                head = eventList.get(i).getStop().plusMinutes(30);
            }
        }
        return head;
    }
}
