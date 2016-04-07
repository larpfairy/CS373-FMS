package cs373.facilities.model.maintenance;

public interface IInspectionRequest {

    // public InspectionRequest(String id, String descr, String technician);
    public void setID(String id);
    public String getID();
    public void setDescription(String description);
    public void setTechnician(String technician);
    public String getTechnician();
    public String getFullDescription();

}
