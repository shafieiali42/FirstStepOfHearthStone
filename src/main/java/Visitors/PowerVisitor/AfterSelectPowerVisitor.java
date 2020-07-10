package Visitors.PowerVisitor;

import Controller.Administer;
import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.HeroPower.*;
import Models.Heroes.Heroes;
import Models.Player.InGamePlayer;

import java.util.ArrayList;

public class AfterSelectPowerVisitor implements VisitorOfPowers {


    @Override
    public void visit(MageHeroPower mageHeroPower, InGamePlayer player, ArrayList<Minion> friendlyBattleGround,
                      ArrayList<Minion> enemyBattleGround, ArrayList<Cards> friendlyHandCards,
                      ArrayList<Cards> enemyHandsCards, ArrayList<Cards> friendlyDeckCards,
                      ArrayList<Cards> enemyDeckCards, Minion target, Heroes targetHero) {


        if (target !=null){
            target.setHealthPower(target.getHealthPower()-2);
        }else if (targetHero!=null){
            targetHero.setHealthPower(targetHero.getHealthPower()-2);
        }

        Administer.removeDeadCharacters();



    }

    @Override
    public void visit(RogueHeroPower rogueHeroPower, InGamePlayer player, ArrayList<Minion> friendlyBattleGround, ArrayList<Minion> enemyBattleGround, ArrayList<Cards> friendlyHandCards, ArrayList<Cards> enemyHandsCards, ArrayList<Cards> friendlyDeckCards, ArrayList<Cards> enemyDeckCards, Minion target, Heroes targetHero) {

    }

    @Override
    public void visit(WarlockHeroPower warlockHeroPower, InGamePlayer player, ArrayList<Minion> friendlyBattleGround, ArrayList<Minion> enemyBattleGround, ArrayList<Cards> friendlyHandCards, ArrayList<Cards> enemyHandsCards, ArrayList<Cards> friendlyDeckCards, ArrayList<Cards> enemyDeckCards, Minion target, Heroes targetHero) {

    }

    @Override
    public void visit(HunterHeroPower hunterHeroPower, InGamePlayer player,
                      ArrayList<Minion> friendlyBattleGround,
                      ArrayList<Minion> enemyBattleGround,
                      ArrayList<Cards> friendlyHandCards,
                      ArrayList<Cards> enemyHandsCards,
                      ArrayList<Cards> friendlyDeckCards,
                      ArrayList<Cards> enemyDeckCards,
                      Minion target, Heroes targetHero,Minion summoned) {




    }

    @Override
    public void visit(PriestHeroPower priestHeroPower, InGamePlayer player, ArrayList<Minion> friendlyBattleGround,
                      ArrayList<Minion> enemyBattleGround, ArrayList<Cards> friendlyHandCards,
                      ArrayList<Cards> enemyHandsCards, ArrayList<Cards> friendlyDeckCards,
                      ArrayList<Cards> enemyDeckCards, Minion target, Heroes targetHero) {


            if (target!=null){
                target.setHealthPower(Math.min(target.getHealthPower()+4, target.getFirstHealthPower()));
            }else if (targetHero!=null){
                targetHero.setHealthPower(Math.min(targetHero.getHealthPower()+4, targetHero.getFirstHealthPower()));
            }



    }



}
