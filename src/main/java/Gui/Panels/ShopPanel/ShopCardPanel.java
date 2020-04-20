package Gui.Panels.ShopPanel;

import javax.swing.*;

public class ShopCardPanel extends JPanel {

    private static final int WIDTH_OF_SHOP_CARD_PANEL=1200;      //TODO NEEDS TO CHANGE
    private static final int HEIGHT_OF_SHOP_CARD_PANEL=620;     //TODO NEEDS TO CHANGE
    private static final int NUM_OF_CARD_IN_EVERY_ROW = 5; //TODO NEEDS TO CHANGE



    private static ShopCardPanel shopCardPanel=new ShopCardPanel();
    public static  ShopCardPanel getInstance(){return shopCardPanel;}


    private ShopCardPanel(){
//        setBackground(Color.green);
        setLayout(null);
        JScrollPane jScrollPane =new JScrollPane(this,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }



    public  int getWidthOfShopCardPanel() {
        return WIDTH_OF_SHOP_CARD_PANEL;
    }
    public  int getHeightOfShopCardPanel() {
        return HEIGHT_OF_SHOP_CARD_PANEL;
    }
    public int getNumOfCardInEveryRow(){return NUM_OF_CARD_IN_EVERY_ROW;}

}
