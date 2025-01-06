package controller;

import model.*;

/**
 *
 * @author Prasad
 */
public class Manager extends Worker{
    
     @Override
    public double calculateParcelFee(Parcel parcel) {
        double fee = super.calculateParcelFee(parcel);

        // Apply discount for long-term customers
        if (parcel.getDaysInDepot() > 30) {
            fee *= 0.9; // 10% discount
        }

        return fee;
    }

  
   

   
}
