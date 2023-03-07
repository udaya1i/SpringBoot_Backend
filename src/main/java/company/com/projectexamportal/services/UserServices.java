package company.com.projectexamportal.services;
import company.com.projectexamportal.model.User;
import company.com.projectexamportal.model.UserRole;

import java.util.Optional;
import java.util.Set;
public interface UserServices {
    //creating a user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by username
    public User getUserbyId(String username);

    //delete user by id
    public void deleteById(Long id);

    // updating user
    public Optional<User> updateUser(User user, Long id);
}
