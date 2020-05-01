package Gui.Panels.GamePage;

import javax.swing.*;

public class HandsCardsPanel extends JPanel {

    private static final int NUMBER_OF_CARDS_PER_ROW =12;
    private static final int WIDTH_OF_EACH_CARD=50;
    private static final int HEIGHT_OF_EACH_CARD=50;
    private static final int WIDTH_OF_HANDS_PANEL=1250;
    private static final int HEIGHT_OF_HANDS_PANEL=85;
    private static HandsCardsPanel myHandsCardsPanel = new HandsCardsPanel();
    private static HandsCardsPanel opponentHandsCardsPanel = new HandsCardsPanel();
    public static HandsCardsPanel getInstanceOfMyHandsCardsPanel() {
        return myHandsCardsPanel;
    }
    private static HandsCardsPanel getInstanceOfOpponentCardsPanel() {
        return opponentHandsCardsPanel;
    }


    public static int getWidthOfEachCard() {
        return WIDTH_OF_EACH_CARD;
    }
    public static int getHeightOfEachCard() {
        return HEIGHT_OF_EACH_CARD;
    }
    public static int getWidthOfHandsPanel() {
        return WIDTH_OF_HANDS_PANEL;
    }
    public static int getHeightOfHandsPanel() {
        return HEIGHT_OF_HANDS_PANEL;
    }


    private HandsCardsPanel(){
        setLayout(null);
        setSize(WIDTH_OF_HANDS_PANEL,HEIGHT_OF_HANDS_PANEL);
    }




}