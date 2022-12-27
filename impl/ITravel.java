package impl;

import interfacec.Travell;
import objectss.*;

import java.util.Scanner;

public class ITravel implements Travell {
    private static Travell travell;

    public static Travell getTravell() {
        if (travell == null) {
            travell = new ITravel();
        }
        return travell;
    }

    @Override
    public void travelConsole() {
        System.out.println("Travel console!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Travel name: ");
        String travelName = scanner.next();
        Travel travel1 = Storage.travelList.stream().filter(travel -> travel.getTravelName().equals(travelName)).findFirst().orElse(null);
        if (travel1 == null) {
            System.out.println("Travel data: ");
            String data = scanner.next();
            System.out.println("From: ");
            String from = scanner.next();
            System.out.println("To: ");
            String to = scanner.next();
            System.out.println("Chose bus: ");
            Storage.busesList.forEach(System.out::println);
            int id = scanner.nextInt();
            Buses buses = Storage.busesList.get(id);
            Storage.driversList.forEach(System.out::println);
            System.out.println("Chose driver: ");
            int num = scanner.nextInt();
            User user2 = Storage.userList.stream().filter(user1 -> user1.getId() == num).findFirst().orElse(null);
            System.out.println("Price: ");
            double price = scanner.nextDouble();
            Travel travel = new Travel(travelName, data, from, to, Travel.getCurrentId(), buses, user2, price);
            Storage.orderArrayList.add(new Order(buses, user2, travel));
            System.out.println("Add sucseesfully!!");
            Storage.travelList.add(travel);
            IAdmin.getAdmin().adminConsole();
        } else {
            System.err.println("We have this travell.");
            travelConsole();
        }
    }
}
