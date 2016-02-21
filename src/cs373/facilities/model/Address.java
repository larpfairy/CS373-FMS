package cs373.facilities.model;

public class Address {

	private String street;
	private String city;
	private String state;
	private String zip;
	
	public Address() {}
	
	public String getStreet() { return street; }
	public String getCity()   { return city;   }
	public String getState()  { return state;  }
	public String getZip()    { return zip;    }
	public String getFullAddress() {
		return street + "\n" + city + "," + state + " " + zip; 
	}

	public String setStreet(String street) { this.street = street; }
	public String setCity(String city)     { this.city  = city;    }
	public String setState(String state)   { this.state = state;   }
	public String setZip(string zip)       { this.zip = zip;       }
}
