package api.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import api.demo.model.UserEntity;
import api.demo.repository.UserEntityRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserEntityServiceImpl implements UserEntityService{
    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity createUser(UserEntity user) {
    try  {
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        UserEntity savedUser = userEntityRepository.save(user);
        System.out.println("User created correctly" + savedUser );
        return savedUser;
    } catch (Exception e) {
        System.err.println("Error saving user: " + e.getMessage());
        throw e;
    }
}

    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = userEntityRepository.findAll();
        return users;
    }

    public Optional<UserEntity> findByEmailAndPassword(String email, String rawPassword) {
       try {
            // Retrieve the user by email
            Optional<UserEntity> optionalUser = userEntityRepository.findByEmail(email);
            if (optionalUser.isPresent()) {
                UserEntity user = optionalUser.get();
                // Compare the raw password with the stored hashed password
                if (passwordEncoder.matches(rawPassword, user.getPassword())) {
                    System.out.println("User found: " + user);
                    return Optional.of(user); // Return the user if passwords match
                } else {
                    System.out.println("Invalid password for user: " + email);
                    return Optional.empty(); // Return empty if passwords do not match
                }
            } else {
                System.out.println("User not found: " + email);
                return Optional.empty(); // Return empty if user not found
            }
        } catch (Exception e) {
            System.err.println("Error validating user: " + e.getMessage());
            throw e; // Rethrow the exception for further handling
        }
    }

}
