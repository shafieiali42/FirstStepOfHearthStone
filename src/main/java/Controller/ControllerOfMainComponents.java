package Controller;

import Logic.Status;
import View.Gui.Panels.LogInPanel.LogInPage;
import View.Gui.Panels.MenuPanel.MainMenuPage;
import Models.Player.Player;
import View.Gui.Panels.MyMainFrame.MyMainFrame;

import java.io.IOException;

public class ControllerOfMainComponents {
    public static Player currentPlayer;

    private static Status status;

    public static Status getStatus() {
        return status;
    }

    public static void setStatus(Status status) {
        ControllerOfMainComponents.status = status;
    }

    public static void FirstPage() throws IOException {
        MyMainFrame.getInstance().setContentPane(LogInPage.getInstance());
    }


    public static void secondPage() {
        Administer.playMainSound("src/main/resources/Sounds/FirstAudio.wav");
        MyMainFrame.getInstance().setContentPane(MainMenuPage.getInstance());
    }

}
