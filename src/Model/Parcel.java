package model;

public class Parcel {
    
   private String parcelId;
    private int daysInDepot;
    private double weight;
    private double length;
    private double width;
    private double height;
    private String dimention;

    public Parcel() {
    }
    
    public Parcel(String parcelId, int daysInDepot, double weight, double length, double width, double height) {
        this.parcelId = parcelId;
        this.daysInDepot = daysInDepot;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Parcel(String parcelId, double weight, String dimention) {
        this.parcelId = parcelId;
        this.weight = weight;
        this.dimention = dimention;
    }

    
    
    

    // Getters
    public String getParcelId() {
        return parcelId;
    }

    public int getDaysInDepot() {
        return daysInDepot;
    }

    public double getWeight() {
        return weight;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    // Setters (if required)
    public void setDaysInDepot(int daysInDepot) {
        this.daysInDepot = daysInDepot;
    }

    // Method to calculate volume
    public double calculateVolume() {
        return length * width * height;
    }

    public String getDimention() {
        return dimention;
    }

    public void setDimention(String dimention) {
        this.dimention = dimention;
    }
     
    
    
    @Override
    public String toString() {
        return "Parcel[ID=" + parcelId + ", DaysInDepot=" + daysInDepot + 
               ", Weight=" + weight + ", Dimensions=" + length + "x" + width + "x" + height + "]";
    }
    
     public String toCSV() {
        return parcelId + "," + daysInDepot + "," + weight + "," + length + "," + width + "," + height;
    }
     
     public double calculateFee() {
        double baseFee = 50.0;
        double weightFee = this.weight * 10; 
        double sizeFee = (this.length * this.width * this.height) / 5000; 

   
       double fee = baseFee + weightFee + sizeFee;

        if (fee > 100) {
           fee *= 0.9;
       }

      return fee;
}

}
