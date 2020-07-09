package Models.Heroes;

import Models.Cards.CardClasses.Cards;
import Models.HeroPower.HunterHeroPower;
import Models.HeroPower.WarlockHeroPower;

import java.util.ArrayList;

public class Warlock extends  Heroes {
    private static ArrayList<Cards> specialCardsOfWarlock = new ArrayList<Cards>();

//    private static Warlock instance = new Warlock();
//    public static Warlock getInstance(){
//        return instance;
//    }

    public Warlock(){
        this.setName("Warlock");
        this.setHealthPower(35);
        this.setDescription("You will never see anyone beyond him. " +
                "He passes on his life and property and sacrifices something to win the war.");
        this.setIsLock(false);
        this.setHeroPower(new WarlockHeroPower());
        setSpecialCardsOfWarlock();
    }

    public static void setSpecialCardsOfWarlock() {
        for (Cards card:Cards.getAllCards()){
            boolean isDuplicated=false;
            for (Cards cardInSpecialCardsOfWarlock:specialCardsOfWarlock){
                if (card.getName().equals(cardInSpecialCardsOfWarlock.getName())){
                    isDuplicated=true;
                }
            }
            if (!isDuplicated){
                if (card.getClassOfCard().toLowerCase().trim().equals("warlock")){
                    specialCardsOfWarlock.add(card);
                }
            }

        }
    }

    public static ArrayList<Cards> getSpecialCardsOfWarlock() {
        return specialCardsOfWarlock;
    }

}
