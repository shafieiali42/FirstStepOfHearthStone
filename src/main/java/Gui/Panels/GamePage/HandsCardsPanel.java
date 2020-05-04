//package Gui.Panels.GamePage;
//
//import Logic.GameState;
//import Utility.MethodsOfShowCardsOnPanel;
//
//import javax.swing.*;
//import java.awt.*;
//import java.io.IOException;
//
//public class HandsCardsPanel extends JPanel {
//
//
//
//    private static final int NUMBER_OF_CARDS_PER_ROW =12;
//    private static final int WIDTH_OF_EACH_CARD=50;
//    private static final int HEIGHT_OF_EACH_CARD=80;
//    private static final int WIDTH_OF_HANDS_PANEL=1115;
//    private static final int HEIGHT_OF_HANDS_PANEL=100;
//    private static HandsCardsPanel myHandsCardsPanel = new HandsCardsPanel();
//    private static HandsCardsPanel opponentHandsCardsPanel = new HandsCardsPanel();
//    public static HandsCardsPanel getInstanceOfMyHandsCardsPanel() {
//        return myHandsCardsPanel;
//    }
//    public static HandsCardsPanel getInstanceOfOpponentCardsPanel() {
//        return opponentHandsCardsPanel;
//    }
//
//
//    public static int getWidthOfEachCard() {
//        return WIDTH_OF_EACH_CARD;
//    }
//    public static int getHeightOfEachCard() {
//        return HEIGHT_OF_EACH_CARD;
//    }
//    public static int getWidthOfHandsPanel() {
//        return WIDTH_OF_HANDS_PANEL;
//    }
//    public static int getHeightOfHandsPanel() {
//        return HEIGHT_OF_HANDS_PANEL;
//    }
//
//
//
//    private HandsCardsPanel(){
//        setLayout(null);
//        setBackground(Color.orange);
//        setSize(WIDTH_OF_HANDS_PANEL,HEIGHT_OF_HANDS_PANEL);
//    }
//
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        try {
//            MethodsOfShowCardsOnPanel.showHandsCards(GameState.getInstance().getHandsCards(),this,NUMBER_OF_CARDS_PER_ROW);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}