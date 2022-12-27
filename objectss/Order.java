package objectss;

import java.util.Objects;

public class Order {
    Buses buses;
    User user;
    Travel travel;

    public Order(Buses buses, User user, Travel travel) {
        this.buses = buses;
        this.user = user;
        this.travel = travel;
    }

    public Order() {
    }

    public Buses getBuses() {
        return buses;
    }

    public void setBuses(Buses buses) {
        this.buses = buses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(buses, order.buses) && Objects.equals(user, order.user) && Objects.equals(travel, order.travel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buses, user, travel);
    }

    @Override
    public String toString() {
        return "Order{" +
                "buses=" + buses +
                ", user=" + user +
                ", travel=" + travel +
                '}';
    }
}
