package Controller;



public class Worker {
    
     // Calculate the fee based on parcel weight and days in the depot
        public static double calculateFee(double weight, int daysInDepot) {
      
        double ratePerKg = 5.0;
        double dailyRate = 2.0;
        
        // Calculate fee: (weight * rate) + (days * daily rate)
        double fee = (weight * ratePerKg) + (daysInDepot * dailyRate);
        
        return fee;
    }

    // Operate on a customer (example operation)
    public void operateCustomer(String parcelID) {
        System.out.println("Processing parcel with ID: " + parcelID);
    }
}
