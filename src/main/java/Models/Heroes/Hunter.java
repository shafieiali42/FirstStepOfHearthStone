package Models.Heroes;


import Models.Cards.CardClasses.Cards;
import java.util.ArrayList;

public class Hunter extends Heroes {
    private static ArrayList<Cards> specialCardsOfHunter = new ArrayList<Cards>();
    private static Hunter instance = new Hunter();
    private Hunter(){
        this.name="Hunter";
        this.healthPower=30;
        this.descrtiption="";//TODO needs to be initialize
        this.isLock = true;
        setSpecialCardsOfHunter();
    }
    public static Hunter getInstance(){
        return instance;
    }


    public static void setSpecialCardsOfHunter() {
        for (Cards card:Cards.getAllCards()){
            boolean isDuplicated=false;
            for (Cards cardInSpecialCardsOfHunter:specialCardsOfHunter){
                if (card.getName().equals(cardInSpecialCardsOfHunter.getName())){
                    isDuplicated=true;
                }
            }
            if (!isDuplicated){
                if (card.getClassOfCard().toLowerCase().trim().equals("hunter")){
                    specialCardsOfHunter.add(card);
                }
            }

        }
    }

    public static ArrayList<Cards> getSpecialCardsOfHunter() {
        return specialCardsOfHunter;
    }

}
