package View.Gui.Panels.GamePage;


import Utility.Config2.ConfigLoader;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Properties;


public class LogPanel extends JPanel {


    private Properties properties;

    {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/GamePage/Log.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int WIDTH_OF_LOG_PANEL = Integer.parseInt(properties.getProperty("WIDTH_OF_LOG_PANEL"));
    int HEIGHT_OF_LOG_PANEL = Integer.parseInt(properties.getProperty("HEIGHT_OF_LOG_PANEL"));

    private JScrollPane jScrollPane;
    private String log;
    private Color colorOfLogOfEnemy = Color.red;
    private Color getColorOfLogOfMyPlayer = Color.BLACK;

    public int getWidthOfLogPanel() {
        return WIDTH_OF_LOG_PANEL;
    }


    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    private static LogPanel logPanel = new LogPanel();

    public static LogPanel getInstance() {
        return logPanel;
    }


    private LogPanel() {
        setLayout(null);
        setSize(WIDTH_OF_LOG_PANEL, HEIGHT_OF_LOG_PANEL);
        setBackground(Color.green);
        setJScrollPane(new JScrollPane(this));
        log = "";
    }


    private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        removeAll();
        drawString(g, log, 0, 0);
    }


    public JScrollPane getJScrollPane() {
        return jScrollPane;
    }

    public void setJScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
    }


    public int getHeightOfLogPanel() {
        return HEIGHT_OF_LOG_PANEL;
    }
}
