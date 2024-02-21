package ua.alikhanov.hw.hw021.factory;

public class LoggerFactory {

    private LoggerFactory() {
    }

    public static Logger createLogger(String type) {
        return switch (type) {
            case "File" -> new FileLogger();
            case "Email" -> new EmailLogger();
            case "Database" -> new DatabaseLogger();
            default -> throw new IllegalArgumentException("Invalid logger type");
        };
    }
}
