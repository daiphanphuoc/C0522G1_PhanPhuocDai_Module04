package daiphan.exercise.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    private String name;
    private String password;
    private boolean isEnable;
    private boolean isDelete;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserRole> userRoles;



    /*
    @ManyToMany(cascade = CascadeType.ALL)
     @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_name", referencedColumnName = "name"),
             inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
     private Set<Role>  roles;

     public Set<Role> getRoles() {
         return roles;
     }

     public void setRoles(Set<Role> roles) {
         this.roles = roles;
     }
    */

    public User() {
    }

    public User(String name, String password, boolean isEnable, Set<UserRole> userRoles) {
        this.name = name;
        this.password = password;
        this.isEnable = isEnable;
        this.userRoles = userRoles;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }
}
