package Model;

import java.util.HashMap;


public class ParcelMap {
 
    // Using a HashMap to store Parcel objects with their ParcelID as the key
    private HashMap<String, Parcel> parcelMap;

    // Constructor to initialize the HashMap
    public ParcelMap() {
        parcelMap = new HashMap<>();
    }

    // Method to find a Parcel by its ParcelID
    public Parcel findParcel(String parcelID) {
        return parcelMap.get(parcelID);
    }

    // Method to add a Parcel to the map
    public void addParcel(Parcel parcel) {
        if (parcel != null && parcel.getParcelID() != null) {
            parcelMap.put(parcel.getParcelID(), parcel);
        }
    }

    // Method to mark a Parcel as collected
   /* public void markParcelCollected(String parcelID) {
        Parcel parcel = parcelMap.get(parcelID);
        if (parcel != null) {
            parcel.Status = "Collected";
        }
    }*/

    // Method to remove a Parcel from the map
    public void removeParcel(String parcelID) {
        parcelMap.remove(parcelID);
    } 
    
    
}
