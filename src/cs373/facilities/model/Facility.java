package cs373.facilities.model;

import java.util.ArrayList;
import java.util.List;

public class Facility {

    private String name;
    private Address address;

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

    // TODO: Maintenance requests, etc.

}
