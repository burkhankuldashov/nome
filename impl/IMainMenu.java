package impl;

import enums.Role;
import interfacec.MainMenu;
import objectss.Storage;
import objectss.User;

import java.util.Scanner;

public class IMainMenu implements MainMenu {
    private static MainMenu mainMenu;
    public static MainMenu mainMenu(){
        if(mainMenu == null){
            mainMenu = new IMainMenu();
        }
        return mainMenu;
    }

    @Override
    public void startMenu() {
        User user = new User("Admin","admin","admin", Role.ADMIN,0d,User.currentId);
        Storage.userList.add(user);
        System.out.println("Welcome to our company!!!");
        System.out.println("1-sign in, 2- sign up");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if(num == 1){
            IUser.getUser().signIn();
        } else if (num == 2) {
        IUser.getUser().signUp();
        }else{
            System.out.println("you entered wrong command!!");
            System.err.println("Try again!");
            IMainMenu.mainMenu().startMenu();
        }
    }
}
