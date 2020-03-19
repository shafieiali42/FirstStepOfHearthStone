package Heroes;

import Cards.Cards;

import java.util.ArrayList;

public class Mage extends Heroes {
    private static ArrayList<Cards> specialCardsOfMage = new ArrayList<Cards>();
    private static Mage instance = new Mage();
    private Mage(){
        this.name="Mage";
        this.healthPower=30;
        this.descrtiption="She is a skilled wizard who has special skills in using spells.";
        setSpecialCardsOfMage();
    }
    public static Mage getInstance(){
        return instance;
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
                if (card.getClassOfCard().toLowerCase().trim().equals("mage")){
                    specialCardsOfMage.add(card);
                }
            }

        }
    }

    public static ArrayList<Cards> getSpecialCardsOfMage() {
        return specialCardsOfMage;
    }

}
