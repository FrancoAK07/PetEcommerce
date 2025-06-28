package api.demo.API.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import api.demo.API.Model.UserEntity;
import api.demo.Service.UserEntityService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserEntityController {
    @Autowired
    private UserEntityService userEntityService;

     @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity>users = userEntityService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

     @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        UserEntity createdUser = userEntityService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
     public ResponseEntity<UserEntity> getUserByEmailAndPassword(@RequestBody UserData userData) {
        try {
            Optional<UserEntity> userOptional = userEntityService.findByEmailAndPassword(userData.getEmail(), userData.getPassword());
            System.out.println("User: ----->" + userOptional);

            if (userOptional.isPresent()) {
                System.out.println("user present: ---------->" );
                return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
            } else {
                System.out.println("user not present: ---------->" );
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); // user not found
            }
        } catch (Exception e) {
            System.out.println("error: ---------->" );
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

        public static class UserData {
            private String email;
            private String password;

            // Getters and setters
            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }
        }


}
