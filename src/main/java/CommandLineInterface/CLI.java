package CommandLineInterface;

import Gui.MyMainFrame;
import Gui.Panels.LogInPanel.LogInPage;
import Gui.Panels.MenuPanel.MainMenuPage;
import Player.Player;

import java.io.IOException;
import java.util.Scanner;

public class CLI {
    public static Player currentPlayer;

    private static Status status;

    public static Status getStatus() {
        return status;
    }

    public static void setStatus(Status status) {
        CLI.status = status;
    }

    //    public static void FirstPage() throws IOException {
//        PlayerManagement playerManagement = new PlayerManagement();
//        Scanner myscanner =new Scanner(System.in);
//        boolean repeat=true;
//        while (repeat){
//            System.out.println("Already have an account?(Y/N)");
//            switch (myscanner.nextLine().toLowerCase()){
//                case "y":
//                    playerManagement.signIn();
//                    break;
//                case "n":
//                    playerManagement.signUp();
//                    break;
//                case "exit_a":
//                    playerManagement.logOut();
//                    System.exit(0);
//                    break;
//                case  "hearthstone --help":
//                    System.out.print("\tpress y in order to sign in\n\tpress n in order to sign up\n\t" +
//                                    "press exit -a in order to exit program\n");
//                    break;
//                default:
//                    System.out.println(" Please Enter a valid command!");
//            }
//        }
//    }
    public static void FirstPage() throws IOException {
//        PlayerManagement playerManagement = new PlayerManagement();
        MyMainFrame.getInstance().setContentPane(LogInPage.getInstance());

    }

    //    public static void secondPage() throws IOException {
////        PlayerManagement playerManagement = new PlayerManagement();
//        Scanner myscanner = new Scanner(System.in);
//        boolean repeat = true;
//        System.out.println("what can I do for you?\n1)Exit\n2)Exit_a\n3)Delete-Player\n4)Collections\n5)Store");
//        while (repeat) {
//            switch (myscanner.nextLine().toLowerCase()) {
//                case "exit":
//                    PlayerManagement.logOut();
//                    repeat = false;
//                    FirstPage();
//                    break;
//                case "exit -a":
//                    PlayerManagement.logOut();
//                    System.exit(0);
//                    break;
//                case "delete -player":
//                    PlayerManagement.DeletePlayer();
//                    break;
//                case "collections":
//                    CLI.currentPlayer.getLoggerOfMyPlayer().info("Navigate: Collections");
//                    CollectionManagement.CollectionPage();
//                    break;
//                case "store":
//                    CLI.currentPlayer.getLoggerOfMyPlayer().info("Navigate: Store");
//                    ShopManagement.ShopPage();
//                    break;
//                case "hearthstone --help":
//                    System.out.print("\tpress exit in order to logout\n\tpress exit -a in order to exit program\n\t" +
//                            "press delete -player in order to Delete Your Account\n\t" +
//                            "press collections in order to go to collection page\n\t" +
//                            "press store in order to go to store page.\n");
//                    break;
//                default:
//                    System.out.println(" Please Enter a valid command!");
//            }
//        }
//    }
    public static void secondPage() throws IOException {

        MyMainFrame.getInstance().setContentPane(MainMenuPage.getInstance());
    }

}
