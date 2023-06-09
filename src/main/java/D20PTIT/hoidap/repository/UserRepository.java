package D20PTIT.hoidap.repository;

import D20PTIT.hoidap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByUserId(String userId);

}
