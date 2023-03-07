package company.com.projectexamportal.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRoleID;
    @ManyToOne()
    @JsonIgnore
    private User user;
    @ManyToOne
    @JsonIgnore
    private Role role;
    public UserRole() {
    }
    public Long getUserRoleID() {
        return userRoleID;
    }
    public void setUserRoleID(Long userRoleID) {
        this.userRoleID = userRoleID;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
}