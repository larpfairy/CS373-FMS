package cs373.facilities.model.facility;

import cs373.facilities.model.maintenance.InspectionRequest;
import cs373.facilities.model.scheduling.Event;
import cs373.facilities.model.scheduling.Schedule;

import java.time.LocalDateTime;

public interface IUnit {

    public String getUnitID();
    public void setUnitID(String unitID);

    public int getCapacity();
    public void setCapacity(int capacity);

    public String getSchedule();
    public void setSchedule(Schedule schedule);

    public void scheduleUse(Event e);

    public boolean getUnitVacancy(LocalDateTime start, LocalDateTime stop);

    public Schedule getMaintScheduleObj();
    public String getMaintenanceSchedule();
    public void setMaintSchedule(Schedule schedule);

    public String getInspectionRequests();
    public void addInspectionRequest(InspectionRequest request);

    public String getPastInspectionsLog();

    public void scheduleMaintenance();

}
