package model;

import java.io.*;

public class Log {
     private static Log instance;
     private StringBuilder logBuffer;

    private Log() {
        logBuffer = new StringBuilder();
    }

    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    public void addLog(String logEntry) {
        logBuffer.append(logEntry).append("\n");
    }

    public String getLogs() {
        return logBuffer.toString();
    }

    public void clearLogs() {
        logBuffer.setLength(0);
    }


    public void writeToFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true)) { // 'true' for appending to the file
            writer.write(logBuffer.toString());
            logBuffer.setLength(0);  // Clear the buffer after writing to file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
