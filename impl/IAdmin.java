package impl;

import enums.Role;
import interfacec.Admin;
import objectss.Buses;
import objectss.Order;
import objectss.Storage;
import objectss.User;

import java.util.Scanner;

public class IAdmin implements Admin {

    private static Admin admin;

    public static Admin getAdmin() {
        if (admin == null) {
            admin = new IAdmin();
        }
        return admin;
    }

    @Override
    public void adminConsole() {
        System.out.println("Admin console!");
        System.out.println("1- add bus,2- add new driver,3- new travel, 4- bus list, 0- exit");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num == 1) {
            System.out.println("Bus name: ");
            String busName = scanner.next();
            System.out.println("Bus number: ");
            String busNumber = scanner.next();
            Buses buses1 = Storage.busesList.stream().filter(buses -> buses.getNumber().equals(busNumber)).findFirst().orElse(null);
            if(buses1 == null){
            System.out.println("Bus seats number: ");
            int seats = scanner.nextInt();
            Buses buses = new Buses(busName,busNumber,seats,Buses.getCurrentId());
            Storage.busesList.add(buses);
            System.out.println("Add succesfully");
            adminConsole();
            }else {
                System.out.println("We have this bus");
                adminConsole();
            }
        } else if (num == 2) {
            System.out.println("Add driver");
            System.out.println("Name: ");
            String driverName = scanner.next();
            System.out.println("Driver logIn: ");
            String driverLogIn = scanner.next();
            User user1 = Storage.userList.stream().filter(user -> user.getLogIn().equals(driverLogIn)).findFirst().orElse(null);
            if(user1 == null){
            System.out.println("Driver password: ");
            String driverPassword = scanner.next();
            User user = new User(driverName, driverLogIn, driverPassword, Role.DRIVER, 0d,User.currentId);
            Storage.userList.add(user);
            Storage.driversList.add(user);
            System.out.println("add succesfully");
            adminConsole();
            }else {
                System.out.println("We have this user");
                adminConsole();
            }
        } else if (num == 3) {
            ITravel.getTravell().travelConsole();
        } else if (num == 4) {
            System.out.println("Don't aviable buses: ");
            Storage.busesList.forEach(System.out::println);
            System.out.println("Sold buses");
            Storage.soldBusSeat.forEach(System.out::println);
            adminConsole();
        } else if (num == 0) {
            IMainMenu.mainMenu();
        } else {
            System.out.println("you entered wrong command!!!");
            IMainMenu.mainMenu().startMenu();
        }
    }
}
