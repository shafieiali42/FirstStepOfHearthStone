package Heroes;

import Cards.Cards;

import java.util.ArrayList;

public class Rogue extends Heroes {
    private static ArrayList<Cards> specialCardsOfRogue = new ArrayList<Cards>();
    private static Rogue instance = new Rogue();
    private Rogue(){
        this.name="Rogue";
        this.healthPower=30;
        this.descrtiption="He is a thief and most of his abilities are in stealing from the enemy!";
        setSpecialCardsOfRogue();
    }
    public static Rogue getInstance(){
        return instance;
    }


    public static void setSpecialCardsOfRogue() {
        for (Cards card:Cards.getAllCards()){
            if (card.getClassOfCard().toLowerCase().trim().equals("rogue")){
                specialCardsOfRogue.add(card);
            }
        }
    }

    public static ArrayList<Cards> getSpecialCardsOfRogue() {
        return specialCardsOfRogue;
    }

}
