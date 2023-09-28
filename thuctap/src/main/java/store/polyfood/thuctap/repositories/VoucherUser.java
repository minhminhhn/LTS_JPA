package store.polyfood.thuctap.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoucherUser extends JpaRepository<VoucherUser, Integer> {
}
