package ua.alikhanov.hw.hw017;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class HqlQueries {

    private final EntityManager entityManager;

    public HqlQueries(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<User> getUsersWithMoreThan5Orders() {
        String hql = "SELECT u FROM User u WHERE size(u.orders) > 5";
        return entityManager.createQuery(hql, User.class).getResultList();
    }

    // 2. Знайдіть всі замовлення, які були зроблені певним користувачем за певний період часу.
    public List<Order> getOrdersByUserAndDate(User user, LocalDate startDate, LocalDate endDate) {
        String hql = "SELECT o FROM Order o WHERE o.user = :user AND o.orderDate BETWEEN :startDate AND :endDate";
        return entityManager.createQuery(hql, Order.class)
                .setParameter("user", user)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
    }

    // 3. Підрахуйте загальну кількість замовлень для кожного користувача та виведіть результати.
    public List<Object[]> getTotalOrdersCountByUser() {
        String hql = "SELECT u.username, count(o) FROM User u LEFT JOIN u.orders o GROUP BY u.username";
        return entityManager.createQuery(hql, Object[].class).getResultList();
    }
}

