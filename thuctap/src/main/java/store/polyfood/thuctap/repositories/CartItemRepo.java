package store.polyfood.thuctap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.polyfood.thuctap.models.CartItem;

@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Integer> {
}
