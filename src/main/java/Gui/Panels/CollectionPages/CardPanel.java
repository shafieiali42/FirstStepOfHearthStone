package Gui.Panels.CollectionPages;

import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel {

    private static final int WIDTH_OF_CARD_PANEL=1155;      //TODO NEEDS TO CHANGE
    private static final int HEIGHT_OF_CARD_PANEL=620;     //TODO NEEDS TO CHANGE
    private static final int NUM_OF_CARD_IN_EVERY_ROW = 6; //TODO NEEDS TO CHANGE


    private JScrollPane jScrollPane;
    public static int getNumOfCardInEveryRow() {
        return NUM_OF_CARD_IN_EVERY_ROW;
    }
    public  int getWidthOfCardPanel() {
        return WIDTH_OF_CARD_PANEL;
    }
    public  int getHeightOfCardPanel() {
        return HEIGHT_OF_CARD_PANEL;
    }

    private static CardPanel cardPanelForCollectionPage =new CardPanel();
    public static CardPanel getInstanceOfCollectionPage(){return cardPanelForCollectionPage;}

    private static CardPanel cardPanelForDeckPage=new CardPanel();
    public static CardPanel getInstanceOfDeckPage(){return cardPanelForDeckPage;}



    private CardPanel(){
        setBackground(Color.gray);
        setLayout(null);
        setJScrollPane(new JScrollPane(this));

    }

    public void setJScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
    }

    public JScrollPane getJScrollPane() {
        return jScrollPane;
    }

}
