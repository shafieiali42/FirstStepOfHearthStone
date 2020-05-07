package Gui.Panels.GamePage;

import Gui.MyMainFrame;
import Gui.Panels.CollectionPages.CategoryPanel;
import Gui.Panels.CollectionPages.DeckPanel;
import Utility.Constant;

import javax.swing.*;
import java.awt.*;

public class GamePage extends JPanel {

    private static GamePage gamePage =new GamePage();
    public static GamePage getInstance(){return gamePage;}


    private GamePage(){
        setSize(MyMainFrame.getInstance().getMyFrameWidth(),MyMainFrame.getInstance().getMyFrameHeight());
        setLayout(null);

        LogPanel.getInstance().setPreferredSize(new Dimension(LogPanel.getWidthOfLogPanel(),1600));
        LogPanel.getInstance().setFocusable(true);
        LogPanel.getInstance().requestFocus();
        LogPanel.getInstance().setJScrollPane(new JScrollPane(LogPanel.getInstance()));
        LogPanel.getInstance().getJScrollPane().setBounds(0,
                0,LogPanel.getWidthOfLogPanel(),LogPanel.getHeightOfLogPanel());
        LogPanel.getInstance().getJScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        LogPanel.getInstance().getJScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        LogPanel.getInstance().getJScrollPane().setBorder(null);
        LogPanel.getInstance().getJScrollPane().setFocusable(false);
        this.add(LogPanel.getInstance().getJScrollPane());

        this.addPanel(PlayPanel.getInstance(),LogPanel.getWidthOfLogPanel(),0,PlayPanel.getWidthOfPlayPanel(),PlayPanel.getHeightOfPlayPanel());


        this.addPanel(DeckAndEndTurnBtnPanel.getInstance(),LogPanel.getWidthOfLogPanel()+PlayPanel.getWidthOfPlayPanel(),0,
                      Constant.WIDTH_OF_END_TURN_PANEL, Constant.HEIGHT_OF_END_TURN_PANEL);

    }


    public void addPanel(JPanel panel,int x, int y, int width,int height){
        panel.setBounds(x,y,width,height);
        add(panel);
    }

}
