package Gui.Panels.ShopPanel;

import Gui.MyMainFrame;

import javax.swing.*;
import java.awt.*;

public class ShopCardPanel extends JPanel {

    private static final int WIDTH_OF_SHOP_CARD_PANEL=100;      //TODO NEEDS TO CHANGE
    private static final int HEIGHT_OF_SHOP_CARD_PANEL=720;     //TODO NEEDS TO CHANGE
    private static final int NUM_OF_CARD_IN_EVERY_ROW = 4; //TODO NEEDS TO CHANGE


    private JScrollPane jScrollPane;
    private static ShopCardPanel shopCardPanel=new ShopCardPanel();
    public static  ShopCardPanel getInstance(){return shopCardPanel;}


    private ShopCardPanel(){
        setBackground(Color.darkGray);
        setLayout(null);
    }




    public void setJScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
    }
    public JScrollPane getJScrollPane() {
        return jScrollPane;
    }

    public  int getWidthOfShopCardPanel() {
        return WIDTH_OF_SHOP_CARD_PANEL;
    }
    public  int getHeightOfShopCardPanel() {
        return HEIGHT_OF_SHOP_CARD_PANEL;
    }
    public int getNumOfCardInEveryRow(){return NUM_OF_CARD_IN_EVERY_ROW;}

}
