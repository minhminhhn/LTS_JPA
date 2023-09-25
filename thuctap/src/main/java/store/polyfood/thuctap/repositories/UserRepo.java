package store.polyfood.thuctap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.polyfood.thuctap.models.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    public User findByFullName(String fullName);
    public User findByEmail(String email);
    
}
