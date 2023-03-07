package company.com.projectexamportal;
import company.com.projectexamportal.model.Role;
import company.com.projectexamportal.model.User;
import company.com.projectexamportal.model.UserRole;
import company.com.projectexamportal.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ProjectExamportalApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ProjectExamportalApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application Starting");
//        User user = new User();
//        user.setUsername("udayad123");
//        user.setFirstName("Udadya");
//        user.setLastName("Subdedi");
//        user.setEmail("udaya@gdmail.com");
//        user.setPassword("abddc");
//        user.setEnable(true);
//
//        Role role = new Role();
//        role.setRoleId(2L);
//        role.setRoleName("Addmin");
//
//        Set<UserRole> userRoleSet = new HashSet<>();
//        UserRole userRole =  new UserRole();
//        userRole.setRole(role);
//        userRole.setUser(user);
//        userRoleSet.add(userRole);
//
//        User  user1 = this.userServices.createUser(user,userRoleSet);
//        System.out.println(user1.getUsername());
    }
}
