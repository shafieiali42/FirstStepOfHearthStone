package Models.Cards.GameCards.MinionCards;

import Interfaces.Visitor;
import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;

import java.util.ArrayList;

public class Locusts extends Minion {




    @Override
    public Locusts  copy() {
        System.out.println("Copy of Locusts:))");
        Locusts copy = new Locusts();
        copy.setName(this.getName());
        copy.setManaCost(this.getManaCost());
        copy.setRarity(this.getRarity());
        copy.setDescription(this.getDescription());
        copy.setClassOfCard(this.getClassOfCard());
        copy.setType(this.getType());
        copy.setRarity(this.getRarity());
        copy.setIsPlayed(this.isPlayed());
        copy.setAttackPower(this.getAttackPower());
        copy.setHealthPower(this.getHealthPower());
        copy.setIsActive(this.getIsActive());
        copy.setCanBeAttacked(this.getCanBeAttacked());
        copy.setIsTaunt(this.getIsTaunt());
        copy.setHasAttackInThisTurn(this.getHasAttackInThisTurn());
        return copy;
    }

    @Override
    public void accept(Visitor visitor, ArrayList<Minion> battleGround, ArrayList<Cards> handsCards, Minion target,Minion summonedMinion){
        visitor.visit(this,battleGround);
    }

}
