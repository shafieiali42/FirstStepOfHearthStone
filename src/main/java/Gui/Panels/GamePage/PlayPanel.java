package Gui.Panels.GamePage;

import Controller.Administer;


import Utility.Constant;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static Utility.Constant.*;

public class PlayPanel extends JPanel {

    private BufferedImage heroImage;
    private BufferedImage heroPowerImage;
    private BufferedImage weaponImage;
    private boolean needsToRepaint = true;
    private int typeOfBackOfCards=1;
    private static PlayPanel playPanel= new PlayPanel();

    public static PlayPanel getInstance() {
        return playPanel;
    }

    private static final int WIDTH_OF_PLAY_PANEL = 1115;
    private static final int HEIGHT_OF_PLAY_PANEL = 770;


    private PlayPanel(){
        setLayout(null);
        setBackground(Color.gray);
        setSize(WIDTH_OF_PLAY_PANEL, HEIGHT_OF_PLAY_PANEL);
    }


    public void defineImagesOfHeroAndHeroPower() throws IOException {

        heroImage = ImageIO.read(new File(
                Constant.getInstance().getHeroImages().get(Administer.getNameOfCurrentHeroOfGameState())));

        heroPowerImage = ImageIO.read(
                new File(Constant.getInstance().getHeroPowerImages().get(Administer.getNameOfCurrentHeroOfGameState())));

    }

    public int getTypeOfBackOfCards() {
        return typeOfBackOfCards;
    }

    public void setTypeOfBackOfCards(int typeOfBackOfCards) {
        this.typeOfBackOfCards = typeOfBackOfCards;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawLine(0, Constant.HEIGHT_OF_HANDS_PANEL, WIDTH_OF_GAME_PANEL, HEIGHT_OF_HANDS_PANEL);

        graphics2D.drawLine(0, HEIGHT_OF_HANDS_PANEL + HEIGHT_OF_GAME_PANEL / 2,
                WIDTH_OF_GAME_PANEL, HEIGHT_OF_HANDS_PANEL + HEIGHT_OF_GAME_PANEL / 2);

        graphics2D.drawLine(0, HEIGHT_OF_HANDS_PANEL + HEIGHT_OF_GAME_PANEL,
                WIDTH_OF_GAME_PANEL, HEIGHT_OF_HANDS_PANEL + HEIGHT_OF_GAME_PANEL);
        try {
            if (needsToRepaint) {
                this.removeAll();
                Administer.showHandsCardOfMeAllianceInPlay(this,NUMBER_OF_CARDS_PER_ROW_HANDS_CARDS);
                Administer.showBattleGroundCardsOfMeAllianceInPlay(this,NUMBER_OF_CARDS_PER_ROW_GAME_PANEL);
                Administer.showHandsCardOfOpponentAllianceInPlay(this,NUMBER_OF_CARDS_PER_ROW_HANDS_CARDS,typeOfBackOfCards);
//                MethodsOfShowCardsOnPanel.showHandsCards(GameState.getInstance().getHandsCards(), this, NUMBER_OF_CARDS_PER_ROW_HANDS_CARDS, Alliance.ME);
//                MethodsOfShowCardsOnPanel.showBattleGroundCards(GameState.getInstance().getBattleGroundCards(), this, NUMBER_OF_CARDS_PER_ROW_GAME_PANEL, Alliance.ME);
                this.revalidate();
                needsToRepaint = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            defineImagesOfHeroAndHeroPower();
        } catch (IOException e) {
            e.printStackTrace();
        }

        graphics2D.drawImage(heroImage, X_COORDINATE_OF_HERO_IMAGE, Y_COORDINATE_OF_HERO_IMAGE,
                WIDTH_OF_HERO_IMAGE, HEIGHT_OF_HERO_IMAGE, null);

        graphics2D.drawImage(heroPowerImage, X_COORDINATE_OF_HERO_POWER_IMAGE, Y_COORDINATE_OF_HERO_POWER_IMAGE,
                WIDTH_OF_HERO_POWER_IMAGE, HEIGHT_OF_HERO_POWER_IMAGE, null);

//        graphics2D.drawImage(heroImage, X_COORDINATE_OF_WEAPON, Y_COORDINATE_OF_WEAPON,
//                WIDTH_OF_WEAPON_IMAGE, HEIGHT_OF_WEAPON_IMAGE, null);


        Administer.showWeaponOfGameState(this,WIDTH_OF_WEAPON_IMAGE,HEIGHT_OF_WEAPON_IMAGE,X_COORDINATE_OF_WEAPON,Y_COORDINATE_OF_WEAPON);
        graphics2D.setColor(Color.red);
        graphics2D.setFont(new Font("TimesRoman", Font.ITALIC, 25));
        graphics2D.drawString(Administer.getHealthOfCurrentHeroInGameState()+"",X_COORDINATE_OF_HEAL_FIELD,Y_COORDINATE_OF_HEAL_FIELD);

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

    public boolean getNeedsToRepaint() {
        return needsToRepaint;
    }

    public void setNeedsToRepaint(boolean needsToRepaint) {
        this.needsToRepaint = needsToRepaint;
    }

    public static int getWidthOfPlayPanel() {
        return WIDTH_OF_PLAY_PANEL;
    }

    public static int getHeightOfPlayPanel() {
        return HEIGHT_OF_PLAY_PANEL;
    }


}
