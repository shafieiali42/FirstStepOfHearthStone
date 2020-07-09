package Models.Cards.GameCards.SpellCards.UnoptionalSpells;


import Models.Heroes.Heroes;
import Visitors.CardVisitors.Visitor;
import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Cards.CardClasses.Spell;

import java.util.ArrayList;

public class Polymorph extends Spell {






    @Override
    public void accept(Visitor visitor, ArrayList<Minion> battleGround, ArrayList<Cards> handsCards, ArrayList<Cards>deckCards, Minion target, Heroes targetHero, Minion summonedMinion,String alliance){
        visitor.visit(this,battleGround,target,alliance);
    }


}
