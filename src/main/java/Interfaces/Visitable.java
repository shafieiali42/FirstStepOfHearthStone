package Interfaces;

import Models.Cards.CardClasses.Cards;
import Models.Cards.CardClasses.Minion;

import java.util.ArrayList;

public interface Visitable {
    void accept(Visitor visitor, ArrayList<Minion> battleGround, ArrayList<Cards> handsCards,ArrayList<Cards>deckCards,Minion target,Minion summonedMinion);
}
