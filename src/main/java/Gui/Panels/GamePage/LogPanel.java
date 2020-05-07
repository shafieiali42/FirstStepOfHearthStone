package Gui.Panels.GamePage;



import javax.swing.*;
import java.awt.*;

public class LogPanel extends JPanel {



    private static final int WIDTH_OF_LOG_PANEL=85;
    private static final int HEIGHT_OF_LOG_PANEL=810;
    private JScrollPane jScrollPane;
    private  String log;
    private Color colorOfLogOfEnemy=Color.red;
    private Color getColorOfLogOfMyPlayer=Color.BLACK;


    public  String getLog() {
        return log;
    }

    public  void setLog(String log) {
        this.log = log;
    }

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
        setJScrollPane(new JScrollPane(this));
        log="";
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



}
