package ua.alikhanov.hw.hw021.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseLogger implements Logger {
    @Override
    public void log(String message) {
        saveToDatabase(message);
    }

    private void saveToDatabase(String message) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password")) {
            String query = "INSERT INTO log_table (log_message) VALUES (?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, message);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
