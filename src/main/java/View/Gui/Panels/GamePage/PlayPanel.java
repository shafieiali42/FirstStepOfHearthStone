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


    private Properties properties;

    {
        try {
            properties = ConfigLoader.getInstance().readProperties("src/main/resources/ConfigFiles/graphicConfigFiles/Panels/GamePage/Play.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int HEIGHT_OF_HANDS_PANEL=Integer.parseInt(properties.getProperty("HEIGHT_OF_HANDS_PANEL"));
    int WIDTH_OF_GAME_PANEL=Integer.parseInt(properties.getProperty("WIDTH_OF_GAME_PANEL"));
    int HEIGHT_OF_GAME_PANEL=Integer.parseInt(properties.getProperty("HEIGHT_OF_GAME_PANEL"));
    int NUMBER_OF_CARDS_PER_ROW_HANDS_CARDS=Integer.parseInt(properties.getProperty("NUMBER_OF_CARDS_PER_ROW_HANDS_CARDS"));
    int NUMBER_OF_CARDS_PER_ROW_GAME_PANEL=Integer.parseInt(properties.getProperty("NUMBER_OF_CARDS_PER_ROW_GAME_PANEL"));
    int X_COORDINATE_OF_HERO_IMAGE=Integer.parseInt(properties.getProperty("X_COORDINATE_OF_HERO_IMAGE"));
    int Y_COORDINATE_OF_HERO_IMAGE=Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_HERO_IMAGE"));
    int WIDTH_OF_HERO_IMAGE=Integer.parseInt(properties.getProperty("WIDTH_OF_HERO_IMAGE"));
    int HEIGHT_OF_HERO_IMAGE=Integer.parseInt(properties.getProperty("HEIGHT_OF_HERO_IMAGE"));
    int X_COORDINATE_OF_HERO_POWER_IMAGE=Integer.parseInt(properties.getProperty("X_COORDINATE_OF_HERO_POWER_IMAGE"));
    int Y_COORDINATE_OF_HERO_POWER_IMAGE=Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_HERO_POWER_IMAGE"));
    int WIDTH_OF_HERO_POWER_IMAGE=Integer.parseInt(properties.getProperty("WIDTH_OF_HERO_POWER_IMAGE"));
    int HEIGHT_OF_HERO_POWER_IMAGE=Integer.parseInt(properties.getProperty("HEIGHT_OF_HERO_POWER_IMAGE"));
    int WIDTH_OF_WEAPON_IMAGE=Integer.parseInt(properties.getProperty("WIDTH_OF_WEAPON_IMAGE"));
    int HEIGHT_OF_WEAPON_IMAGE=Integer.parseInt(properties.getProperty("HEIGHT_OF_WEAPON_IMAGE"));
    int X_COORDINATE_OF_WEAPON=Integer.parseInt(properties.getProperty("X_COORDINATE_OF_WEAPON"));
    int Y_COORDINATE_OF_WEAPON=Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_WEAPON"));
    int X_COORDINATE_OF_HEAL_FIELD=Integer.parseInt(properties.getProperty("X_COORDINATE_OF_HEAL_FIELD"));
    int Y_COORDINATE_OF_HEAL_FIELD=Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_HEAL_FIELD"));
    int MIN_X_FOR_PUT_CARDS=Integer.parseInt(properties.getProperty("MIN_X_FOR_PUT_CARDS"));
    int MAX_X_FOR_PUT_CARDS=Integer.parseInt(properties.getProperty("MAX_X_FOR_PUT_CARDS"));
    int MIN_Y_FOR_PUT_CARDS=Integer.parseInt(properties.getProperty("MIN_Y_FOR_PUT_CARDS"));
    int MAX_Y_FOR_PUT_CARDS=Integer.parseInt(properties.getProperty("MAX_Y_FOR_PUT_CARDS"));
    int WIDTH_OF_EACH_CARD_GAME_PANEL=Integer.parseInt(properties.getProperty("WIDTH_OF_EACH_CARD_GAME_PANEL"));
    int HEIGHT_OF_EACH_CARD_GAME_PANEL=Integer.parseInt(properties.getProperty("HEIGHT_OF_EACH_CARD_GAME_PANEL"));
    int WIDTH_OF_EACH_CARD_HANDS_CARDS=Integer.parseInt(properties.getProperty("WIDTH_OF_EACH_CARD_HANDS_CARDS"));
    int HEIGHT_OF_EACH_CARD_HANDS_CARDS=Integer.parseInt(properties.getProperty("HEIGHT_OF_EACH_CARD_HANDS_CARDS"));
    int WIDTH_OF_HANDS_PANEL=Integer.parseInt(properties.getProperty("WIDTH_OF_HANDS_PANEL"));

    int X_COORDINATE_OF_ENEMY_HERO_IMAGE=Integer.parseInt(properties.getProperty("X_COORDINATE_OF_ENEMY_HERO_IMAGE"));
    int Y_COORDINATE_OF_ENEMY_HERO_IMAGE=Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_ENEMY_HERO_IMAGE"));
    int X_COORDINATE_OF_ENEMY_HERO_POWER_IMAGE=Integer.parseInt(properties.getProperty("X_COORDINATE_OF_ENEMY_HERO_POWER_IMAGE"));
    int Y_COORDINATE_OF_ENEMY_HERO_POWER_IMAGE=Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_ENEMY_HERO_POWER_IMAGE"));
    int X_COORDINATE_OF__ENEMY_WEAPON=Integer.parseInt(properties.getProperty("X_COORDINATE_OF__ENEMY_WEAPON"));
    int Y_COORDINATE_OF_ENEMY_WEAPON=Integer.parseInt(properties.getProperty("Y_COORDINATE_OF_ENEMY_WEAPON"));



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

    private static final int WIDTH_OF_PLAY_PANEL = 1115;
    private static final int HEIGHT_OF_PLAY_PANEL = 770;


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
        scaleTransform.rotate(Math.PI , w / 2, h / 2);
        AffineTransformOp scaleOp = new AffineTransformOp(
                scaleTransform, AffineTransformOp.TYPE_BILINEAR);
        enemyHeroImage = scaleOp.filter(enemyHeroImage, null);

        enemyHeroPowerImage = ImageIO.read(
                new File(Constant.getInstance().getHeroPowerImages().get(Administer.getNameOfEnemyHeroOfGameState())));
        int ww = enemyHeroPowerImage.getWidth();
        int hh = enemyHeroPowerImage.getHeight();
        AffineTransform scaleTransform2= new AffineTransform();
// last-in-first-applied: rotate, scale
        scaleTransform2.scale(1, 1);
        scaleTransform2.rotate(Math.PI , ww / 2, hh / 2);
        AffineTransformOp scaleOp2 = new AffineTransformOp(
                scaleTransform2, AffineTransformOp.TYPE_BILINEAR);
        enemyHeroPowerImage = scaleOp2.filter(enemyHeroPowerImage, null);

    }

    public int getTypeOfBackOfCards() {
        return typeOfBackOfCards;
    }

    public void setTypeOfBackOfCards(int typeOfBackOfCards) {
        this.typeOfBackOfCards = typeOfBackOfCards;
    }

    int originX = 500;
    int originY = 0;
    int destinationX = 500;
    int destinationY = 800;

    public int getOriginX() {
        return originX;
    }

    public void setOriginX(int originX) {
        this.originX = originX;
    }

    public int getOriginY() {
        return originY;
    }

    public void setOriginY(int originY) {
        this.originY = originY;
    }

    public int getDestinationX() {
        return destinationX;
    }

    public void setDestinationX(int destinationX) {
        this.destinationX = destinationX;
    }

    public int getDestinationY() {
        return destinationY;
    }

    public void setDestinationY(int destinationY) {
        this.destinationY = destinationY;
    }

    //    public void animation(Graphics2D graphics2D){
//         long lastUpdate = 0;
//        int frame = 0;
//        final List<MovablePainter> movablePainter = new ArrayList<>();
//        BufferedImage back = null;
//        try {
//            back = ImageIO.read(new File("src/main/resources/BackOfCards/BackOfCards1.png"));
//            back=back.getSubimage(0,0,100,100);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        movablePainter.add(new RotatedPic(originX,originY,destinationX,destinationY,
//                new SimplePainter(back)));
//        super.paintComponent(graphics2D);
//        if (lastUpdate==0)
//            lastUpdate=System.nanoTime();
//        long temp;
//        while ((temp = System.nanoTime()-lastUpdate)>(1e9/60)){
//            lastUpdate+=temp;
//            frame++;
//        }
////        constantPainter.forEach(p -> p.paint(g2d,100,100,frame));
//        int finalFrame = frame;
//        movablePainter.forEach(p -> p.paint(graphics2D, finalFrame));
//    }
    boolean needAnimation = false;


    public void setNeedAnimation(boolean needAnimation) {
        this.needAnimation = needAnimation;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        BufferedImage image= null;
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
//            animation(graphics2D);
            AnimationOfRotation animationOfRotation = new AnimationOfRotation();
//            new Thread(()->test.animation(graphics2D,300, 100 ,200 ,600)).start();
//            test.animation(graphics2D,200, 100 ,800 ,900);

//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

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
                Administer.showEnemyBattleGroundCardsInPlay(this,NUMBER_OF_CARDS_PER_ROW_GAME_PANEL);
                Administer.showEnemyHandsCardInPlay(this, NUMBER_OF_CARDS_PER_ROW_HANDS_CARDS, typeOfBackOfCards,Administer.getGameMode());
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


    public  int getMinXForPutCards() {
        return MIN_X_FOR_PUT_CARDS;
    }

    public  int getMaxXForPutCards() {
        return MAX_X_FOR_PUT_CARDS;
    }

    public  int getMinYForPutCards() {
        return MIN_Y_FOR_PUT_CARDS;
    }

    public  int getMaxYForPutCards() {
        return MAX_Y_FOR_PUT_CARDS;
    }

    public  int getWidthOfEachCardGamePanel() {
        return WIDTH_OF_EACH_CARD_GAME_PANEL;
    }

    public  int getHeightOfEachCardGamePanel() {
        return HEIGHT_OF_EACH_CARD_GAME_PANEL;
    }

    public  int getWidthOfGamePanel() {
        return WIDTH_OF_GAME_PANEL;
    }

    public  int getHeightOfGamePanel() {
        return HEIGHT_OF_GAME_PANEL;
    }

    public  int getWidthOfEachCardHandsCards() {
        return WIDTH_OF_EACH_CARD_HANDS_CARDS;
    }

    public  int getHeightOfEachCardHandsCards() {
        return HEIGHT_OF_EACH_CARD_HANDS_CARDS;
    }

    public  int getWidthOfHandsPanel() {
        return WIDTH_OF_HANDS_PANEL;
    }

    public  int getHeightOfHandsPanel() {
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
