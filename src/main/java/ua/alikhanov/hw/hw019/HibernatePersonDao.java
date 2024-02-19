package ua.alikhanov.hw.hw019;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class HibernatePersonDao implements Dao<Person> {

    private final SessionFactory sessionFactory;

    public HibernatePersonDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.openSession();
    }

    @Override
    public void create(Person person) {
        try (Session session = getSession()) {
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        }
    }

    @Override
    public Person read(long id) {
        try (Session session = getSession()) {
            return session.get(Person.class, id);
        }
    }

    @Override
    public List<Person> readAll() {
        try (Session session = getSession()) {
            return session.createQuery("FROM Person", Person.class).list();
        }
    }

    @Override
    public void update(Person person) {
        try (Session session = getSession()) {
            session.beginTransaction();
            session.update(person);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Person person) {
        try (Session session = getSession()) {
            session.beginTransaction();
            session.delete(person);
            session.getTransaction().commit();
        }
    }
}
