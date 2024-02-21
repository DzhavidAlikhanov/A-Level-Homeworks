package ua.alikhanov.hw.hw021.factory;

public class EmailLogger implements Logger {
    @Override
    public void log(String message) {
        sendEmail(message);
    }

    private void sendEmail(String message) {
        String recipientEmail = "your_email@example.com";
        System.out.println("Logging via email to " + recipientEmail + ": " + message);
    }
}
