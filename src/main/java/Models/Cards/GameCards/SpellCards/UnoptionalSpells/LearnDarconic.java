package Models.Cards.GameCards.SpellCards.UnoptionalSpells;

import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Cards.CardClasses.Spell;
import Models.Heroes.Heroes;
import Visitors.CardVisitors.Visitor;

import java.util.ArrayList;

public class LearnDarconic extends Spell {


    @Override
    public void accept(Visitor visitor, ArrayList<Minion> battleGround,
                       ArrayList<Cards> handsCards, ArrayList<Cards> deckCards,
                       Minion target, Heroes targetHero, Minion summonedMinion, Cards playingCard,String alliance) {

        visitor.visit(this,battleGround,playingCard);

    }



}
