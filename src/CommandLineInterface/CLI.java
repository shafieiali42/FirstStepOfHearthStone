package CommandLineInterface;

import Cards.Minion;
import Player.Player;

import java.io.IOException;
import java.util.Scanner;

public class CLI {
    public static Player currentPlayer ;
    private static Status status = Status.MAIN_PAGE;
    public static Status getStatus() {
        return status;
    }
    public static void setStatus(Status status) {
        CLI.status = status;
    }
    public static void FirstPage() throws IOException {
        PlayerManagement playerManagement = new PlayerManagement();
        setStatus(Status.MAIN_PAGE);
        Scanner myscanner =new Scanner(System.in);
        boolean repeat=true;
        while (repeat){
            System.out.println("Already have an account?(Y/N)");
            switch (myscanner.nextLine().toLowerCase()){
                case "y":
                    System.out.println("hi!");
                    playerManagement.signIn();
                    break;
                case "n":
                    playerManagement.signUp();
                    break;
//                case "exit":
//                    playerManagement.logOut();
//                    break;
                case "exit_a":
                    System.exit(0);
                    break;
                default:
                    System.out.println(" Please Enter a valid command!");
            }
        }
    }

    public static void secondPage() throws IOException {
        PlayerManagement playerManagement = new PlayerManagement();
        Scanner myscanner =new Scanner(System.in);
        boolean repeat = true;
        System.out.println("what can I do for you?\n1)Exit\n2)Exit_a\n3)Delete-Player\n4)Collections\n5)Store");
        while (repeat){
            switch (myscanner.nextLine().toLowerCase()){
                case "exit":
                    playerManagement.logOut();
                    repeat=false;
                    FirstPage();
                    break;
                case "exit -a":
                    System.exit(0);
                    break;
                case "delete -player":
                    playerManagement.DeletePlayer();
                    break;
                case "collections":
                    CollectionManagement.CollectionPage();
                    break;
                case "store":
                    ShopManagement.ShopPage();
                    break;
                default:
                    System.out.println(" Please Enter a valid command!");
            }
        }
    }



}
