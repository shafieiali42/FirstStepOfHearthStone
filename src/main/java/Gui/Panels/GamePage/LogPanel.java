package Gui.Panels.GamePage;

import javax.swing.*;
import java.awt.*;

public class LogPanel extends JPanel {

    private static final int WIDTH_OF_LOG_PANEL=50;
    private static final int HEIGHT_OF_LOG_PANEL=810;

    private static LogPanel logPanel=new LogPanel();
    public static LogPanel getInstance(){return logPanel;}

    public static int getWidthOfLogPanel() {
        return WIDTH_OF_LOG_PANEL;
    }
    public static int getHeightOfLogPanel() {
        return HEIGHT_OF_LOG_PANEL;
    }

    private LogPanel(){
        setLayout(null);
        setSize(WIDTH_OF_LOG_PANEL,HEIGHT_OF_LOG_PANEL);
        setBackground(Color.green);
    }



}
