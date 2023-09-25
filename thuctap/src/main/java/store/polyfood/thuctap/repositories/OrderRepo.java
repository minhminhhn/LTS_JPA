package store.polyfood.thuctap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import store.polyfood.thuctap.models.entities.Orders;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer> {
    @Query(value = "SELECT orders.*, order_status.status_name\n" +
            "FROM orders\n" +
            "join order_status on  orders.order_status_id = order_status.order_status_id;", nativeQuery = true)
    List<Object[]> getOrders();
}
