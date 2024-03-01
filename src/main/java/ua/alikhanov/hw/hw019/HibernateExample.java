package ua.alikhanov.hw.hw019;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@EntityScan(basePackages = "ua.alikhanov.hw.hw019")
public class HibernateExample {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();


        Dao<Person> hibernatePersonDao = new HibernatePersonDao(sessionFactory);


        Person person = new Person("Dzhavid Alikhanov", 28);


        hibernatePersonDao.create(person);


        Person readPerson = hibernatePersonDao.read(person.getId());
        System.out.println("Read Person: " + readPerson);


        readPerson.setName("Updated Name");
        hibernatePersonDao.update(readPerson);


        List<Person> allPeople = hibernatePersonDao.readAll();
        System.out.println("All People: " + allPeople);


        hibernatePersonDao.delete(readPerson);


        sessionFactory.close();
    }
}
