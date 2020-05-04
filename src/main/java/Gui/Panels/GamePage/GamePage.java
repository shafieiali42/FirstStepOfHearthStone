package Gui.Panels.GamePage;

import Gui.MyMainFrame;
import Gui.Panels.CollectionPages.CategoryPanel;
import Gui.Panels.CollectionPages.DeckPanel;

import javax.swing.*;
import java.awt.*;

public class GamePage extends JPanel {

    private static GamePage gamePage =new GamePage();
    public static GamePage getInstance(){return gamePage;}


    private GamePage(){
        setSize(MyMainFrame.getInstance().getMyFrameWidth(),MyMainFrame.getInstance().getMyFrameHeight());
        setLayout(null);

//        this.addPanel(LogPanel.getInstance(),0,0,LogPanel.getWidthOfLogPanel(),LogPanel.getHeightOfLogPanel());
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

//        this.addPanel(HandsCardsPanel.getInstanceOfOpponentCardsPanel(),LogPanel.getWidthOfLogPanel(),0,
//                HandsCardsPanel.getWidthOfHandsPanel(),HandsCardsPanel.getHeightOfHandsPanel());
//
//        this.addPanel(GamePanel.getInstance(),LogPanel.getWidthOfLogPanel(),HandsCardsPanel.getHeightOfHandsPanel(),
//                      GamePanel.getWidthOfGamePanel(),GamePanel.getHeightOfGamePanel());

        this.addPanel(PlayPanel.getInstance(),LogPanel.getWidthOfLogPanel(),0,PlayPanel.getWidthOfPlayPanel(),PlayPanel.getHeightOfPlayPanel());


        this.addPanel(DeckAndEndTurnBtnPanel.getInstance(),LogPanel.getWidthOfLogPanel()+PlayPanel.getWidthOfPlayPanel(),0,
                      DeckAndEndTurnBtnPanel.getWidthOfEndTurnPanel(), DeckAndEndTurnBtnPanel.getHeightOfEndTurnPanel());

//        this.addPanel(HandsCardsPanel.getInstanceOfMyHandsCardsPanel(),LogPanel.getWidthOfLogPanel(),
//                   HandsCardsPanel.getHeightOfHandsPanel()+GamePanel.getHeightOfGamePanel(),
//                      HandsCardsPanel.getWidthOfHandsPanel(),HandsCardsPanel.getHeightOfHandsPanel());

    }





    public void addPanel(JPanel panel,int x, int y, int width,int height){
        panel.setBounds(x,y,width,height);
        add(panel);
    }


}
