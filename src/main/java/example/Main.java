package example;

import example.player.Players;
import example.service.Check;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Check checks = new Check();
        boolean logged = false;
        String loggedName = null;
        Scanner scanner = new Scanner(System.in);
        while(true){
            if(!logged)
            {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("1. Login");
                System.out.println("2. Registration");
                System.out.println("3. Exit the system");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                String p = scanner.nextLine();
                if(p.equals("1")){
                    System.out.print("Enter your username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();
                    if (!checks.login(username, password)) {
                        System.out.println("Wrong password or username. Try again!");
                    }
                    else{
                        System.out.println("Successfully entered the system");
                        logged = true;
                        loggedName = username;
                    }
                }
                else if(p.equals("2")){
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your surname: ");
                    String surname = scanner.nextLine();
                    System.out.print("Enter new username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter new password: ");
                    String password = scanner.nextLine();

                    if(checks.register(username, password, name, surname)){
                        System.out.println("Successfully registered!");
                    }
                    else{
                        System.out.println("Username have already been used");
                    }
                }
                else{
                    System.exit(0);
                }
            }
            else if(loggedName.equals("admin")){
                System.out.println("Hi ADMIN");
                break;
            }
            else{
                Players player = checks.getPlayers().get(loggedName);
                System.out.println("Hi " + player.name + " " + player.surname);
                break;
            }
        }

    }
}