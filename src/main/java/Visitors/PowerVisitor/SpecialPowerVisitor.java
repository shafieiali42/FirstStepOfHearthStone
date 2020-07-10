package Visitors.PowerVisitor;

import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Cards.CardClasses.Spell;
import Models.Cards.CardClasses.SpellAbility;
import Models.HeroPower.*;
import Models.Heroes.*;
import Models.Player.InGamePlayer;
import Visitors.PowerVisitor.VisitorOfPowers;

import java.util.ArrayList;

public class SpecialPowerVisitor implements SpVisitor {


    @Override
    public void visit(Mage mage, InGamePlayer player, ArrayList<Minion> friendlyBattleGround, ArrayList<Minion> enemyBattleGround, ArrayList<Cards> friendlyHandCards, ArrayList<Cards> enemyHandsCards, ArrayList<Cards> friendlyDeckCards, ArrayList<Cards> enemyDeckCards, Minion target, Heroes targetHero, Minion summoned) {
        for (Cards card:friendlyDeckCards){
            if (card.getType().equalsIgnoreCase("Spell")){
                card.setManaCost(card.getMoneyCost()-2);
            }
        }
        for (Cards card:friendlyHandCards){
            if (card.getType().equalsIgnoreCase("Spell")){
                card.setManaCost(card.getMoneyCost()-2);
            }
        }
    }

    @Override
    public void visit(Rogue rogue, InGamePlayer player, ArrayList<Minion> friendlyBattleGround, ArrayList<Minion> enemyBattleGround, ArrayList<Cards> friendlyHandCards, ArrayList<Cards> enemyHandsCards, ArrayList<Cards> friendlyDeckCards, ArrayList<Cards> enemyDeckCards, Minion target, Heroes targetHero, Minion summoned) {

        for (Cards card:friendlyDeckCards){
            if ( (!card.getClassOfCard().equalsIgnoreCase(player.getHero().getName())) &&
                    (!card.getClassOfCard().equalsIgnoreCase("Neutral"))){
                card.setManaCost(card.getMoneyCost()-2);
            }
        }

        for (Cards card:friendlyHandCards){
            if ( (!card.getClassOfCard().equalsIgnoreCase(player.getHero().getName())) &&
                    (!card.getClassOfCard().equalsIgnoreCase("Neutral"))){
                card.setManaCost(card.getMoneyCost()-2);
            }
        }



    }


    @Override
    public void visit(Warlock warlock, InGamePlayer player, ArrayList<Minion> friendlyBattleGround, ArrayList<Minion> enemyBattleGround, ArrayList<Cards> friendlyHandCards, ArrayList<Cards> enemyHandsCards, ArrayList<Cards> friendlyDeckCards, ArrayList<Cards> enemyDeckCards, Minion target, Heroes targetHero, Minion summoned) {
        player.getHero().setHealthPower(35);
    }


    @Override
    public void visit(Hunter hunter, InGamePlayer player, ArrayList<Minion> friendlyBattleGround, ArrayList<Minion> enemyBattleGround, ArrayList<Cards> friendlyHandCards, ArrayList<Cards> enemyHandsCards, ArrayList<Cards> friendlyDeckCards, ArrayList<Cards> enemyDeckCards, Minion target, Heroes targetHero, Minion summoned) {

        for (Cards card:friendlyDeckCards){
           if (card.getType().equalsIgnoreCase("Minion")){
               Minion minion=(Minion)card;
               minion.setRush(true);
           }
        }

        for (Cards card:friendlyHandCards){
            if (card.getType().equalsIgnoreCase("Minion")){
                Minion minion=(Minion)card;
                minion.setRush(true);
            }
        }

    }

    @Override
    public void visit(Priest priest, InGamePlayer player, ArrayList<Minion> friendlyBattleGround, ArrayList<Minion> enemyBattleGround, ArrayList<Cards> friendlyHandCards, ArrayList<Cards> enemyHandsCards, ArrayList<Cards> friendlyDeckCards, ArrayList<Cards> enemyDeckCards, Minion target, Heroes targetHero, Minion summoned) {


        for (Cards card:friendlyDeckCards){
            if (card.getType().equalsIgnoreCase("Spell")){
                Spell spell=(Spell) card;
                if (spell.getAbilities().contains(SpellAbility.RESTORE)){
                                
                }
            }
        }

        for (Cards card:friendlyHandCards){
            if (card.getType().equalsIgnoreCase("Spell")){
                Spell spell=(Spell) card;
                if (spell.getAbilities().contains(SpellAbility.RESTORE)){

                }
            }
        }

    }


}
