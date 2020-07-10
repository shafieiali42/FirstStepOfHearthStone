package Models.Heroes;


import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.HeroPower.HunterHeroPower;
import Models.HeroPower.PriestHeroPower;
import Models.Player.InGamePlayer;
import Visitors.PowerVisitor.SpVisitor;

import java.util.ArrayList;

public class Priest extends Heroes {

    private static ArrayList<Cards> specialCardsOfPriest = new ArrayList<Cards>();

//    private static Priest instance = new Priest();
//    public static Priest getInstance(){
//        return instance;
//    }


    public Priest(){
        this.setName("Priest");
        this.setHealthPower(30);
        this.setDescription("");//TODO needs to be initialize
        this.setIsLock( true);
        this.setHeroPower(new PriestHeroPower());
        setSpecialCardsOfPriest();
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

    @Override
    public void accept(SpVisitor spVisitor, InGamePlayer player, ArrayList<Minion> friendlyBattleGround, ArrayList<Minion> enemyBattleGround, ArrayList<Cards> friendlyHandCards, ArrayList<Cards> enemyHandsCards, ArrayList<Cards> friendlyDeckCards, ArrayList<Cards> enemyDeckCards, Minion target, Heroes targetHero, Minion summoned) {
        spVisitor.visit(this,player,friendlyBattleGround,enemyBattleGround,friendlyHandCards,
                enemyHandsCards,friendlyDeckCards,enemyDeckCards,target,targetHero,summoned);
    }
}
