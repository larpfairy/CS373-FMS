package cs373.facilities.model.facility;

import java.time.LocalDateTime;

public interface IFacility {

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
