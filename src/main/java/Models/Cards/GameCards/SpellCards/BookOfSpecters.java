package Models.Cards.GameCards.SpellCards;

import Interfaces.Visitor;
import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Cards.CardClasses.Spell;
import Models.Cards.GameCards.MinionCards.CurioCollector;

import java.util.ArrayList;


public class BookOfSpecters extends Spell {


    @Override
    public void accept(Visitor visitor, ArrayList<Minion> battleGround, ArrayList<Cards> handsCards,Minion target){
        visitor.visit(this,battleGround,handsCards);
    }



}
