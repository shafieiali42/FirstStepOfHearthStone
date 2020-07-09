package Models.Heroes;

import Models.Cards.CardClasses.Cards;
import Models.HeroPower.HunterHeroPower;
import Models.HeroPower.MageHeroPower;

import java.util.ArrayList;

public class Mage extends Heroes {
    private static ArrayList<Cards> specialCardsOfMage = new ArrayList<Cards>();


    @Override
    public void print() {
//        System.out.println("Mage");
    }

    public Mage(){
        this.setName("Mage");
        this.setHealthPower(30);
        this.setDescription("She is a skilled wizard who has special skills in using spells.");
        this.setIsLock(false);
        this.setHeroPower(new MageHeroPower());
        setSpecialCardsOfMage();
    }


    public static void setSpecialCardsOfMage() {
        for (Cards card:Cards.getAllCards()){
            boolean isDuplicated=false;
            for (Cards cardInSpecialCardsOfMage:specialCardsOfMage){
                if (card.getName().equals(cardInSpecialCardsOfMage.getName())){
                    isDuplicated=true;
                }
            }
            if (!isDuplicated){
                if (card.getClassOfCard().equalsIgnoreCase("Mage")){
                    specialCardsOfMage.add(card);
                }
            }

        }
    }

    public static ArrayList<Cards> getSpecialCardsOfMage() {
        return specialCardsOfMage;
    }





}
