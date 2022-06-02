package entity;

/**
 * 实体类
 * 封装用户信息
 */
public class User {
    private String username;
    private String password;
    private Integer countMsg;//用户在线人数计数

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", countMsg='" + countMsg + '\'' +
                '}';
    }

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

    public Integer getCountMsg() {
        return countMsg;
    }

    public void setCountMsg(Integer countMsg) {
        this.countMsg = countMsg;
    }

    public User(Integer countMsg) {
        this.countMsg = countMsg;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, Integer countMsg) {
        this.username = username;
        this.password = password;
        this.countMsg = countMsg;
    }

    public User() {
    }
}
