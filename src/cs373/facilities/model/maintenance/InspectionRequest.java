package cs373.facilities.model.maintenance;

/**
 * An individual InspectionRequest. These are produced by people that work in
 * the facility. Once these are set inside of a Unit, calling inspectUnit runs
 * through all pending InspectionRequets. These InspectionRequests in turn
 * produce cause MaintenanceRequests, if a problem is found.
 */
public class InspectionRequest implements IInspectionRequest {

    private int id;
    private String description;
    private String technician;

    public InspectionRequest(int id, String descr, String technician) {
    	this.id = id;
    	this.description = descr;
    	this.technician = technician;
    }

    public void setID(int id) {
        this.id = id;
    }
    public int getID() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public void setTechnician(String technician) {
        this.technician = technician;
    }
    public String getTechnician() {
        return technician;
    }

    public String getFullDescription() {
        return "Inspection Request: " + getDescription() +
               "\t\t" + " Technician: " + getTechnician();
    }
}
