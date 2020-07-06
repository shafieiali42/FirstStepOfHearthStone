package Models.Cards.GameCards.SpellCards;

import Interfaces.Visitor;
import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Cards.CardClasses.Spell;

import java.util.ArrayList;

public class SwarmOfLocusts extends Spell {


    @Override
    public void accept(Visitor visitor, ArrayList<Minion> battleGround, ArrayList<Cards> handsCards, Minion target){
        visitor.visit(this,battleGround);
    }
}
