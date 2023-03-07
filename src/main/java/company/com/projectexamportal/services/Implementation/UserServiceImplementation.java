package company.com.projectexamportal.services.Implementation;

import company.com.projectexamportal.model.User;
import company.com.projectexamportal.model.UserRole;
import company.com.projectexamportal.repo.RoleRepository;
import company.com.projectexamportal.repo.UserRepository;
import company.com.projectexamportal.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImplementation implements UserServices {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
// creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = userRepository.findByUsername(user.getUsername());
        if(local!=null){
            // if user already exist
            System.out.println("User Already Exist!!!!");
            throw new Exception("User Already Exist!");
        }else {
            //create user
            for (UserRole ur:userRoles){
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
           local =  this.userRepository.save(user);
        }
        return local;
    }
//getting user by username
    @Override
    public User getUserbyId(String username) {
      return  this.userRepository.findByUsername(username);
    }

    // delete
    @Override
    public void deleteById(Long id) {
          this.userRepository.deleteById(id);
    }
    // update
    @Override
    public Optional<User> updateUser(User user, Long id) {

        User existuser = userRepository.findById(id).orElse(null);
        if (existuser==null){
            return null;
        }
        existuser.setUsername(user.getUsername());
        existuser.setPassword(user.getPassword());
        existuser.setLastName(user.getLastName());
        existuser.setEmail(user.getEmail());
        existuser.setEnable(user.getEnable());
        existuser.setPhone(user.getPhone());
        User updateduser = userRepository.save(existuser);
        return this.userRepository.findById(updateduser.getId());
    }
}
