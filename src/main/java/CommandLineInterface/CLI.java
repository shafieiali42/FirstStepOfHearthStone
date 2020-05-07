package CommandLineInterface;

import Controller.Administer;
import Gui.MyMainFrame;
import Gui.Panels.LogInPanel.LogInPage;
import Gui.Panels.MenuPanel.MainMenuPage;
import Player.Player;
import Utility.Sounds;

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

    public static void FirstPage() throws IOException {
//        PlayerManagement playerManagement = new PlayerManagement();
        MyMainFrame.getInstance().setContentPane(LogInPage.getInstance());

    }


    public static void secondPage() {
//        Sounds.playMainSound("src/main/resources/Sounds/FirstAudio.wav");
        Administer.playMainSound("src/main/resources/Sounds/FirstAudio.wav");
        MyMainFrame.getInstance().setContentPane(MainMenuPage.getInstance());
    }

}
