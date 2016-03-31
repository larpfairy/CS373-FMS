package cs373.facilities.model.facility;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import cs373.facilities.model.scheduling.Event;
import cs373.facilities.model.scheduling.Schedule;

public class Facility {

    public String getName();
    public void setName(String name);

    public String getAddress();
    public void setAddress(Address address);

    public String getManager();
    public void setManager(String manager);

    public LocalDateTime getBeginningOfTime();

    public void addUnit(Unit unit);
    public String listUnits();

    public String getSchedules();

    public void scheduleMaintenance();
    public String listAvailableUnits(LocalDateTime start, LocalDateTime stop);

    public double calcMaintCostForFacility();

    public int calcProblemRateForFacility();

    public String listInspectionRequests();

    public String listScheduledMaintenance();
    
}
