package Models.Cards.GameCards.MinionCards.UnoptionalMinions;

import Models.Heroes.Heroes;
import Visitors.CardVisitors.Visitor;
import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;

import java.util.ArrayList;

public class SecurityRover extends Minion {



    @Override
    public SecurityRover  copy() {
        System.out.println("Copy of SecurityRover:))");
        SecurityRover copy = new SecurityRover();
        copy.setName(this.getName());
        copy.setManaCost(this.getManaCost());
        copy.setRarity(this.getRarity());
        copy.setDescription(this.getDescription());
        copy.setClassOfCard(this.getClassOfCard());
        copy.setType(this.getType());
        copy.setRarity(this.getRarity());
        copy.setIsPlayed(this.isPlayed());
        copy.setFirstAttackPower(this.getFirstAttackPower());
        copy.setFirstHealthPower(this.getFirstHealthPower());
        copy.setAttackPower(this.getAttackPower());
        copy.setHealthPower(this.getHealthPower());
        copy.setIsActive(this.getIsActive());
        copy.setCanBeAttacked(this.getCanBeAttacked());
        copy.setIsTaunt(this.getIsTaunt());
        copy.setHasAttackInThisTurn(this.getHasAttackInThisTurn());
        return copy;
    }


    @Override
    public void accept(Visitor visitor, ArrayList<Minion> battleGround, ArrayList<Cards> handsCards,
                       ArrayList<Cards>deckCards, Minion target, Heroes targetHero, Minion summonedMinion,
                       Cards playingCard,String alliance){
        visitor.visit(this);
    }


}
