package Models.HeroPower;


import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Heroes.Heroes;
import Models.Player.InGamePlayer;
import Visitors.PowerVisitor.HeroPowerVisitor.HeroPowerVisitable;
import Visitors.PowerVisitor.HeroPowerVisitor.VisitorOfPowers;


import java.util.ArrayList;

public class HeroPower implements HeroPowerVisitable {


    private int mana;
    private String name;
    private boolean needsTarget;
    private int numberOfPermitUse = 1;




    @Override
    public void accept(VisitorOfPowers visitorOfPowers, InGamePlayer player,
                       ArrayList<Minion> friendlyBattleGround, ArrayList<Minion> enemyBattleGround,
                       ArrayList<Cards> friendlyHandCards, ArrayList<Cards> enemyHandsCards,
                       ArrayList<Cards> friendlyDeckCards, ArrayList<Cards> enemyDeckCards,
                       Minion target, Heroes targetHero, Minion summoned) {}





    //getter and setters
    //********************

    public int getNumberOfPermitUse() {
        return numberOfPermitUse;
    }
    public void setNumberOfPermitUse(int numberOfPermitUse) {
        this.numberOfPermitUse = numberOfPermitUse;
    }
    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
