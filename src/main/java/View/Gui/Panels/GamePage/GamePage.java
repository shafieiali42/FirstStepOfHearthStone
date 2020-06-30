package View.Gui.Panels.GamePage;

import Utility.Config2.ConfigLoader;
import View.Gui.Panels.MyMainFrame.MyMainFrame;
import Utility.Constant;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Properties;

public class GamePage extends JPanel {

    private Properties properties;

    {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/GamePage/GamePage.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int WIDTH_OF_END_TURN_PANEL=Integer.parseInt(properties.getProperty("WIDTH_OF_END_TURN_PANEL"));
    int HEIGHT_OF_END_TURN_PANEL=Integer.parseInt(properties.getProperty("HEIGHT_OF_END_TURN_PANEL"));

    private static GamePage gamePage =new GamePage();
    public static GamePage getInstance(){return gamePage;}


    private GamePage(){
        setSize(MyMainFrame.getInstance().getMyFrameWidth(),MyMainFrame.getInstance().getMyFrameHeight());
        setLayout(null);
        LogPanel.getInstance().setPreferredSize(new Dimension(LogPanel.getInstance().getWidthOfLogPanel(),1600));
        LogPanel.getInstance().setFocusable(true);
        LogPanel.getInstance().requestFocus();
        LogPanel.getInstance().setJScrollPane(new JScrollPane(LogPanel.getInstance()));
        LogPanel.getInstance().getJScrollPane().setBounds(0,
                0,LogPanel.getInstance().getWidthOfLogPanel(),LogPanel.getInstance().getHeightOfLogPanel());
        LogPanel.getInstance().getJScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        LogPanel.getInstance().getJScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        LogPanel.getInstance().getJScrollPane().setBorder(null);
        LogPanel.getInstance().getJScrollPane().setFocusable(false);
        this.add(LogPanel.getInstance().getJScrollPane());

        this.addPanel(PlayPanel.getInstance(),LogPanel.getInstance().getWidthOfLogPanel(),0,PlayPanel.getWidthOfPlayPanel(),PlayPanel.getHeightOfPlayPanel());


        this.addPanel(DeckAndEndTurnBtnPanel.getInstance(),LogPanel.getInstance().getWidthOfLogPanel()+PlayPanel.getWidthOfPlayPanel(),0,
                      WIDTH_OF_END_TURN_PANEL, HEIGHT_OF_END_TURN_PANEL);

    }


    public void addPanel(JPanel panel, int x, int y, int width, int height){
        panel.setBounds(x,y,width,height);
        add(panel);
    }

}
