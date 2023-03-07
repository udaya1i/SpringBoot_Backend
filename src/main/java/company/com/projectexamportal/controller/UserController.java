package company.com.projectexamportal.controller;
import company.com.projectexamportal.model.Role;
import company.com.projectexamportal.model.User;
import company.com.projectexamportal.model.UserRole;
import company.com.projectexamportal.repo.UserRepository;
import company.com.projectexamportal.services.UserServices;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserServices userServices;

    @Autowired
    private UserRepository userRepository;
    //creating a user
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {
        Set<UserRole> roles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(3L);
        role.setRoleName("Normal User");
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);
        return  ResponseEntity.ok(this.userServices.createUser(user,roles));
    }
    //getting user by id
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userServices.getUserbyId(username);
    }
    //deleting user by id
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        this.userServices.deleteById(id);
   }
   // updatint user
    @PutMapping("/{id}")
    public void updateUser(@RequestBody User user , @PathVariable("id")Long id){
        this.userServices.updateUser(user, id);
    }

    @GetMapping("/")
    public  ResponseEntity<?> getalluser( ){
       return ResponseEntity.ok(this.userRepository.findAll());
    }
}
