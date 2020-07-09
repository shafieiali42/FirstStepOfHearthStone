package Visitors.PowerVisitor;

import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.HeroPower.*;
import Models.Heroes.Heroes;
import Models.Player.InGamePlayer;
import Visitors.PowerVisitor.VisitorOfPowers;

import java.util.ArrayList;

public class SpecialPowerVisitor implements VisitorOfPowers {


    @Override
    public void visit(MageHeroPower mageHeroPower) {

    }

    @Override
    public void visit(RogueHeroPower rogueHeroPower, InGamePlayer player,
                      ArrayList<Minion> friendlyBattleGround,
                      ArrayList<Minion> enemyBattleGround,
                      ArrayList<Cards> friendlyHandCards,
                      ArrayList<Cards> enemyHandsCards,
                      ArrayList<Cards> friendlyDeckCards,
                      ArrayList<Cards> enemyDeckCards, Minion target, Heroes targetHero) {


    }



    @Override
    public void visit(WarlockHeroPower warlockHeroPower) {

    }

    @Override
    public void visit(HunterHeroPower hunterHeroPower) {

    }

    @Override
    public void visit(PriestHeroPower priestHeroPower) {

    }
}
