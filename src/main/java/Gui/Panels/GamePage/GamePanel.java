//package Gui.Panels.GamePage;
//
//import Logic.GameState;
//import Utility.MethodsOfShowCardsOnPanel;
//
//import javax.swing.*;
//import java.awt.*;
//import java.io.IOException;
//
//public class GamePanel extends JPanel {
//
//
////    private static final int WIDTH_OF_GAME_PANEL = 1115;
////    private static final int HEIGHT_OF_GAME_PANEL = 570;
////    private static final int MIN_X_FOR_PUT_CARDS = 20;
////    private static final int MAX_X_FOR_PUT_CARDS = 20;
////    private static final int MIN_Y_FOR_PUT_CARDS = 20;
////    private static final int MAX_Y_FOR_PUT_CARDS = 20;
////    private static final int WIDTH_OF_EACH_CARD = 50;
////    private static final int HEIGHT_OF_EACH_CARD = 50;
////    private static final int NUMBER_OF_CARDS_PER_ROW = 7;
//
//
//    private static GamePanel gamePanel = new GamePanel();
//
//    public static GamePanel getInstance() {
//        return gamePanel;
//    }
//
//    private GamePanel() {
//        setLayout(null);
//        setBackground(Color.pink);
//
//    }
//
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D graphics2D=(Graphics2D)g;
//        try {
//            graphics2D.setColor(Color.RED);
//            graphics2D.drawLine(0,HEIGHT_OF_GAME_PANEL/2,WIDTH_OF_GAME_PANEL,HEIGHT_OF_GAME_PANEL/2);
//            MethodsOfShowCardsOnPanel.showBattleGroundCards(GameState.getInstance().getBattleGroundCards(), this, NUMBER_OF_CARDS_PER_ROW);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    public static int getMinXForPutCards() {
//        return MIN_X_FOR_PUT_CARDS;
//    }
//
//    public static int getMaxXForPutCards() {
//        return MAX_X_FOR_PUT_CARDS;
//    }
//
//    public static int getMinYForPutCards() {
//        return MIN_Y_FOR_PUT_CARDS;
//    }
//
//    public static int getMaxYForPutCards() {
//        return MAX_Y_FOR_PUT_CARDS;
//    }
//
//    public static int getWidthOfEachCard() {
//        return WIDTH_OF_EACH_CARD;
//    }
//
//    public static int getHeightOfEachCard() {
//        return HEIGHT_OF_EACH_CARD;
//    }
//
//    public static int getWidthOfGamePanel() {
//        return WIDTH_OF_GAME_PANEL;
//    }
//
//    public static int getHeightOfGamePanel() {
//        return HEIGHT_OF_GAME_PANEL;
//    }
//}
