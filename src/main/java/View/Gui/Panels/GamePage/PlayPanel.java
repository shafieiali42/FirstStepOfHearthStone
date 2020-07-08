package View.Gui.Panels.GamePage;

import Controller.Administer;
import Utility.Config2.ConfigLoader;
import Utility.Constant;
import View.Gui.Animation.AnimationOfRotation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;


public class PlayPanel extends JPanel {

    private static Properties properties;

    {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/GamePage/Play.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int HEIGHT_OF_HANDS_PANEL = Integer.parseInt(properties.getProperty("HEIGHT_OF_HANDS_PANEL"));
    int WIDTH_OF_GAME_PANEL = Integer.parseInt(properties.getProperty("WIDTH_OF_GAME_PANEL"));
    int HEIGHT_OF_GAME_PANEL = Integer.parseInt(properties.getProperty("HEIGHT_OF_GAME_PANEL"));
    int NUMBER_OF_CARDS_PER_ROW_HANDS_CARDS = Integer.parseInt(properties.getProperty("NUMBER_OF_CARDS_PER_ROW_HANDS_CARDS"));
    int NUMBER_OF_CARDS_PER_ROW_GAME_PANEL = Integer.parseInt(properties.getProperty("NUMBER_OF_CARDS_PER_ROW_GAME_PANEL"));
    int X_COORDINATE_OF_HERO_IMAGE = Integer.parseInt(properties.getProperty("X_COORDINATE_OF_HERO_IMAGE"));
    int Y_COORDINATE_OF_HERO_IMAGE = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_HERO_IMAGE"));
    int WIDTH_OF_HERO_IMAGE = Integer.parseInt(properties.getProperty("WIDTH_OF_HERO_IMAGE"));
    int HEIGHT_OF_HERO_IMAGE = Integer.parseInt(properties.getProperty("HEIGHT_OF_HERO_IMAGE"));
    int X_COORDINATE_OF_HERO_POWER_IMAGE = Integer.parseInt(properties.getProperty("X_COORDINATE_OF_HERO_POWER_IMAGE"));
    int Y_COORDINATE_OF_HERO_POWER_IMAGE = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_HERO_POWER_IMAGE"));
    int WIDTH_OF_HERO_POWER_IMAGE = Integer.parseInt(properties.getProperty("WIDTH_OF_HERO_POWER_IMAGE"));
    int HEIGHT_OF_HERO_POWER_IMAGE = Integer.parseInt(properties.getProperty("HEIGHT_OF_HERO_POWER_IMAGE"));
    int WIDTH_OF_WEAPON_IMAGE = Integer.parseInt(properties.getProperty("WIDTH_OF_WEAPON_IMAGE"));
    int HEIGHT_OF_WEAPON_IMAGE = Integer.parseInt(properties.getProperty("HEIGHT_OF_WEAPON_IMAGE"));
    int X_COORDINATE_OF_WEAPON = Integer.parseInt(properties.getProperty("X_COORDINATE_OF_WEAPON"));
    int Y_COORDINATE_OF_WEAPON = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_WEAPON"));
    int X_COORDINATE_OF_HEAL_FIELD = Integer.parseInt(properties.getProperty("X_COORDINATE_OF_HEAL_FIELD"));
    int Y_COORDINATE_OF_HEAL_FIELD = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_HEAL_FIELD"));
    int MIN_X_FOR_PUT_CARDS = Integer.parseInt(properties.getProperty("MIN_X_FOR_PUT_CARDS"));
    int MAX_X_FOR_PUT_CARDS = Integer.parseInt(properties.getProperty("MAX_X_FOR_PUT_CARDS"));
    int MIN_Y_FOR_PUT_CARDS = Integer.parseInt(properties.getProperty("MIN_Y_FOR_PUT_CARDS"));
    int MAX_Y_FOR_PUT_CARDS = Integer.parseInt(properties.getProperty("MAX_Y_FOR_PUT_CARDS"));
    int WIDTH_OF_EACH_CARD_GAME_PANEL = Integer.parseInt(properties.getProperty("WIDTH_OF_EACH_CARD_GAME_PANEL"));
    int HEIGHT_OF_EACH_CARD_GAME_PANEL = Integer.parseInt(properties.getProperty("HEIGHT_OF_EACH_CARD_GAME_PANEL"));
    int WIDTH_OF_EACH_CARD_HANDS_CARDS = Integer.parseInt(properties.getProperty("WIDTH_OF_EACH_CARD_HANDS_CARDS"));
    int HEIGHT_OF_EACH_CARD_HANDS_CARDS = Integer.parseInt(properties.getProperty("HEIGHT_OF_EACH_CARD_HANDS_CARDS"));
    int WIDTH_OF_HANDS_PANEL = Integer.parseInt(properties.getProperty("WIDTH_OF_HANDS_PANEL"));
    int X_COORDINATE_OF_ENEMY_HERO_IMAGE = Integer.parseInt(properties.getProperty("X_COORDINATE_OF_ENEMY_HERO_IMAGE"));
    int Y_COORDINATE_OF_ENEMY_HERO_IMAGE = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_ENEMY_HERO_IMAGE"));
    int X_COORDINATE_OF_ENEMY_HERO_POWER_IMAGE = Integer.parseInt(properties.getProperty("X_COORDINATE_OF_ENEMY_HERO_POWER_IMAGE"));
    int Y_COORDINATE_OF_ENEMY_HERO_POWER_IMAGE = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_ENEMY_HERO_POWER_IMAGE"));
    int X_COORDINATE_OF__ENEMY_WEAPON = Integer.parseInt(properties.getProperty("X_COORDINATE_OF__ENEMY_WEAPON"));
    int Y_COORDINATE_OF_ENEMY_WEAPON = Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_ENEMY_WEAPON"));
//    static int WIDTH_OF_PLAY_PANEL = Integer.parseInt(properties.getProperty("WIDTH_OF_PLAY_PANEL"));
//    static int HEIGHT_OF_PLAY_PANEL = Integer.parseInt(properties.getProperty("HEIGHT_OF_PLAY_PANEL"));

    static int WIDTH_OF_PLAY_PANEL = 1115;
    static int HEIGHT_OF_PLAY_PANEL = 770;

    private BufferedImage heroImage;
    private BufferedImage heroPowerImage;
    private BufferedImage weaponImage;
    private BufferedImage enemyHeroImage;
    private BufferedImage enemyHeroPowerImage;
    private BufferedImage enemyWeaponImage;
    private boolean needsToRepaint = true;
    private int typeOfBackOfCards = 1;
    private static PlayPanel playPanel = new PlayPanel();

    public static PlayPanel getInstance() {
        return playPanel;
    }

    boolean needAnimation = false;

    private PlayPanel() {
        setLayout(null);
        setBackground(Color.gray);
        setSize(WIDTH_OF_PLAY_PANEL, HEIGHT_OF_PLAY_PANEL);
    }


    public void defineImagesOfHeroAndHeroPower() throws IOException {

        heroImage = ImageIO.read(new File(
                Constant.getInstance().getHeroImages().get(Administer.getNameOfFriendlyHeroOfGameState())));

        heroPowerImage = ImageIO.read(
                new File(Constant.getInstance().getHeroPowerImages().get(Administer.getNameOfFriendlyHeroOfGameState())));

    }

    public void defineImagesOfEnemyHeroAndHeroPower() throws IOException {


        enemyHeroImage = ImageIO.read(new File(
                Constant.getInstance().getHeroImages().get(Administer.getNameOfEnemyHeroOfGameState())));
        int w = enemyHeroImage.getWidth();
        int h = enemyHeroImage.getHeight();
        AffineTransform scaleTransform = new AffineTransform();
// last-in-first-applied: rotate, scale
        scaleTransform.scale(1, 1);
        scaleTransform.rotate(Math.PI, w / 2, h / 2);
        AffineTransformOp scaleOp = new AffineTransformOp(
                scaleTransform, AffineTransformOp.TYPE_BILINEAR);
        enemyHeroImage = scaleOp.filter(enemyHeroImage, null);

        enemyHeroPowerImage = ImageIO.read(
                new File(Constant.getInstance().getHeroPowerImages().get(Administer.getNameOfEnemyHeroOfGameState())));
        int width = enemyHeroPowerImage.getWidth();
        int height = enemyHeroPowerImage.getHeight();
        AffineTransform scaleTransform2 = new AffineTransform();

        scaleTransform2.scale(1, 1);
        scaleTransform2.rotate(Math.PI, width / 2, height / 2);
        AffineTransformOp scaleOp2 = new AffineTransformOp(
                scaleTransform2, AffineTransformOp.TYPE_BILINEAR);
        enemyHeroPowerImage = scaleOp2.filter(enemyHeroPowerImage, null);

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/main/resources/Assets/map1.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        graphics2D.drawImage(image,0,0,1115,770,null);
        graphics2D.drawLine(0, HEIGHT_OF_HANDS_PANEL, WIDTH_OF_GAME_PANEL, HEIGHT_OF_HANDS_PANEL);

        graphics2D.drawLine(0, HEIGHT_OF_HANDS_PANEL + HEIGHT_OF_GAME_PANEL / 2,
                WIDTH_OF_GAME_PANEL, HEIGHT_OF_HANDS_PANEL + HEIGHT_OF_GAME_PANEL / 2);

        graphics2D.drawLine(0, HEIGHT_OF_HANDS_PANEL + HEIGHT_OF_GAME_PANEL,
                WIDTH_OF_GAME_PANEL, HEIGHT_OF_HANDS_PANEL + HEIGHT_OF_GAME_PANEL);


        if (needAnimation) {
            String[] strings = new String[1];
            AnimationOfRotation.main(strings);
            needAnimation = false;
            needsToRepaint = true;
        }


        try {
            if (needsToRepaint) {
                this.removeAll();
                Administer.showFriendlyHandsCardInPlay(this, NUMBER_OF_CARDS_PER_ROW_HANDS_CARDS);
                Administer.showFriendlyBattleGroundCardsInPlay(this, NUMBER_OF_CARDS_PER_ROW_GAME_PANEL);
                Administer.showEnemyBattleGroundCardsInPlay(this, NUMBER_OF_CARDS_PER_ROW_GAME_PANEL);
                Administer.showEnemyHandsCardInPlay(this, NUMBER_OF_CARDS_PER_ROW_HANDS_CARDS, typeOfBackOfCards, Administer.getGameMode());
                this.revalidate();
                needsToRepaint = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            defineImagesOfHeroAndHeroPower();
            defineImagesOfEnemyHeroAndHeroPower();
        } catch (IOException e) {
            e.printStackTrace();
        }

        graphics2D.drawImage(heroImage, X_COORDINATE_OF_HERO_IMAGE, Y_COORDINATE_OF_HERO_IMAGE,
                WIDTH_OF_HERO_IMAGE, HEIGHT_OF_HERO_IMAGE, null);

        graphics2D.drawImage(heroPowerImage, X_COORDINATE_OF_HERO_POWER_IMAGE, Y_COORDINATE_OF_HERO_POWER_IMAGE,
                WIDTH_OF_HERO_POWER_IMAGE, HEIGHT_OF_HERO_POWER_IMAGE, null);

        graphics2D.drawImage(enemyHeroImage, X_COORDINATE_OF_ENEMY_HERO_IMAGE, Y_COORDINATE_OF_ENEMY_HERO_IMAGE,
                WIDTH_OF_HERO_IMAGE, HEIGHT_OF_HERO_IMAGE, null);

        graphics2D.drawImage(enemyHeroPowerImage, X_COORDINATE_OF_ENEMY_HERO_POWER_IMAGE, Y_COORDINATE_OF_ENEMY_HERO_POWER_IMAGE,
                WIDTH_OF_HERO_POWER_IMAGE, HEIGHT_OF_HERO_POWER_IMAGE, null);

//        graphics2D.drawImage(heroImage, X_COORDINATE_OF_WEAPON, Y_COORDINATE_OF_WEAPON,
//                WIDTH_OF_WEAPON_IMAGE, HEIGHT_OF_WEAPON_IMAGE, null);


        Administer.showFriendlyWeaponOfGameState(this, WIDTH_OF_WEAPON_IMAGE, HEIGHT_OF_WEAPON_IMAGE, X_COORDINATE_OF_WEAPON, Y_COORDINATE_OF_WEAPON);
        Administer.showEnemyWeaponOfGameState(this, WIDTH_OF_WEAPON_IMAGE, HEIGHT_OF_WEAPON_IMAGE, X_COORDINATE_OF__ENEMY_WEAPON, Y_COORDINATE_OF_ENEMY_WEAPON);

        graphics2D.setColor(Color.red);
        graphics2D.setFont(new Font("TimesRoman", Font.ITALIC, 25));
        graphics2D.drawString(Administer.getHpOfCurrentFriendlyHeroInGameState() + "", X_COORDINATE_OF_HEAL_FIELD, Y_COORDINATE_OF_HEAL_FIELD);

    }


    //getter and setters
    //*********************


    public int getTypeOfBackOfCards() {
        return typeOfBackOfCards;
    }

    public void setTypeOfBackOfCards(int typeOfBackOfCards) {
        this.typeOfBackOfCards = typeOfBackOfCards;
    }

    public void setNeedAnimation(boolean needAnimation) {
        this.needAnimation = needAnimation;
    }

    public int getMinXForPutCards() {
        return MIN_X_FOR_PUT_CARDS;
    }

    public int getMaxXForPutCards() {
        return MAX_X_FOR_PUT_CARDS;
    }

    public int getMinYForPutCards() {
        return MIN_Y_FOR_PUT_CARDS;
    }

    public int getMaxYForPutCards() {
        return MAX_Y_FOR_PUT_CARDS;
    }

    public int getWidthOfEachCardGamePanel() {
        return WIDTH_OF_EACH_CARD_GAME_PANEL;
    }

    public int getHeightOfEachCardGamePanel() {
        return HEIGHT_OF_EACH_CARD_GAME_PANEL;
    }

    public int getWidthOfGamePanel() {
        return WIDTH_OF_GAME_PANEL;
    }

    public int getHeightOfGamePanel() {
        return HEIGHT_OF_GAME_PANEL;
    }

    public int getWidthOfEachCardHandsCards() {
        return WIDTH_OF_EACH_CARD_HANDS_CARDS;
    }

    public int getHeightOfEachCardHandsCards() {
        return HEIGHT_OF_EACH_CARD_HANDS_CARDS;
    }

    public int getWidthOfHandsPanel() {
        return WIDTH_OF_HANDS_PANEL;
    }

    public int getHeightOfHandsPanel() {
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
