package objectss;

import java.util.Objects;

public class Travel {
    String travelName;
    String data;
    String from;
    String to;
    int travelId;
    Buses buses;
    User driver;
    double price;
   public static   int currentId =0;
        {
         currentId++;
     }

    public Travel() {
    }

    public Travel(String travelName, String data, String from, String to, int travelId, Buses buses, User driver,double price) {
        this.travelName = travelName;
        this.data = data;
        this.from = from;
        this.to = to;
        this.travelId = travelId;
        this.buses = buses;
        this.driver = driver;
        this.price = price;
    }

    public String getTravelName() {
        return travelName;
    }

    public void setTravelName(String travelName) {
        this.travelName = travelName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getTravelId() {
        return travelId;
    }

    public void setTravelId(int travelId) {
        this.travelId = travelId;
    }

    public Buses getBuses() {
        return buses;
    }

    public void setBuses(Buses buses) {
        this.buses = buses;
    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        Travel.currentId = currentId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Travel travel = (Travel) o;
        return travelId == travel.travelId && Double.compare(travel.price, price) == 0 && Objects.equals(travelName, travel.travelName) && Objects.equals(data, travel.data) && Objects.equals(from, travel.from) && Objects.equals(to, travel.to) && Objects.equals(buses, travel.buses) && Objects.equals(driver, travel.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(travelName, data, from, to, travelId, buses, driver, price);
    }

    @Override
    public String toString() {
        return "Travel{" +
                "travelName='" + travelName + '\'' +
                ", data='" + data + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", travelId=" + travelId +
                ", buses=" + buses +
                ", driver=" + driver +
                ", price=" + price +
                '}';
    }
}
