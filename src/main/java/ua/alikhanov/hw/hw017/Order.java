package ua.alikhanov.hw.hw017;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_description")
    private String orderDescription;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @SuppressWarnings("unused")
    @Column(name = "order_date")
    private LocalDate orderDate;

    public Order() {
        this.orderDate = LocalDate.now();
    }

    @SuppressWarnings("unused")
    public Long getId() {
        return id;
    }
    @SuppressWarnings("unused")
    public String getOrderDescription() {
        return orderDescription;
    }
    @SuppressWarnings("unused")
    public User getUser() {
        return user;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
