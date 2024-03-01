package ua.alikhanov.hw.hw018;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HibernateMongoComparison {
    private static final Logger logger = Logger.getLogger(HibernateMongoComparison.class.getName());

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ogm-mongodb");
        EntityManager em = emf.createEntityManager();

        Person person = new Person("Dzhavi Alikhanov", 27);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(person);
        transaction.commit();

        Person readPerson = em.find(Person.class, person.getId());
        System.out.println("Read Person: " + readPerson);

        transaction.begin();
        readPerson.setAge(28);
        transaction.commit();

        transaction.begin();
        em.remove(readPerson);
        transaction.commit();

        em.close();
        emf.close();


        try {
            String jsonString = JsonHandler.toJson(readPerson);
            Person personFromJson = JsonHandler.fromJson(jsonString, Person.class);
            System.out.println("Person converted from JSON: " + personFromJson);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception occurred while processing JSON", e);
        }
    }
}
