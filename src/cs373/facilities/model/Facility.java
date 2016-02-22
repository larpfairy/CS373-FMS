package cs373.facilities.model;

public class Facility {

    private String name;
    private Address address;
    private List<Unit> unitList = new ArrayList<Unit>();

    public Facility() {}
    public Facility(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getFacilityName() {
        return name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public Address getAddress() {
        return address;
    }

    public void addNewUnit(Unit unit) {
        unitList.add(unit);
    }
    public List<String> getUnits() {
        return unitList;
    }

    public List<String> getMaintenanceRequests() {
        for (Unit u : unitList) {
            System.out.println(u.getMaintenanceRequests());
        }
    }
}
