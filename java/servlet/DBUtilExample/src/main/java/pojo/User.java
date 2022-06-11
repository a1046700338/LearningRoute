package pojo;
//实体用户类
public class User {
    private String username;
    private String password;
    private Integer id;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }

    public User() {
    }

    public User(String username, String password, Integer id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }
}
