package Models.Cards.GameCards.MinionCards.UnoptionalMinions;


import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Heroes.Heroes;
import Visitors.CardVisitors.Visitor;

import java.util.ArrayList;

public class TombWarden extends Minion {



    @Override
    public TombWarden  copy() {
        System.out.println("Copy of TombWarden:))");
        TombWarden copy = new TombWarden();
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


    public TombWarden(){
        setIsTaunt(false);//todo needs to be True
        setCanBeAttacked(true);
        setIsActive(true);

    }


    @Override
    public void accept(Visitor visitor, ArrayList<Minion> battleGround, ArrayList<Cards> handsCards,
                       ArrayList<Cards>deckCards, Minion target, Heroes targetHero, Minion summonedMinion,
                       Cards playingCard,String alliance){
        visitor.visit(this,battleGround);
    }


}
