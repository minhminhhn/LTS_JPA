package store.polyfood.thuctap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.polyfood.thuctap.models.Carts;

@Repository
public interface CartRepo extends JpaRepository<Carts, Integer> {
}
