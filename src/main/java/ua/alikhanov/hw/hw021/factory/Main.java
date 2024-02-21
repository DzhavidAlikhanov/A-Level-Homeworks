package ua.alikhanov.hw.hw021.factory;

public class Main {
    public static void main(String[] args) {
        Logger fileLogger = LoggerFactory.createLogger("File");
        Logger emailLogger = LoggerFactory.createLogger("Email");
        Logger databaseLogger = LoggerFactory.createLogger("Database");

        fileLogger.log("Log message to file");
        emailLogger.log("Log message via email");
        databaseLogger.log("Log message to database");
    }
}
