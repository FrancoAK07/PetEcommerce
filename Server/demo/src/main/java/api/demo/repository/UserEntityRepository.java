package api.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import api.demo.model.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    @Query(value = "SELECT * FROM users WHERE email = :email AND password = :password", nativeQuery = true)
    Optional<UserEntity> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    Optional<UserEntity> findByEmail(@Param("email") String email);
}
