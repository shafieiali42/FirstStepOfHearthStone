package Models.Cards.GameCards.MinionCards;

import Interfaces.Visitor;
import Models.Cards.CardClasses.Minion;

public class Sathrovarr extends Minion {



    @Override
    public Sathrovarr  copy() {
        System.out.println("Copy of Sathrovarr:))");
        Sathrovarr copy = new Sathrovarr();
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


//    @Override
//    public void accept(Visitor visitor){ visitor.visit(this);}

}

