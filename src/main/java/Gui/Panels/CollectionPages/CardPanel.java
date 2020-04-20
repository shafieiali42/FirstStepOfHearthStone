package Gui.Panels.CollectionPages;

import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel {

    private static final int WIDTH_OF_CARD_PANEL=1200;      //TODO NEEDS TO CHANGE
    private static final int HEIGHT_OF_CARD_PANEL=620;     //TODO NEEDS TO CHANGE
    public static final int NUM_OF_CARD_IN_EVERY_ROW = 5; //TODO NEEDS TO CHANGE

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
        JScrollPane jScrollPane =new JScrollPane(this,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


    }

}
