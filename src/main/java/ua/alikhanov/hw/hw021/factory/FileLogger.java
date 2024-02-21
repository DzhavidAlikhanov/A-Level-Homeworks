package ua.alikhanov.hw.hw021.factory;

import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger {
    @Override
    public void log(String message) {
        writeToFile(message);
    }

    private void writeToFile(String message) {
        String fileName = "log.txt";
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(message + "\n");
            System.out.println("Logging to file " + fileName + ": " + message);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
