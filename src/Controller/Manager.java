package Controller;

import Model.Customer;
import Model.CustomerQueue;
import Model.Parcel;
import Model.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

    // Method to add customer to queue and save to Custs.csv
    public void addCustomerToQueue(Customer customer) {
        // Write customer data to Custs.csv
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resources/Custs.csv", true))) {
            // Format customer details as a CSV line
            String csvLine = String.format("%d,%s,%s", customer.getCustomerQueueNo(), customer.getName(), customer.getParcelID());
            // Append the new customer to the file
            writer.append(csvLine).append("\n");
        } catch (IOException e) {
            System.err.println("Error saving customer to file: " + e.getMessage());
        }

        // Log the event of adding the customer to logfile.txt
        logCustomerAddition(customer);
    }

    public void generateReport(String filename) {
        // Report generation logic
        log.addEntry("Report generated: " + filename);
        log.writeToFile("logfile.txt");
    }
    
    private void logCustomerAddition(Customer customer) {
        try (BufferedWriter logWriter = new BufferedWriter(new FileWriter("resources/logfile.txt", true))) {
            // Log the event with timestamp
            String logEntry = String.format("Customer added: %d, %s (Parcel ID: %s) at %s", 
                                            customer.getCustomerQueueNo(), customer.getName(), customer.getParcelID(),
                                            java.time.LocalDateTime.now());
            logWriter.append(logEntry).append("\n");
        } catch (IOException e) {
            System.err.println("Error logging event: " + e.getMessage());
        }
    }
     
 public int getNextCustomerQueueNo() {
        int nextId = 1;  // Default value in case the file is empty or doesn't exist
        
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/Custs.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Parse the line and get the customer ID (first value in the line)
                String[] data = line.split(",");
                try {
                    int currentId = Integer.parseInt(data[0]);
                    if (currentId >= nextId) {
                        nextId = currentId + 1; // Increment for the next customer
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing customer ID: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading Custs.csv: " + e.getMessage());
        }
        return nextId; // Return the next available customer ID
    }

}
