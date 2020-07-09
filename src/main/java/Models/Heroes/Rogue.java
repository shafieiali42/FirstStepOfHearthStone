package Models.Heroes;

import Models.Cards.CardClasses.Cards;
import Models.HeroPower.HunterHeroPower;
import Models.HeroPower.RogueHeroPower;

import java.util.ArrayList;

public class Rogue extends Heroes {
    private static ArrayList<Cards> specialCardsOfRogue = new ArrayList<Cards>();

//    private static Rogue instance = new Rogue();
//    public static Rogue getInstance(){
//          return instance;
//}

    public Rogue() {
        this.setName("Rogue");
        this.setHealthPower(30);
        this.setDescription("He is a thief and most of his abilities are in stealing from the enemy!");
        this.setIsLock(false);
        this.setHeroPower(new RogueHeroPower());
        setSpecialCardsOfRogue();
    }


    public static void setSpecialCardsOfRogue() {
        for (Cards card : Cards.getAllCards()) {
            boolean isDuplicated = false;
            for (Cards cardInSpecialCardsOfRogue : specialCardsOfRogue) {
                if (card.getName().equals(cardInSpecialCardsOfRogue.getName())) {
                    isDuplicated = true;
                }
            }
            if (!isDuplicated) {
                if (card.getClassOfCard().toLowerCase().trim().equals("rogue")) {
                    specialCardsOfRogue.add(card);
                }
            }

        }
    }

    public static ArrayList<Cards> getSpecialCardsOfRogue() {
        return specialCardsOfRogue;
    }

}
