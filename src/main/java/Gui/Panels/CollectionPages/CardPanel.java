package Gui.Panels.CollectionPages;

import Gui.MyMainFrame;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class CardPanel extends JPanel {

    private static final int WIDTH_OF_CARD_PANEL=1200;      //TODO NEEDS TO CHANGE
    private static final int HEIGHT_OF_CARD_PANEL=5000;     //TODO NEEDS TO CHANGE
    private static final int NUM_OF_CARD_IN_EVERY_ROW = 6; //TODO NEEDS TO CHANGE


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
        setSize(WIDTH_OF_CARD_PANEL,HEIGHT_OF_CARD_PANEL);
       jScrollPane=new JScrollPane(this);
       jScrollPane.setSize(1200,600);
       jScrollPane.setPreferredSize(new Dimension(1200,600));
        jScrollPane.setBounds(0,80,
              1200,600);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setFocusable(false);
        jScrollPane.revalidate();
       jScrollPane.repaint();

    }



    public JScrollPane getJScrollPane() {
        return jScrollPane;
    }

}
