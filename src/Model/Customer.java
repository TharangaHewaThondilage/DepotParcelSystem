package model;

public class Customer {
    
    private String customerId;
    private String name;
    private String parcelId;

    public Customer() {
    }
    
    
    public Customer(String customerId, String name, String parcelId) {
        this.customerId = customerId;
        this.name = name;
        this.parcelId = parcelId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getParcelId() {
        return parcelId;
    }

    @Override
    public String toString() {
        return "Customer [ID=" + customerId + ", Name=" + name + ", ParcelID=" + parcelId + "]";
    }
    
      public String toCSV() {
        return customerId + "," + name + "," + parcelId;
    }
    
}
