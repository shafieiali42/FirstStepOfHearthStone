package Models.HeroPower;

import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Heroes.Heroes;
import Models.Player.InGamePlayer;
import Visitors.PowerVisitor.VisitorOfPowers;

import java.util.ArrayList;

public class WarlockHeroPower extends HeroPower {


    public WarlockHeroPower(){
        this.setName("WarlockHeroPower");
        this.setMana(2);
    }

    @Override
    public void accept(VisitorOfPowers visitorOfPowers, InGamePlayer player, ArrayList<Minion> friendlyBattleGround,
                       ArrayList<Minion> enemyBattleGround, ArrayList<Cards> friendlyHandCards,
                       ArrayList<Cards> enemyHandsCards, ArrayList<Cards> friendlyDeckCards,
                       ArrayList<Cards> enemyDeckCards, Minion target, Heroes targetHero) {

        visitorOfPowers.visit(this,player,friendlyBattleGround,enemyBattleGround,friendlyHandCards,
                enemyHandsCards,friendlyDeckCards,enemyDeckCards,target,targetHero);

    }



}
