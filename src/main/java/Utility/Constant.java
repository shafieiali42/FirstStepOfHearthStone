package Utility;

import Gui.MyMainFrame;

import java.util.HashMap;

public class Constant {

    private static Constant constant=new Constant();
    public static Constant getInstance(){return constant;}

    private HashMap<String,String> heroImages =new HashMap<String, String>();
    private HashMap<String,String> heroPowerImages = new HashMap<String, String>();


    public  void defineHeroImagesHashMap(){
        heroImages.put("Mage","src/main/resources/Assets/HeroImages/Mage.png");
        heroImages.put("Rogue","src/main/resources/Assets/HeroImages/Rogue.png");
        heroImages.put("Warlock","src/main/resources/Assets/HeroImages/Warlock.png");
        heroImages.put("Hunter","src/main/resources/Assets/HeroImages/Hunter.png");
        heroImages.put("Priest","src/main/resources/Assets/HeroImages/Priest.png");
    }


    public void defineHeroPowerImagesHashMap(){
        heroPowerImages.put("Mage","src/main/resources/Assets/HeroPowerImages/MageHeroPower.png");
        heroPowerImages.put("Rogue","src/main/resources/Assets/HeroPowerImages/RogueHeroPower.png");
        heroPowerImages.put("Warlock","src/main/resources/Assets/HeroPowerImages/WarlockHeroPower.png");
        heroPowerImages.put("Hunter","src/main/resources/Assets/HeroPowerImages/HunterHeroPower.png");
        heroPowerImages.put("Priest","src/main/resources/Assets/HeroPowerImages/PriestHeroPower.png");
    }


    public HashMap<String, String> getHeroImages() {
        return heroImages;
    }
    public HashMap<String, String> getHeroPowerImages() {
        return heroPowerImages;
    }


    public static final int WIDTH_OF_CARD_PANEL=1155;
    public static final int HEIGHT_OF_CARD_PANEL=620;


    public static final int WIDTH_OF_CATEGORY_PANEL=1155;
    public static final int HEIGHT_OF_CATEGORY_PANEL=80;

    public static final int WIDTH_OF_CATEGORY_PANEL_DECK_PAGE = 1155;
    public static final int HEIGHT_OF_CATEGORY_PANEL_DECK_PAGE = 80;

    public static final int WIDTH_OF_DECK_PANEL = 250;
    public static final int HEIGHT_OF_DECK_PANEL = 1600;

    public static final int WIDTH_OF_DECK_VIEWER = 250;
    public static final int HEIGHT_OF_DECK_VIEWER = 800;

    public static final int WIDTH_OF_LITTLE_CARD = 225;
    public static final int HEIGHT_OF_LITTLE_CARD = 20;


    public static final int WIDTH_OF_MANA_PANEL = 1155;
    public static final int HEIGHT_OF_MANA_PANEL = 100;
    public static final int WIDTH_OF_MANA_BTN = 20;
    public static final int HEIGHT_OF_MANA_BTN = 8;
    public static final int WIDTH_OF_BACK_BTN_IN_MANA_PANEL = 20;
    public static final int HEIGHT_OF_BACK_BTN_IN_MANA_PANEL = 20;

    public static final int WIDTH_OF_END_TURN_PANEL = 200;
    public static final int HEIGHT_OF_END_TURN_PANEL = 810;
    public static final int WIDTH_OF_QIT_BTN = 100;
    public static final int HEIGHT_OF_QUIT_BTN = 50;

    public static final int X_COORDINATE_OF_FIRST_BTN = (MyMainFrame.getInstance().getWidth() - 3 * 200) / 4;
    public static final int Y_COORDINATE_OF_FIRST_BTN = (MyMainFrame.getInstance().getHeight() - 40 - 200) / 2;


    public static final int WIDTH_OF_LOG_PANEL=85;
    public static final int HEIGHT_OF_LOG_PANEL=810;

