package Gui.Panels.CollectionPages;

import Gui.MyMainFrame;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class CardPanel extends JPanel {

    private static final int WIDTH_OF_CARD_PANEL=1200;      //TODO NEEDS TO CHANGE
    private static final int HEIGHT_OF_CARD_PANEL=620;     //TODO NEEDS TO CHANGE
    private static final int NUM_OF_CARD_IN_EVERY_ROW = 5; //TODO NEEDS TO CHANGE


    public JScrollPane jScrollPane;
    public static int getNumOfCardInEveryRow() {
        return NUM_OF_CARD_IN_EVERY_ROW;
    }
    public  int getWidthOfCardPanel() {
        return WIDTH_OF_CARD_PANEL;
    }
    public  int getHeightOfCardPanel() {
        return HEIGHT_OF_CARD_PANEL;
    }

    private static CardPanel cardPanel=new CardPanel();
    public static CardPanel getInstance(){return cardPanel;}



    private CardPanel(){
//        setBackground(Color.green);
        setLayout(null);
        setMinimumSize(new Dimension(this.getWidthOfCardPanel(),this.getHeightOfCardPanel()));
         jScrollPane =new JScrollPane(this,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

//        jScrollPane.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));

//
    }



    public JScrollPane getJScrollPane() {
        return jScrollPane;
    }

}
