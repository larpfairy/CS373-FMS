package cs373.facilities.model.facility;

public class Address {

    private int id;
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address() {}

    public int getID() { return id; }
    public String getStreet() { return street; }
    public String getCity()   { return city;   }
    public String getState()  { return state;  }
    public String getZip()    { return zip;    }
    public String getFullAddress() {
        return street + "\n" + city + ", " + state + " " + zip;
    }

    public void setID(int id) { this.id = id; }
    public void setStreet(String street) { this.street = street; }
    public void setCity(String city)     { this.city  = city;    }
    public void setState(String state)   { this.state = state;   }
    public void setZip(String zip)       { this.zip = zip;       }
}
