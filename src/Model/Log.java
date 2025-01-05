package Model;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;


public class Log {
  // Singleton instance
    private static Log instance;
    
    // StringBuilder to hold log entries
    private StringBuilder logEntries;

      // Private constructor to prevent instantiation
    private Log(){
        logEntries = new StringBuilder();
    }

    // Public method to get the single instance of the Log class
    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    // Method to add a new log entry
    public void addEntry(String entry) {
        if (entry != null && !entry.isEmpty()) {
            logEntries.append(LocalDateTime.now()).append(" - ").append(entry).append("\n");
            System.out.println("Log Entry Added: " + entry);
        } else {
            System.out.println("Invalid Log Entry!");
        }
    }

    // Method to write log entries to a file
    public void writeToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(logEntries.toString());
            System.out.println("Log written to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }
}