    public static final int WIDTH_OF_GAME_PANEL = 1115;
    public static final int HEIGHT_OF_GAME_PANEL = 600;
    public static final int WIDTH_OF_EACH_CARD_GAME_PANEL = 95;
    public static final int HEIGHT_OF_EACH_CARD_GAME_PANEL = 110;
    public static final int NUMBER_OF_CARDS_PER_ROW_GAME_PANEL = 7;
    public static final int MIN_X_FOR_PUT_CARDS = 50;
    public static final int MAX_X_FOR_PUT_CARDS = (NUMBER_OF_CARDS_PER_ROW_GAME_PANEL-1)*(WIDTH_OF_EACH_CARD_GAME_PANEL+50)+50;
    public static final int MIN_Y_FOR_PUT_CARDS = 395;
    public static final int MAX_Y_FOR_PUT_CARDS = MIN_Y_FOR_PUT_CARDS+HEIGHT_OF_EACH_CARD_GAME_PANEL;


    public static final int NUMBER_OF_CARDS_PER_ROW_HANDS_CARDS = 12;
    public static final int WIDTH_OF_EACH_CARD_HANDS_CARDS = 65;
    public static final int HEIGHT_OF_EACH_CARD_HANDS_CARDS = 80;
    public static final int WIDTH_OF_HANDS_PANEL = 1115;
    public static final int HEIGHT_OF_HANDS_PANEL = 85;

    public static final int WIDTH_OF_HERO_IMAGE = 150;
    public static final int HEIGHT_OF_HERO_IMAGE = 100;
    public static final int X_COORDINATE_OF_HERO_IMAGE = (WIDTH_OF_GAME_PANEL - WIDTH_OF_HERO_IMAGE) / 2;
    public static final int Y_COORDINATE_OF_HERO_IMAGE = HEIGHT_OF_HANDS_PANEL + HEIGHT_OF_GAME_PANEL - HEIGHT_OF_HERO_IMAGE;


    public static final int WIDTH_OF_HERO_POWER_IMAGE = 100;
    public static final int HEIGHT_OF_HERO_POWER_IMAGE = 100;
    public static final int X_COORDINATE_OF_HERO_POWER_IMAGE = X_COORDINATE_OF_HERO_IMAGE + WIDTH_OF_HERO_IMAGE;
    public static final int Y_COORDINATE_OF_HERO_POWER_IMAGE = HEIGHT_OF_HANDS_PANEL + HEIGHT_OF_GAME_PANEL - HEIGHT_OF_HERO_POWER_IMAGE;


    public static final int X_COORDINATE_OF_HEAL_FIELD=X_COORDINATE_OF_HERO_IMAGE+WIDTH_OF_HERO_IMAGE-35;
    public static final int Y_COORDINATE_OF_HEAL_FIELD=Y_COORDINATE_OF_HERO_IMAGE+HEIGHT_OF_HERO_IMAGE;

    public static final int WIDTH_OF_WEAPON_IMAGE = 80;
    public static final int HEIGHT_OF_WEAPON_IMAGE = 100;
    public static final int X_COORDINATE_OF_WEAPON = X_COORDINATE_OF_HERO_IMAGE - WIDTH_OF_WEAPON_IMAGE;
    public static final int Y_COORDINATE_OF_WEAPON = HEIGHT_OF_HANDS_PANEL + HEIGHT_OF_GAME_PANEL - HEIGHT_OF_WEAPON_IMAGE;


    public static final int WIDTH_OF_BTN_IN_SETTING = 220;
    public static final int HEIGHT_OF_BTN_IN_SETTING = 90;
    public static final int X_COORDINATE_OF_BUTTONS_IN_SETTING = (MyMainFrame.getInstance().getWidth()- WIDTH_OF_BTN_IN_SETTING)/2;
    public static final int Y_COORDINATE_OF_INCREASE_BTN = 200;
    public static final int Y_COORDINATE_OF_DECREASE_BTN = 300;
    public static final int Y_COORDINATE_OF_MUTE_BTN = 400;
    public static final int Y_COORDINATE_OF_BACK_BTN = 500;

    public static final int WIDTH_OF_BUTTON_PANEL_IN_SHOP = 1400;
    public static final int HEIGHT_OF_BUTTON_PANEL_IN_SHOP = 80;

    public static final int WIDTH_OF_BUY_SELL_PANEL = 400;
    public static final int HEIGHT_OF_BUY_SELL_PANEL = 730;

    public static final int WIDTH_OF_SHOP_CARD_PANEL=100;
    public static final int HEIGHT_OF_SHOP_CARD_PANEL=720;

    public static final int WIDE_OF_RANKED_PANEL =700;
    public static final int HEIGHT_OF_RANKED_PANEL=800;


}
