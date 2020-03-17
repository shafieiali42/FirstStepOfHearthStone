package Heroes;

import Cards.Cards;
import Cards.*;

import java.util.ArrayList;

public class Warlock extends  Heroes {
    private static ArrayList<Cards> specialCardsOfWarlock = new ArrayList<Cards>();
    private static Warlock instance = new Warlock();
    private Warlock(){
        this.name="Warlock";
        this.healthPower=35;
        this.descrtiption="You will never see anyone beyond him. He passes on his life and property and sacrifices something to win the war.";
        setSpecialCardsOfWarlock();
    }
    public static Warlock getInstance(){
        return instance;
    }
    public static void setSpecialCardsOfWarlock() {
       for (Cards card:Cards.getAllCards()){
           if (card.getClassOfCard().toLowerCase().trim().equals("warlock")){
               specialCardsOfWarlock.add(card);
           }
       }
    }

    public static ArrayList<Cards> getSpecialCardsOfWarlock() {
        return specialCardsOfWarlock;
    }

}
