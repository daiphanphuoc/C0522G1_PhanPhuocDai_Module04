package daiphan.casestudy.model.permission;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private String name;
    private String password;
    private boolean isDelete;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
