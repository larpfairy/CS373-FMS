package cs373.facilities.model;

// Probably won't use interfaces just yet -- useful to keep track
// of methods that we'll implement though
public interface IFacility {

	public String getFacilityName();
	public Address getAddress();
	public List<String> getUnits();
	public List<String> getMaintenanceRequests();

    public void setName(String name);
    public void setAddress(Address address);
	public void addNewUnit(Unit unit);

	private String facilityName;
	private Address address;
	private List<String> unitList;

}
