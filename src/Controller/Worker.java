package Controller;

import Model.Customer;
import Model.Parcel;


public class Worker {
    
     // Calculate the fee based on parcel weight and days in the depot
    public double calculateFee(Parcel parcel) {
        double baseRate = 10.0; // Base rate per kg
        double dailyCharge = 2.0; // Daily charge for storage

        return (parcel.getWeight() * baseRate) + (parcel.getDaysinDepot() * dailyCharge);
    }

    // Operate on a customer (example operation)
    public void operateCustomer(String parcelID) {
        System.out.println("Processing parcel with ID: " + parcelID);
    }
}
