package store.polyfood.thuctap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.polyfood.thuctap.models.ProductImage;

@Repository
public interface ProductImageRepo extends JpaRepository<ProductImage, Integer> {
}
