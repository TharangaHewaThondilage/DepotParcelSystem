package Controller;

import Model.Customer;
import Model.CustomerQueue;
import Model.Parcel;
import Model.Log;
import java.util.HashMap;
import java.util.Map;

public class Manager {
     private CustomerQueue queue;
    private Map<String, Parcel> parcelMap;
    private Log log;

    public Manager() {
        queue = new CustomerQueue();
        parcelMap = new HashMap<>();
        log = Log.getInstance();
    }

    public void addParcelToTracker(Parcel parcel) {
        if (parcel != null && !parcelMap.containsKey(parcel.getParcelID())) {
            parcelMap.put(parcel.getParcelID(), parcel);
            log.addEntry("Parcel added to tracker: " + parcel.getParcelID());
            System.out.println("Parcel added: " + parcel.getParcelID());
        } else {
            System.out.println("Parcel already exists or is invalid!");
        }
    }

    public void addCustomerToQueue(Customer customer) {
        if (customer != null) {
            queue.addNewCustomer(customer);
            log.addEntry("Customer added to queue: " + customer.getName());
        } else {
            System.out.println("Invalid customer!");
        }
    }

    public void generateReport(String filename) {
        // Report generation logic
        log.addEntry("Report generated: " + filename);
        log.writeToFile("logfile.txt");
    }

}
