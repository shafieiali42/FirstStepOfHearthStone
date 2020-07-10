package Models.Heroes;

import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.HeroPower.HunterHeroPower;
import Models.HeroPower.MageHeroPower;
import Models.Player.InGamePlayer;
import Visitors.PowerVisitor.SpVisitor;

import java.util.ArrayList;

public class Mage extends Heroes {
    private static ArrayList<Cards> specialCardsOfMage = new ArrayList<Cards>();



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


    @Override
    public void accept(SpVisitor spVisitor, InGamePlayer player, ArrayList<Minion> friendlyBattleGround, ArrayList<Minion> enemyBattleGround, ArrayList<Cards> friendlyHandCards, ArrayList<Cards> enemyHandsCards, ArrayList<Cards> friendlyDeckCards, ArrayList<Cards> enemyDeckCards, Minion target, Heroes targetHero, Minion summoned) {
        spVisitor.visit(this,player,friendlyBattleGround,enemyBattleGround,friendlyHandCards,
                enemyHandsCards,friendlyDeckCards,enemyDeckCards,target,targetHero,summoned);
    }
}
