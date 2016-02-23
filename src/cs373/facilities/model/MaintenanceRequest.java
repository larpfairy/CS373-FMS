package cs373.facilities.model;

public class MaintenanceRequest {
    private String request;
    private double cost;

    public MaintenanceRequest(String request, double cost) {
        this.request = request;
        this.cost = cost;
    }

    public void setRequest(String request) {
        this.request = request;
    }
    public String getRequest() {
        return request;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    public double getCost() {
        return cost;
    }
}
