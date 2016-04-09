package cs373.facilities.model.maintenance;

public interface IInspectionRequest {

    public void setID(int id);
    public int getID();
    public void setDescription(String description);
    public void setTechnician(String technician);
    public String getTechnician();
    public String getFullDescription();

}
