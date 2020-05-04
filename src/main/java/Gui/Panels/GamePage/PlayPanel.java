package Gui.Panels.GamePage;

import Logic.Alliance;
import Logic.GameState;
import Utility.MethodsOfShowCardsOnPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PlayPanel extends JPanel {

    private static final int WIDTH_OF_GAME_PANEL = 1115;
    private static final int HEIGHT_OF_GAME_PANEL = 600;
    private static final int MIN_X_FOR_PUT_CARDS = 20;
    private static final int MAX_X_FOR_PUT_CARDS = 20;
    private static final int MIN_Y_FOR_PUT_CARDS = 20;
    private static final int MAX_Y_FOR_PUT_CARDS = 20;
    private static final int WIDTH_OF_EACH_CARD_GAME_PANEL = 95;
    private static final int HEIGHT_OF_EACH_CARD_GAME_PANEL = 110;
    private static final int NUMBER_OF_CARDS_PER_ROW_GAME_PANEL = 7;


    private static final int NUMBER_OF_CARDS_PER_ROW_HANDS_CARDS = 12;
    private static final int WIDTH_OF_EACH_CARD_HANDS_CARDS = 65;
    private static final int HEIGHT_OF_EACH_CARD_HANDS_CARDS = 80;
    private static final int WIDTH_OF_HANDS_PANEL = 1115;
    private static final int HEIGHT_OF_HANDS_PANEL = 85;

    private boolean needsToRepaint = true;

    public boolean isNeedsToRepaint() {
        return needsToRepaint;
    }

    public void setNeedsToRepaint(boolean needsToRepaint) {
        this.needsToRepaint = needsToRepaint;
    }

    private static PlayPanel playPanel = new PlayPanel();

    public static PlayPanel getInstance() {
        return playPanel;
    }

    private static final int WIDTH_OF_PLAY_PANEL = 1115;
    private static final int HEIGHT_OF_PLAY_PANEL = 770;

    public static int getWidthOfPlayPanel() {
        return WIDTH_OF_PLAY_PANEL;
    }

    public static int getHeightOfPlayPanel() {
        return HEIGHT_OF_PLAY_PANEL;
    }


    private PlayPanel() {
        setLayout(null);
//        setBackground(Color.cyan);
        setSize(WIDTH_OF_PLAY_PANEL, HEIGHT_OF_PLAY_PANEL);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawLine(0, HEIGHT_OF_HANDS_PANEL, WIDTH_OF_GAME_PANEL, HEIGHT_OF_HANDS_PANEL);

        graphics2D.drawLine(0, HEIGHT_OF_HANDS_PANEL + HEIGHT_OF_GAME_PANEL / 2,
                WIDTH_OF_GAME_PANEL, HEIGHT_OF_HANDS_PANEL + HEIGHT_OF_GAME_PANEL / 2);

        graphics2D.drawLine(0, HEIGHT_OF_HANDS_PANEL + HEIGHT_OF_GAME_PANEL,
                WIDTH_OF_GAME_PANEL, HEIGHT_OF_HANDS_PANEL + HEIGHT_OF_GAME_PANEL);
        try {
            if (needsToRepaint) {
                this.removeAll();
                MethodsOfShowCardsOnPanel.showHandsCards(GameState.getInstance().getHandsCards(), this, NUMBER_OF_CARDS_PER_ROW_HANDS_CARDS, Alliance.ME);
                MethodsOfShowCardsOnPanel.showBattleGroundCards(GameState.getInstance().getBattleGroundCards(), this, NUMBER_OF_CARDS_PER_ROW_GAME_PANEL, Alliance.ME);
                this.revalidate();
                needsToRepaint = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static int getMinXForPutCards() {
        return MIN_X_FOR_PUT_CARDS;
    }

    public static int getMaxXForPutCards() {
        return MAX_X_FOR_PUT_CARDS;
    }

    public static int getMinYForPutCards() {
        return MIN_Y_FOR_PUT_CARDS;
    }

    public static int getMaxYForPutCards() {
        return MAX_Y_FOR_PUT_CARDS;
    }

    public static int getWidthOfEachCardGamePanel() {
        return WIDTH_OF_EACH_CARD_GAME_PANEL;
    }

    public static int getHeightOfEachCardGamePanel() {
        return HEIGHT_OF_EACH_CARD_GAME_PANEL;
    }

    public static int getWidthOfGamePanel() {
        return WIDTH_OF_GAME_PANEL;
    }

    public static int getHeightOfGamePanel() {
        return HEIGHT_OF_GAME_PANEL;
    }


    public static int getWidthOfEachCardHandsCards() {
        return WIDTH_OF_EACH_CARD_HANDS_CARDS;
    }

    public static int getHeightOfEachCardHandsCards() {
        return HEIGHT_OF_EACH_CARD_HANDS_CARDS;
    }

    public static int getWidthOfHandsPanel() {
        return WIDTH_OF_HANDS_PANEL;
    }

    public static int getHeightOfHandsPanel() {
        return HEIGHT_OF_HANDS_PANEL;
    }


}
