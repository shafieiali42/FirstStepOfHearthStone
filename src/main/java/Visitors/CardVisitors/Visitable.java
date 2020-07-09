package Visitors.CardVisitors;

import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;
import Models.Heroes.Heroes;
import Visitors.CardVisitors.Visitor;

import java.util.ArrayList;

public interface Visitable {
    void accept(Visitor visitor, ArrayList<Minion> battleGround, ArrayList<Cards> handsCards,
                ArrayList<Cards>deckCards, Minion target, Heroes targetHero, Minion summonedMinion,String alliance);
}
