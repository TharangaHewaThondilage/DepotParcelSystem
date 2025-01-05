package Model;

public class Customer {
    private int CustomerQueueNo;
    private String name;
    private String ParcelID;

    public Customer() {
    }

    public Customer(int CustomerQueueNo, String name, String ParcelID) {
        this.CustomerQueueNo = CustomerQueueNo;
        this.name = name;
        this.ParcelID = ParcelID;
    }

    public int getCustomerQueueNo() {
        return CustomerQueueNo;
    }

    public void setCustomerQueueNo(int CustomerQueueNo) {
        this.CustomerQueueNo = CustomerQueueNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParcelID() {
        return ParcelID;
    }

    public void setParcelID(String ParcelID) {
        this.ParcelID = ParcelID;
    }

    @Override
    public String toString() {
        return "Customer{" + "CustomerQueueNo=" + CustomerQueueNo + ", name=" + name + ", ParcelID=" + ParcelID + '}';
    }
    
    
}
