package Utility;

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


    public static final int WIDTH_OF_CARD_PANEL=1155;      //TODO NEEDS TO CHANGE
    public static final int HEIGHT_OF_CARD_PANEL=620;     //TODO NEEDS TO CHANGE
    public static final int NUM_OF_CARD_IN_EVERY_ROW = 6; //TODO NEEDS TO CHANGE





}
