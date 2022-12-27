package objectss;
import enums.Role;
import java.util.Objects;

public class User {
    String name;
    String logIn;
    String password;
    Role role;
    double balance;
    int id;


    public User() {
    }

    public User(String name, String logIn, String password, Role role, double balance,int id) {
        this.name = name;
        this.logIn = logIn;
        this.password = password;
        this.role = role;
        this.balance = balance;
        this.id = id;
    }
   public static int currentId = 0;
    {
        currentId++;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = currentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogIn() {
        return logIn;
    }

    public void setLogIn(String logIn) {
        this.logIn = logIn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", logIn='" + logIn + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", balance=" + balance +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Double.compare(user.balance, balance) == 0 && id == user.id && Objects.equals(name, user.name) && Objects.equals(logIn, user.logIn) && Objects.equals(password, user.password) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, logIn, password, role, balance, id);
    }
}
