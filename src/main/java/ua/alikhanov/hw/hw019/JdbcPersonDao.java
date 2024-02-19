package ua.alikhanov.hw.hw019;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDao implements Dao<Person> {

    private final Connection connection;

    public JdbcPersonDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Person person) {
        try {
            if (!isPersonExists(person)) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO person(name, age) VALUES (?, ?)");
                preparedStatement.setString(1, person.getName());
                preparedStatement.setInt(2, person.getAge());
                preparedStatement.executeUpdate();
            } else {
                System.out.println("Пользователь с таким именем и возрастом уже существует");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Person read(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE id = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                return new Person(id, name, age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Person> readAll() {
        List<Person> people = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM person");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                people.add(new Person(id, name, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    @Override
    public void update(Person person) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE person SET name=?, age=? WHERE id=?");
            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setLong(3, person.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Person person) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM person WHERE id=?");
            preparedStatement.setLong(1, person.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean isPersonExists(Person person) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM person WHERE name = ? AND age = ?");
        preparedStatement.setString(1, person.getName());
        preparedStatement.setInt(2, person.getAge());
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count > 0;
        }

        return false;
    }
}
