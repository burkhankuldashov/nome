package objectss;

import java.util.Objects;

public class Buses {
    String name;
    String number;
    int busOfSeat;
    int id;

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = currentId;
    }

    public Buses(String name, String number, int busOfSeat, int id) {
        this.name = name;
        this.number = number;
        this.busOfSeat = busOfSeat;
        this.id = id;
    }

    static int currentId = 0;
    {
        currentId++;
    }

    public Buses() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getBusOfSeat() {
        return busOfSeat;
    }

    public void setBusOfSeat(int busOfSeat) {
        this.busOfSeat = busOfSeat;
    }

    @Override
    public String toString() {
        return "Buses{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", busOfSeat=" + busOfSeat +
                ", id=" + id +
                '}';
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        Buses.currentId = currentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buses buses = (Buses) o;
        return busOfSeat == buses.busOfSeat && id == buses.id && Objects.equals(name, buses.name) && Objects.equals(number, buses.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, busOfSeat, id);
    }
}
