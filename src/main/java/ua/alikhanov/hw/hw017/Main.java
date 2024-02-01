package ua.alikhanov.hw.hw017;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unitName");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            // Додавання користувача та використання HQL для додаткових завдань
            User newUser = new User();
            newUser.setUsername("JohnDoe");
            entityManager.persist(newUser);

            Long userId = newUser.getId();
            User retrievedUser = entityManager.find(User.class, userId);
            System.out.println("Retrieved User: " + retrievedUser.getUsername());

            retrievedUser.setUsername("UpdatedUsername");

            entityManager.remove(retrievedUser);

            entityManager.getTransaction().commit();

            entityManager.getTransaction().begin();

            User user = new User();
            user.setUsername("JohnDoe");

            Order order1 = new Order();
            order1.setOrderDescription("Order 1 description");
            order1.setUser(user);

            Order order2 = new Order();
            order2.setOrderDescription("Order 2 description");
            order2.setUser(user);

            user.getOrders().add(order1);
            user.getOrders().add(order2);

            entityManager.persist(user);

            entityManager.getTransaction().commit();

            // Використання HQL запитів
            HqlQueries hqlQueries = new HqlQueries(entityManager);

            // 1. Пошук користувачів із більше ніж 5 замовленнями:
            List<User> usersWithMoreThan5Orders = hqlQueries.getUsersWithMoreThan5Orders();
            System.out.println("Users with more than 5 orders: " + usersWithMoreThan5Orders);

            // 2. Знайдіть всі замовлення, які були зроблені певним користувачем за певний період часу.
            user = entityManager.find(User.class, 1L); // Припустимо, що користувач з id=1 існує в базі даних
            LocalDate startDate = LocalDate.of(2023, 1, 1);
            LocalDate endDate = LocalDate.now();
            List<Order> ordersByUserAndDate = hqlQueries.getOrdersByUserAndDate(user, startDate, endDate);
            System.out.println("Orders by user and date: " + ordersByUserAndDate);

            // 3. Підрахуйте загальну кількість замовлень для кожного користувача та виведіть результати.
            List<Object[]> totalOrdersCountByUser = hqlQueries.getTotalOrdersCountByUser();
            System.out.println("Total orders count by user: ");
            for (Object[] result : totalOrdersCountByUser) {
                System.out.println("Username: " + result[0] + ", Total Orders: " + result[1]);
            }
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
