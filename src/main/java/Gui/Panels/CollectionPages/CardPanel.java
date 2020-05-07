package Gui.Panels.CollectionPages;

import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel {


    private static final int NUM_OF_CARD_IN_EVERY_ROW = 6;


    private JScrollPane jScrollPane;
    public static int getNumOfCardInEveryRow() {
        return NUM_OF_CARD_IN_EVERY_ROW;
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
