package daiphan.casestudy.model.permission;

public class User {
    private String name;
    private String password;
    private boolean isDelete;

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
