package Models.Cards.GameCards.SpellCards;


import Interfaces.Visitor;
import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Cards.CardClasses.Spell;

import java.util.ArrayList;

public class Polymorph extends Spell {






    @Override
    public void accept(Visitor visitor, ArrayList<Minion> battleGround, ArrayList<Cards> handsCards,Minion target,Minion summonedMinion){
        visitor.visit(this,battleGround,target);
    }


}
