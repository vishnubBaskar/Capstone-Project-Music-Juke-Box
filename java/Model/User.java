package Model;

public class User {
   private String userId;
   private String password;
   private String mobNumber;

    public String getUsername() {
        return userId;
    }

    public void setUsername(String username) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobno() {
        return mobNumber;
    }

    public void setMobno(String mobno) {
        this.mobNumber = mobno;
    }

    public User(String username, String password, String mobno) {
        this.userId = userId;
        this.password = password;
        this.mobNumber = mobno;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", mobno='" + mobNumber + '\'' +
                '}';
    }

    public User() {
    }
}

