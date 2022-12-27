package impl;

import enums.Role;
import interfacec.Userr;
import objectss.*;

import java.util.Scanner;

public class IUser implements Userr {
    private static Userr userr;

    public static Userr getUser() {
        if (userr == null) {
            userr = new IUser();
        }
        return userr;
    }

    @Override
    public void signIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username: ");
        String logIn = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        User user = Storage.userList.stream().filter(user1 -> user1.getLogIn().equals(logIn) && user1.getPassword().equals(password))
                .findFirst().orElse(null);
        if (user != null) {
            if (user.getRole().equals(Role.ADMIN)) {
                IAdmin.getAdmin().adminConsole();
                IMainMenu.mainMenu().startMenu();
            } else if (user.getRole().equals(Role.DRIVER)) {
                System.out.println("Travel driver list: ");
                Storage.travelDriversList.forEach(System.out::println);
                IMainMenu.mainMenu().startMenu();
            } else {
                openUserConsole(user);
            }
        } else {
            System.err.println("We have no this user!!!");
            IMainMenu.mainMenu().startMenu();
        }
    }

    @Override
    public void signUp() {
        System.out.println("Name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Username: ");
        String logIn = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();
        User user = Storage.userList.stream().filter(user1 -> user1.getLogIn().equals(logIn)).findFirst().orElse(null);
        if (user == null) {
            User user1 = new User(name, logIn, password, Role.USER, 0d, User.currentId);
            Storage.userList.add(user1);
            IMainMenu.mainMenu().startMenu();
        } else {
            System.out.println("we have this user!!!!");
            IMainMenu.mainMenu().startMenu();
        }

    }

    public static void openUserConsole(User user) {
        System.out.println("User console");
        System.out.println("1-all Travel,2- my travel 0- exit");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int a = num;
        if (num == 1) {
            Storage.travelList.forEach(System.out::println);
            System.out.println("Chose travel:");
            int numm = scanner.nextInt();
            System.out.println("seats: ");
            int nam = scanner.nextInt();
            int i = Storage.busesList.get(numm).getBusOfSeat() - nam;
            if (i >= 0) {
                int id = Storage.travelList.get(numm).getBuses().getId();
                Buses buses = Storage.busesList.get(id);
                Storage.orderArrayList.get(numm).getBuses().setBusOfSeat(nam);
                Storage.soldBusSeat.add(buses);
                Storage.busesList.get(id).setBusOfSeat(i);
                openUserConsole(user);
            } else {
                System.err.println("you can not sold seat!");
                openUserConsole(user);
            }
        } else if (num == 0) {
            IMainMenu.mainMenu().startMenu();
        } else if (num == 2) {
            Storage.orderArrayList.forEach(System.out::println);
            //price
            IMainMenu.mainMenu().startMenu();
        } else {
            System.out.println("You entererd wrong command.");
            openUserConsole(user);
        }
    }
}
