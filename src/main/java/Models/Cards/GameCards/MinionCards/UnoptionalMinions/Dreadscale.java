package Models.Cards.GameCards.MinionCards.UnoptionalMinions;


import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Heroes.Heroes;
import Visitors.CardVisitors.Visitor;

import java.util.ArrayList;

public class Dreadscale extends Minion {

    public Dreadscale() {
        setIsTaunt(false);
        setCanBeAttacked(true);
        setIsActive(true);
    }

    @Override
    public Dreadscale  copy() {
//        System.out.println("Copy of Dreadscale:))");
        Dreadscale copy = new Dreadscale();
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
                       ArrayList<Cards>deckCards, Minion target, Heroes targetHero, Minion summonedMinion,String alliance){
        visitor.visit(this);
    }

}
