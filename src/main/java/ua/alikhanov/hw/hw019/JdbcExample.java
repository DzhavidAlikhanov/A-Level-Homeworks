package ua.alikhanov.hw.hw019;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class JdbcExample {
    public static void main(String[] args) {
        try {
            String url = "jdbc:postgresql://localhost:5432/alevel";
            String user = "postgres";
            String password = "Dg18021996";

            Connection connection = DriverManager.getConnection(url, user, password);

            Dao<Person> jdbcPersonDao = new JdbcPersonDao(connection);

            Person person = new Person("Dzhavid Alikhanov", 28);
            jdbcPersonDao.create(person);

            long personId = 1;
            Person retrievedPerson = jdbcPersonDao.read(personId);

            if (retrievedPerson != null) {
                System.out.println("Retrieved Person: " + retrievedPerson);

                retrievedPerson.setName("Updated Name");
                jdbcPersonDao.update(retrievedPerson);

                jdbcPersonDao.delete(retrievedPerson);
            } else {
                System.out.println("Не удалось найти человека с id: " + personId);
            }

            List<Person> allPeople = jdbcPersonDao.readAll();
            System.out.println("All People: " + allPeople);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
