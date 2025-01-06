package controller;

import model.Parcel;

public class Worker {
    // Method to process a customer and calculate the fee for the parcel
  /*  public double processCustomer(Customer customer, Parcel parcel) {
        if (customer == null || parcel == null) {
            throw new IllegalArgumentException("Customer or Parcel cannot be null");
        }

        double baseFee = 50.0; // Base fee for processing
        double weightFee = parcel.getWeight() * 10.0; // Fee based on weight
        double volumeFee = parcel.calculateVolume() * 0.05; // Fee based on volume
        double daysFee = parcel.getDaysInDepot() * 2.0; // Additional fee for days in depot

        double totalFee = baseFee + weightFee + volumeFee + daysFee;

        // Log event
        Log.getInstance().addEvent("Processed parcel " + parcel.getParcelId() + 
                                   " for customer " + customer.getCustomerId() + 
                                   ". Total fee: " + totalFee );

        return totalFee;
    }

    public void releaseParcel(Parcel parcel) {
        if (parcel == null) {
            throw new IllegalArgumentException("Parcel cannot be null");
        }

        // Log the release event
        Log.getInstance().addEvent("Parcel " + parcel.getParcelId() + " has been released.");
    }*/
    
    public double calculateParcelFee(Parcel parcel) {
        return parcel.calculateFee();
    }
}
