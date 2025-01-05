package Model;

public class Parcel {
    private String ParcelID;
    private String Dimentions;
    private float weight;
    private int DaysinDepot;
    private String Status;
    private boolean collected;

    public Parcel() {
    }

    public Parcel(String ParcelID, String Dimentions, float weight, int DaysinDepot, String Status ,boolean collected) {
        this.ParcelID = ParcelID;
        this.Dimentions = Dimentions;
        this.weight = weight;
        this.DaysinDepot = DaysinDepot;
        this.Status = Status;
        this.collected =false;
    }

    public Parcel( float weight, int DaysinDepot) {
       
        this.weight = weight;
        this.DaysinDepot = DaysinDepot;
    }
    
    

    public String getParcelID() {
        return ParcelID;
    }

    public void setParcelID(String ParcelID) {
        this.ParcelID = ParcelID;
    }

    public String getDimentions() {
        return Dimentions;
    }

    public void setDimentions(String Dimentions) {
        this.Dimentions = Dimentions;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getDaysinDepot() {
        return DaysinDepot;
    }

    public void setDaysinDepot(int DaysinDepot) {
        this.DaysinDepot = DaysinDepot;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
 
    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }
    
       
   /* public float calculatefee(){
      return ; 
    }*/
    
   /* public String UpdateStatus(){
        return;
    } */

    @Override
    public String toString() {
        return "Parcel{" + "ParcelID=" + ParcelID + ", Dimentions=" + Dimentions + ", weight=" + weight + ", DaysinDepot=" + DaysinDepot + ", Status=" + Status + ", collected=" + collected + '}';
    }
    
    

}
