package api.demo.Service;
import api.demo.API.Model.UserEntity;

import java.util.List;
import java.util.Optional;


public interface UserEntityService {
    List<UserEntity> getAllUsers();
    UserEntity createUser(UserEntity user);
    Optional<UserEntity> findByEmailAndPassword(String email, String password);

}
