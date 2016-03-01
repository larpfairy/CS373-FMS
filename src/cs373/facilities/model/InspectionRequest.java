package cs373.facilities.model;

/**
 * An individual InspectionRequest. These are produced by people that work in
 * the facility. Once these are set inside of a Unit, calling inspectUnit runs
 * through all pending InspectionRequets. These InspectionRequests in turn
 * produce cause MaintenanceRequests, if a problem is found.
 */
public class InspectionRequest {

    private String id;
    private String description;
    private String technician;

    public void setID(String id) {
        this.id = id;
    }
    public String getID() {
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
}
