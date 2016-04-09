package cs373.facilities.model.scheduling;

import java.util.List;
import java.time.LocalDateTime;

public interface ISchedule {

	public int getID();
	public void setID(int id);
    public void setBeginningOfTime(LocalDateTime time);
    public LocalDateTime getBeginningOfTime();
    public void addEvent(Event event);
    public String getEvents();
    public List<Event> getEventList();
    public int getNumEvents();

    public void removeEvents(LocalDateTime start, LocalDateTime stop);

    public boolean checkVacancyDuringInterval(LocalDateTime start, LocalDateTime stop);

    public LocalDateTime findVacantInterval(int hours, LocalDateTime beginningOfTime);
}
