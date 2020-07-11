package Models.HeroPower;

import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Heroes.Heroes;
import Models.Player.InGamePlayer;
import Visitors.PowerVisitor.HeroPowerVisitor.VisitorOfPowers;


import java.util.ArrayList;

public class HunterHeroPower extends HeroPower {

    public HunterHeroPower(){
        this.setName("HunterHeroPower");
        this.setMana(2);
    }


    @Override
    public void accept(VisitorOfPowers visitorOfPowers, InGamePlayer player, ArrayList<Minion> friendlyBattleGround,
                       ArrayList<Minion> enemyBattleGround, ArrayList<Cards> friendlyHandCards,
                       ArrayList<Cards> enemyHandsCards, ArrayList<Cards> friendlyDeckCards,
                       ArrayList<Cards> enemyDeckCards, Minion target, Heroes targetHero, Minion summoned) {

        visitorOfPowers.visit(this,player,friendlyBattleGround,enemyBattleGround,friendlyHandCards,
                enemyHandsCards,friendlyDeckCards,enemyDeckCards,target,targetHero,summoned);


    }



}
