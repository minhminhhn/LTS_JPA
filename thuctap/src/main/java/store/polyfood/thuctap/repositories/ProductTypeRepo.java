package store.polyfood.thuctap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.polyfood.thuctap.models.ProductType;

@Repository
public interface ProductTypeRepo extends JpaRepository<ProductType, Integer> {
}
