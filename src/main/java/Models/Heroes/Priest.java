package Models.Heroes;


import Models.Cards.Cards;
import java.util.ArrayList;

public class Priest extends Heroes {
    private static ArrayList<Cards> specialCardsOfPriest = new ArrayList<Cards>();
    private static Priest instance = new Priest();
    private Priest(){
        this.name="Priest";
        this.healthPower=30;
        this.descrtiption="";//TODO needs to be initialize
        this.isLock = true;
        setSpecialCardsOfPriest();
    }
    public static Priest getInstance(){
        return instance;
    }


    public static void setSpecialCardsOfPriest() {
        for (Cards card:Cards.getAllCards()){
            boolean isDuplicated=false;
            for (Cards cardInSpecialCardsOfPriest:specialCardsOfPriest){
                if (card.getName().equals(cardInSpecialCardsOfPriest.getName())){
                    isDuplicated=true;
                }
            }
            if (!isDuplicated){
                if (card.getClassOfCard().toLowerCase().trim().equals("priest")){
                    specialCardsOfPriest.add(card);
                }
            }

        }
    }

    public static ArrayList<Cards> getSpecialCardsOfPriest() {
        return specialCardsOfPriest;
    }

}
